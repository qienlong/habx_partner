package cn.com.sinosafe.service.xd.impl;

import cn.com.sinosafe.common.config.SystemConfig;
import cn.com.sinosafe.common.util.*;
import cn.com.sinosafe.dao.*;
import cn.com.sinosafe.domain.entity.CopFileBatchDeal;
import cn.com.sinosafe.domain.entity.CopFiledate;
import cn.com.sinosafe.domain.entity.IqpMeApiCop;
import cn.com.sinosafe.lina.common.protocol.JsonProtocol;
import cn.com.sinosafe.lina.common.protocol.ResultCode;
import cn.com.sinosafe.service.xd.XdAsynService;
import cn.com.sinosafe.service.xd.XdService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import com.alibaba.fastjson.JSONObject;
import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service("xdPostLoanUpload4Hmyh")
@Async
public class XdPostLoanUpload4Hmyh implements XdService<JsonProtocol, JSONObject>{

    private final static Logger logger = LoggerFactory.getLogger(XdPostLoanUpload4Hmyh.class);

    @Autowired
    private CopFileBatchDealMapper copFileBatchDealMapper;
    @Autowired
    private PartnerBusiImportDetailMapper pbiDetailMapper;
    @Autowired
    private SystemConfig systemConfig;
    @Autowired
    private IqpMeApiCopMapper iqpMeApiCopMapper;
    @Autowired
    private CopFiledateMapper copFiledateMapper;
    @Autowired
    private XdAsynService xdAsynService;

    /**
     * 将哈密银行资金方给的所有贷后文件筛选出渠道业务，再上传至ftp
     */
    public JsonProtocol process(JSONObject param) {
        try {
            // 获取需要上传贷后文件的accid
            String accids = systemConfig.getValue("cop_xd_accid");
            String[] accidList = accids.split(",");

            for (String accid : accidList) {
                IqpMeApiCop iqpMeApiCop = null;
                String date = null;
                String acc = accid + "_hmyh";
                try {
                    // 获取accid配置
                    iqpMeApiCop = iqpMeApiCopMapper.selectByAccid(accid);
                    logger.info("【"+iqpMeApiCop.getCopDesc()+"】【上传贷后文件】开始");
                    // 获取贷后配置参数
                    CopFileBatchDeal batchDeal = copFileBatchDealMapper.selectByPrimaryKey(acc);
                    // 获取文件地址
                    CopFiledate copFileDate = copFiledateMapper.selectByPrimaryKey(acc);
                    // 获取贷后文件处理日期
                    date =  copFileDate.getFiledate();
                    int hours = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
                    // 到八点不管有没有数据都更新日期
                    if(hours == 20) {
                        logger.info("4、晚上20点日切");
                        changeDate(copFileDate);
                        continue;
                    }
                    // 已经切日的不用处理
                    if(!StringUtils.equals(copFileDate.getFiledate(),copFileDate.getCutDate())){
                        logger.info("{}已处理",acc);
                        continue;
                    }

                    //ftp文件路劲
                    String ftpPath = batchDeal.getDownloadPath() + "/" +date.replace("-","");
                    //哈密文件名
                    String fileName = "habx_all_"+ date.replace("-", "") + ".tar.gz";
                    File localGZFile = FtpUtils.downloadFile(ftpPath + "/" + fileName,date,batchDeal.getFtpType(),
                            batchDeal.getFtpHost(), batchDeal.getFtpPort(), batchDeal.getFtpUsername(), batchDeal.getFtpPwd(),batchDeal.getLocatePath());

                    // 资金方所有贷后文件放置的本地文件夹
                    String locatePath = batchDeal.getLocatePath() + "/" + date;
                    // 解压文件
                    GZipUtils.unTarGz(localGZFile, locatePath);
                    File[] tmpFiles = new File(locatePath).listFiles();

                    // 查询所有业务借据号
                    List<String> list = pbiDetailMapper.selectBusiBillNos4HaoSen(iqpMeApiCop.getCopNo());

                    // 从本地文件中筛选
                    List<String> mustUploadFiles = new ArrayList<>();
                    // 日期文件夹以当前时间为准
                    String locateDate = DateUtils.getAddDayDate(date, 1);
                    // 筛选后放置的本地文件夹
                    String locatePathForBusiCop = locatePath + "/" + "_upload";
                    File fileFold = new File(locatePathForBusiCop);
                    if (!fileFold.exists()) {
                        fileFold.mkdirs();
                    }

                    // 筛选txt文件
                    if(!ObjectUtils.isEmpty(tmpFiles)){
                        for (File file : tmpFiles) {
                            String fileName_ = file.getName();
                            if(fileName_.endsWith(".txt")){
                                // 读取内容，筛选，并写入新的文件
                                FileUtils.choose(list, fileName_, mustUploadFiles, file.getPath(), locatePathForBusiCop);
                            }
                        }

                        // 上传文件
                        SftpUtils.uploadFiles(batchDeal.getUploadPath() + "/" + "after/hmyh", null, mustUploadFiles, locateDate,iqpMeApiCop);
                    }

                    // 删除临时文件
                    FileUtils.deleteDir(new File(batchDeal.getLocatePath()));


                    logger.info("【"+iqpMeApiCop.getCopDesc()+"】【上传贷后文件】成功上传【" + mustUploadFiles.size() + "】个文件");

//					if(!locateDate.equals(DateUtils.getDate())) {
//						throw new Exception("业务日期与当前日相差不止一天");
//					}

                    CopFiledate cf = new CopFiledate();
                    cf.setCopname(acc);
                    cf.setCutDate(DateUtils.getAddDayDate(date,1));
                    copFiledateMapper.updateByPrimaryKeySelective(cf);

                } catch (Exception e) {
                    logger.error("【"+iqpMeApiCop.getCopDesc()+"】【上传贷后文件】异常", e);
                    xdAsynService.addMsgResult(StringUtils.uuid(),accid,"0", "【"+DateUtils.getDate1()+"】【上传贷后文件】失败，原因为：\n"+ e.getMessage());
                    return new JsonProtocol().setup(0,"上传贷后文件异常"+e.getMessage());
                }

                // 不管成功或失败，都更新日期
                // 获取当前时
//				int hours = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
//				if(hours == 20){
//                    CopFiledate cf = new CopFiledate();
//                    cf.setCopname(acc);
//                    cf.setCutDate(DateUtils.getAddDayDate(date,1));
//                    copFiledateMapper.updateByPrimaryKeySelective(cf);
//				}
            }
        } catch (Exception e) {
            logger.error("【上传贷后文件】异常", e);
        }
        return new JsonProtocol().setup(ResultCode.SUCCESS);
    }

    /**
     * <p>Title: changeDate</p>
     * <p>Description: 日切</p>
     * @throws Exception
     */
    private void changeDate(CopFiledate copFileDate) {
        try{
            CopFiledate cf = new CopFiledate();
            cf.setCopname(copFileDate.getCopname());
            if (StringUtils.equals(copFileDate.getFiledate(), copFileDate.getCutDate())) {
                cf.setFiledate(DateUtils.getAddDayDate(copFileDate.getCutDate(),1));
                cf.setCutDate(DateUtils.getAddDayDate(copFileDate.getCutDate(),1));
            } else {
                cf.setFiledate(DateUtils.getAddDayDate(copFileDate.getFiledate(),1));
            }
            copFiledateMapper.updateByPrimaryKeySelective(cf);
        }catch (Exception e){

        }
    }
}
