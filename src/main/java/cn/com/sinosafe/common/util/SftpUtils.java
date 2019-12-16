package cn.com.sinosafe.common.util;

import cn.com.sinosafe.common.config.constant.SFTPConstants;
import cn.com.sinosafe.domain.entity.IqpMeApiCop;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.SftpException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ObjectUtils;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @version 1.0
 * @Description
 * @auther 林良
 * @Date 2019-11-11
 */
public class SftpUtils {

    private final static Logger logger = LoggerFactory.getLogger(SftpUtils.class);

    public static void uploadFiles(String basePath, String path, List<String> filePaths, String date, IqpMeApiCop iqpMeApiCop) throws Exception {
        logger.info("进入uploadFiles方法");

        if (!ObjectUtils.isEmpty(filePaths)) {

            if("sftp".equalsIgnoreCase(iqpMeApiCop.getFtpType())) {
                // 设置主机ip，端口，用户名，密码
                Map<String, String> sftpDetails = new HashMap<String, String>();
                sftpDetails.put(SFTPConstants.SFTP_REQ_HOST, iqpMeApiCop.getFtpHost());
                sftpDetails.put(SFTPConstants.SFTP_REQ_USERNAME, iqpMeApiCop.getFtpAcc());
                sftpDetails.put(SFTPConstants.SFTP_REQ_PASSWORD, iqpMeApiCop.getFtpPwd());
                sftpDetails.put(SFTPConstants.SFTP_REQ_PORT, iqpMeApiCop.getFtpPort());

                SFTPChannel channel = new SFTPChannel();

                logger.info("=================" + sftpDetails);

                for (String filePath : filePaths) {
                    String src = filePath;

                    String dst = basePath + "/"  + (StringUtils.isEmpty(path) ? "" : path);
                    if(StringUtils.isNotEmpty(date)) {
                        dst = basePath + "/" + date.replace("-", "") + (StringUtils.isEmpty(path) ? "" : ("/"+path));
                    }

                    logger.info("===========开始连接sftp=============");
                    ChannelSftp chSftp = channel.getChannel(sftpDetails, 60000);
                    logger.info("===========完成连接sftp=============");
                    // 创建目录
                    try {
                        chSftp.cd(dst);
                    } catch (SftpException e) {
                        chSftp.mkdir(dst);
                        chSftp.cd(dst);
                    }

                    dst = dst + "/" + filePath.split("\\/")[(filePath.split("\\/").length - 1)];
                    chSftp.put(src, dst, 0);
                    chSftp.quit();

                    channel.closeChannel();

                    // 删除本地文件
                    new File(src).delete();
                }

            }else {
                for (String filePath : filePaths) {
                    int i = filePath.lastIndexOf("/");
                    String src = filePath.substring(0, i);
                    String dst = basePath + "/"  + (StringUtils.isEmpty(path) ? "" : path);
                    if(StringUtils.isNotEmpty(date)) {
                        dst = basePath + "/" + date.replace("-", "") + (StringUtils.isEmpty(path) ? "" : ("/"+path));
                    }
                    boolean f = FtpUtils.sendFile(iqpMeApiCop.getFtpHost(),
                            Integer.valueOf(iqpMeApiCop.getFtpPort()),
                            iqpMeApiCop.getFtpAcc(),
                            iqpMeApiCop.getFtpPwd(),
                            dst, src, filePath.substring(i+1));

                    // 删除本地文件
                    if(f) new File(filePath).delete();
                }

            }
        }

        logger.info("【"+iqpMeApiCop.getCopDesc()+"】完成uploadFiles方法");
    }
}
