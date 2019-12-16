package cn.com.sinosafe.common.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

/**
 * 该类用于获取各个类型的自动生成的标号信息，如果需要，请自行扩展
 * @author dumh
 *
 */
public class SequenceUtil {
	
	private static List<String> grtTypeList = new ArrayList<String>();
	static{
		grtTypeList.add("30");//保证
		grtTypeList.add("10");//抵押
		grtTypeList.add("20");//质押
	}
	
	private static String[] LATTER_UP = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
	private static String[] LATTER_DOWN = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
	/**
	 * 合同编号：HT+产品编号（2位：01速捷货、02其他微贷）+日期（8位：YYYYMMDD）+流水（6位）；总共：18位
	 * @param bizType 01速捷货、02其他微贷
	 * @param  connection
	 * @return
	 */
	public static synchronized String getContNo(String bizType, Connection connection) {
		if(!"01".equals(bizType) && !"02".equals(bizType)) throw new IllegalArgumentException("the param 'bizType' is Illegal");
		//bizType = String.format("%1$8s",bizType.trim()).replaceAll("\\s", "0");//%1$:第一个参数开始格式化，8:长度至少为8
		return "HT" + bizType + getCurrentDate_yyyymmdd() + querySequenceFromDB("CTR_CONT_SEQ", connection);
	}
	/**
	 * 合同编号：PK+日期（8位：YYYYMMDD）+流水（6位）；总共：16位
	 * @param  connection
	 * @return
	 */
	public static synchronized String getContPrintNo(Connection connection) {
		return "PK" + getCurrentDate_yyyymmdd() + querySequenceFromDB("CTR_CONT_SEQ", connection);
	}
	/**
	 * 担保合同编号：DB+担保类型（2位：保证30、抵押10、质押20）+日期（8位：YYYYMMDD）+流水（6位）;总共：18位
	 * @param grtType担保类型
	 * @param connection
	 * @return
	 */
	public static synchronized String getGuarantyContNo(String grtType, Connection connection) {
		if(!grtTypeList.contains(grtType)) throw new IllegalArgumentException("the param 'grtType' is Illegal");
		return "DB" + grtType + getCurrentDate_yyyymmdd() + querySequenceFromDB("GRT_CONT_SEQ", connection);
	}
	/**
	 * 业务申请流水号生成
	 * @param grtType担保类型
	 * @param connection
	 * @return
	 */
	public static synchronized String getWXSerno(Connection connection) {
		
		return "WXSQ" + getCurrentDate_yyyymmdd() + querySequenceFromDB("WX_SERNO_VALUE", connection);
	}
	
	/**
	 * 投保单申请流水号生成
	 * 
	 * */
	public static synchronized String getLSTSerno(Connection connection) {
		return "LSTI"+ getCurrentDate_yyyymmdd() + querySequenceFromDB("LS_SERNO_VALUE", connection);
	}
	
	/**
	 * 交易流水号生成
	 * 
	 * */
	public static synchronized String getLSTCubSerno(Connection connection) {
		return "LB"+ getCurrentDate_yyyymmdd() + querySequenceFromDB("LST_CUB_VALUE", connection);
	}
	/**
	 * 微信接口，生成客户号
	 * */
	public static synchronized String getCusNo(Connection connection) {
		return "CUS" + getCurrentDate_yyyy() +  querySequenceFromDB("CUSCODE_ALL", connection);
	}
	/**
	 * fico记录表流水号生成
	 * 
	 * */
	public static synchronized String getFicoSerno(Connection connection) {
		return "FICO"+ getCurrentDate_yyyymmdd() + querySequenceFromDB("FICO_SERNO_VALUE", connection);
	}
	
	/**
	 * 抵质押物编号：D+抵质押物类型（2位：抵押10、质押20）+日期（8位：YYYYMMDD）+流水（6位）总共：17位
	 * @param grtType抵质押物类型
	 * @param connection
	 * @return
	 */
	public static synchronized String getGuarantyId(String grtType, Connection connection) {
		if(!grtTypeList.contains(grtType)) throw new IllegalArgumentException("the param 'grtType' is Illegal");
		return "D" + grtType + getCurrentDate_yyyymmdd() + querySequenceFromDB("GRT_ID_SEQ", connection);
	}
	/**
	 * 财报 自定义项目编号: CUS+流水（6位）；总共：9位
	 * @param  connection
	 * @return
	 */
	public static synchronized String getFncCusItemNo(Connection connection) {
		return "CUS" +  querySequenceFromDB("FNC_CUS_ITEM_SEQ", connection);
	}
	
	
	/**
	 * 获取合作方编号：编号规则：PRJ+年（8位YYYYMMDD）+6位流水号，总共：17位
	 * @param connection
	 * @return
	 */
	public static synchronized String getPrjCopNo(Connection connection) {
		return "PRJ" + getCurrentDate_yyyymmdd() + querySequenceFromDB("PRJ_ID_SEQ", connection);
	}
	/**
	 * 获取客户编号：编号规则：年月（6位YYYYMM）+6位流水号，总共：12位
	 * @param connection
	 * @return
	 */
	public static synchronized String getCusNo4HABX(Connection connection) {
		return getCurrentDate_yyyymm() + querySequenceFromDB("CUS_NO_HABX", connection);
	}
	
	/**
	 * 通用流水号:编号规则：LS+年（8位YYYYMMDD）+6位流水号，总共：17位
	 * @param connection
	 * @return
	 * @
	 */
	public static synchronized String getSerialNo(Connection connection) {
		return "LS" + getCurrentDate_yyyymmdd() + querySequenceFromDB("ACC_DETAIL_SEQ", connection);
	}
	
	
	/**
	 * 征信流水号:编号规则：ZX+年（8位YYYYMMDD）+6位流水号，总共：17位
	 * @param connection
	 * @return
	 * @
	 */
	
	public static synchronized String getZXSerialNo(Connection connection) {
		return "ZX" + getCurrentDate_yyyymmdd() + querySequenceFromDB("IQP_ZX_ALL", connection);
	}
	
	/**
	 * 征信报告编号:编号规则：ZXBG+年（8位YYYYMMDD）+6位流水号，总共：19位
	 * @param connection
	 * @return
	 * @
	 */
	
	public static synchronized String getZXBGSerialNo(Connection connection) {
		return "ZXBG" + getCurrentDate_yyyymmdd() + querySequenceFromDB("IQP_ZXBG", connection);
	}
	
	/**
	 * 生成出账申请的流水号
	 * @param connection	数据库连接
	 * @return	流水号
	 * @throws Exception
	 */
	public static synchronized String getPvpSerno(Connection connection) throws Exception{
		return "PVP" + getCurrentDate_yyyymmdd() + querySequenceFromDB("PVP_LS", connection);
	}
	
/*	public static void main(String[] args) {
		System.out.println(String.format("%1$6s","100").replaceAll("\\s", "0"));
		System.out.println(getPKValue());
		
	}*/
	
	public static synchronized String getCurrentDate_yyyymmdd(){
		return new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime());
	}
	public static synchronized String getCurrentDate_yyyymm(){
		return new SimpleDateFormat("yyyyMM").format(Calendar.getInstance().getTime());
	}
	
	public static synchronized String getCurrentDate_yyyy(){
		return new SimpleDateFormat("yyyy").format(Calendar.getInstance().getTime());
	}
	
	
	/**
	 * 获得五级分类任务的任务编号
	 * @param connection
	 * @return
	 * @throws Exception
	 */
	public static synchronized String getClassifyTaskNo(Connection connection) throws Exception{
		return "CLY" + getCurrentDate_yyyymmdd() + querySequenceFromDB("CLY_TASK_ID_SEQ", connection);
	}
	
	/**
	 * 生成还款账号变更的流水号
	 * @param connection	数据库连接
	 * @return	流水号
	 * @throws Exception
	 */
	public static synchronized String createSerno4PspChgReplayNo(Connection connection) throws Exception{
		return "PL" + getCurrentDate_yyyymmdd() + querySequenceFromDB("PSP_CHG_REPLAYNO", connection);
	}
	
	/**
	 * 受托支付账户序列
	 * @param connection	数据库连接
	 * @return	流水号
	 * @throws Exception
	 */
	public static synchronized String getPvpPaySerno(Connection connection) throws Exception{
		return "PP" + getCurrentDate_yyyymmdd() + querySequenceFromDB("PAY_LS", connection);
	}
	
	/**
	 * 生成还款计划变更的流水号
	 * @param connection	数据库连接
	 * @return	流水号
	 * @throws Exception
	 */
	public static synchronized String createSerno4PspChgPlan(Connection connection) throws Exception{
		return "PW" + getCurrentDate_yyyymmdd() + querySequenceFromDB("PSP_CHG_PLAN", connection);
	}
	/**
	 * 生成核心交易流水号[20yyyymmdd******]
	 * @param connection	数据库连接
	 * @return	流水号
	 * @throws Exception
	 */
	public static synchronized String createSerno4Trans(Connection connection) throws Exception{
		return "20"+getCurrentDate_yyyymmdd() + querySequenceFromDB("PSP_CHG_TRANS", connection);
	}
	
	/**
	 * 生成核心交易流水号[CAyyyymmdd******]会计科目变更使用
	 * @param connection	数据库连接
	 * @return	流水号
	 * @throws Exception
	 */
	public static synchronized String createSerno4TransByCA(Connection connection) throws Exception{
		return "CA"+getCurrentDate_yyyymmdd() + querySequenceFromDB("PSP_CHG_TRANS", connection);
	}
	/**
	 * 生成机构合并的流水号
	 * @param connection	数据库连接
	 * @return	流水号
	 * @throws Exception
	 */
	public static synchronized String createSerno4OrgMerge(Connection connection) throws Exception{
		return "OM" + getCurrentDate_yyyymmdd() + querySequenceFromDB("SEQ_ORG_MEGER", connection);
	}
	
	/**
	 * 贷后监控检查表流水号
	 * @param connection	数据库连接
	 * @return	流水号
	 * @throws Exception
	 */
	public static synchronized String getPspCheckSerialNo(Connection connection) throws Exception{
		return "PSP" + getCurrentDate_yyyymmdd() + querySequenceFromDB("PSP_CHK_SEQ", connection);
	}
	/**
	 * 催收记录表流水号
	 * @param connection	数据库连接
	 * @return	流水号
	 * @throws Exception
	 */
	public static synchronized String getPspPressSerialNo(Connection connection) throws Exception{
		return "PP" + getCurrentDate_yyyymmdd() + querySequenceFromDB("PSP_PRESS_SEQ", connection);
	}
	/**
	 * 理赔记录表流水号
	 * @param connection	数据库连接
	 * @return	流水号
	 * @throws Exception
	 */
	public static synchronized String getPspClaimSerialNo(Connection connection) throws Exception{
		return "PC" + getCurrentDate_yyyymmdd() + querySequenceFromDB("PSP_CLAIM_SEQ", connection);
	}
	/**
	 * 冲账确认表流水号
	 * @param connection	数据库连接
	 * @return	流水号
	 * @throws Exception
	 */
	public static synchronized String getPspBalSerialNo(Connection connection) throws Exception{
		return "PB" + getCurrentDate_yyyymmdd() + querySequenceFromDB("PSP_BAL_SEQ", connection);
	}
	/**
	 * 负赔申请流水号
	 * @param connection	数据库连接
	 * @return	流水号
	 * @throws Exception
	 */
	public static synchronized String getPspNegtSerialNo(Connection connection) throws Exception{
		return "PN" + getCurrentDate_yyyymmdd() + querySequenceFromDB("PSP_NEGT_SEQ", connection);
	}
	/**
	 * 追欠申请流水号
	 * @param connection	数据库连接
	 * @return	流水号
	 * @throws Exception
	 */
	public static synchronized String getPspOwedSerialNo(Connection connection) throws Exception{
		return "PO" + getCurrentDate_yyyymmdd() + querySequenceFromDB("PSP_NEGT_SEQ", connection);
	}
	/**
	 * 生成贷后变更核心交易业务流水号[DHBG+yyyymmdd+******]
	 * @param connection 数据库连接
	 * @return	贷后变更核心交易业务流水号
	 * @throws Exception
	 */
	public static synchronized String createBusiSerialNo4PspChg(Connection connection) throws Exception{
		return "DHBG" + getCurrentDate_yyyymmdd() + querySequenceFromDB("PSP_CHG_BSN", connection);
	}
	/**
	 * 生成贷后变更通用申请编号[BG00+yyyymmdd+******]
	 * @param connection 数据库连接
	 * @return	生成贷后变更通用申请编号
	 * @throws Exception
	 */
	public static synchronized String createComSerno4PspChg(Connection connection) throws Exception{
		return "BG00" + getCurrentDate_yyyymmdd() + querySequenceFromDB("PSP_CHG_COM", connection);
	}
	
	/**
	 * 生成会计科目号变更申请流水号[DHBG+yyyymmdd+******]
	 * @param connection 数据库连接
	 * @return	贷后变更核心交易业务流水号
	 * @throws Exception
	 */
	public static synchronized String createBusiSerialNo4PspChgSubject(Connection connection) throws Exception{
		return "PCS" + getCurrentDate_yyyymmdd() + querySequenceFromDB("PSP_CHG_SUBJECT", connection);
	}
	
	/**
	 * 生成业绩流水号
	 * @param connection	数据库连接
	 * @return	流水号
	 * @throws Exception
	 */
	public static synchronized String createBusinessSaleNo(Connection connection) throws Exception{
		return "YJ" + getCurrentDate_yyyymmdd() + querySequenceFromDB("YJGL_YJ_NO", connection);
	}
	/**
	 * 校园金融公共流水号生成方法
	 * @param connection	数据库连接
	 * @return	流水号
	 * @throws Exception
	 */
	public static synchronized String createXYJRSaleNo(Connection connection) throws Exception{
		return "XY" + getCurrentDate_yyyymmdd() + querySequenceFromDB("XYJR_SERNO", connection);
	}
	/**
	 * 生成商圈流水号 ＝ C + 6位年月日 + 6位序列号
	 * @param connection	数据库连接
	 * @return	流水号
	 * @throws Exception
	 */
	public static synchronized String createChannelNo(Connection connection) throws Exception{
		return "C" + getCurrentDate_yyyymmdd() + querySequenceFromDB("CHANNEL_NO", connection);
	}
	/**
	 * 生成个分险黑名单 ＝ LSGFX + 6位年月日 + 6位序列号
	 * @param connection	数据库连接
	 * @return	流水号
	 * @throws Exception
	 */
	public static synchronized String createBlkNo4GFX(Connection connection) throws Exception{
		return "LSGFX" + getCurrentDate_yyyymmdd() + querySequenceFromDB("BLKNO4GFX", connection);
	}
	/**
	 * 生成个分险外键（投保单、承保清单键） ＝ FK + 6位年月日 + 6位序列号
	 * @param connection	数据库连接
	 * @return	流水号
	 * @throws Exception
	 */
	public static synchronized String createLstFK4GFX(Connection connection) throws Exception{
		return "FK" + getCurrentDate_yyyymmdd() + querySequenceFromDB("LST_FK_GFX", connection);
	}
	
	/**
	 * 报文服务器流水号
	 * @param connection
	 * @return
	 * @throws Exception
	 */
	public static synchronized String getSvrSeqNo(Connection connection) throws Exception{
		return "S" + getCurrentDate_yyyymmdd() + querySequenceFromDB("SVR_SEQ_NO", connection);
	}
	
	/**
	 * 合作方接口交易流水号
	 * @param connection
	 * @return
	 * @throws Exception
	 */
	public static synchronized String getReqSeqNo(Connection connection) throws Exception{
		return "R" + getCurrentDate_yyyymmdd() + querySequenceFromDB("REQ_SEQ_NO", connection);
	}
	
	/**
	 * 个分险借据号生成规则
	 * @param prdType 商品大类
	 * @return
	 */
	public static String getGfxBillNo(String goodType,Connection connection)  {
		return goodType + getCurrentDate_yyyymmdd() + querySequenceFromDB2("GFX_BILL_NO","6",connection);
	}
	
	/**
	 * 获取实时交易的报文流水号
	 * @param connection
	 * @return
	 * @throws Exception
	 */
	public synchronized static String getReportID(Connection connection) throws Exception{
		PreparedStatement ps = null;
		ResultSet rs = null;
		String querySQL = "select to_char(SEQ_REPORT_ID.nextval) from dual";
		String reportID = null;
		try{
			ps = connection.prepareStatement(querySQL);
			rs = ps.executeQuery();
			if(rs.next()) reportID = rs.getString(1);
		}catch(SQLException e){
			reportID = new SimpleDateFormat("yyyyMMddHHmmss").format(Calendar.getInstance().getTime());//应急方案而已
			throw e;
		}finally{
			try{
				if(rs != null){
					rs.close();
					rs = null;
				}
			}catch(SQLException e){e.printStackTrace();}
			try{
				if(ps != null){
					ps.close();
					ps = null;
				}
			}catch(SQLException e){e.printStackTrace();}
		}
		return reportID;
	}
	
	public static synchronized String getInBoundNo(Connection connection) {
		return "RK" + getCurrentDate_yyyymmdd() + querySequenceFromDB("IN_STORE", connection);
	}
	/**
	 * 获取核保结构表的流水号 4位产品号+4位年份+4位所属机构+6位流水号
	 * @param connection
	 * @return
	 * @throws Exception
	 */
	
	public synchronized static String getGuaranteeSerno(Connection connection, String ins_code, String s_organno) {
		return ins_code + getCurrentDate_yyyy() + s_organno + querySequenceFromDB("GUAR_SERNO_NO", connection);
	}
	
	/**
	 * 
	 * @param connection
	 * @return
	 * @
	 */
	public static synchronized String getDispatchNo(Connection connection) {
		return "XB" + getCurrentDate_yyyymmdd() + querySequenceFromDB("CLAIM_DIS_SEQ", connection);
	}
	
	/**
	 * 流程表主键
	 * @param connection
	 * @return
	 * @throws Exception
	 */
	public static synchronized String createWfiPK(Connection connection) throws Exception{
		return "WFI"+getCurrentDate_yyyymmdd() + querySequenceFromDB("WFI_SEQ", connection);
	}
	
	/**
	 * 生成流程号
	 * @param connection
	 * @return
	 * @throws Exception
	 */
	public static synchronized String createWfiWfNo(Connection connection) throws Exception{
		return querySequenceFromDB2("WFI_WF_SEQ", "3", connection);
	}
	
	/**
	 * 生成流程审批节点号
	 * @param connection
	 * @return
	 * @throws Exception
	 */
	public static synchronized String createWfiNodeNo(Connection connection) throws Exception{
		return "a" +  querySequenceFromDB2("WFI_NODE_SEQ", "2", connection);
	}
	
	/**
	 * 业务编码（1位：理赔取4） + 部门号（4位）（根据八位机构代码取内部4位机构码） + 年份（4位） + 产品品种 + "00000" + 自增nextKey
	 * @param connection
	 * @return
	 * @
	 */
	public static synchronized String getClaimNo(String deptNo, String prdId, Connection connection) {
		return "4" + deptNo + getCurrentDate_yyyy() + prdId + "00000" +querySequenceFromDB2("CLAIM_NO_SEQ", "4", connection);
	}
	
	/**
	 * 保险责任类别信息 + 自增nextKey
	 * @param connection
	 * @return
	 * @
	 */
	public static synchronized String getInsuranceNo(Connection connection) {
		return "I" + getCurrentDate_yyyymmdd() + querySequenceFromDB("INSURANCE_ID_SEQ", connection);
	}
	
	/**
	 * 项目信息 + 自增nextKey
	 * @param connection
	 * @return
	 * @
	 */
	public static synchronized String getProjectNo(Connection connection) {
		return "P" + getCurrentDate_yyyymmdd() + querySequenceFromDB("Project_ID_SEQ", connection);
	}
	
	/**
	 * backletter_id :年月日+6位序列
	 * @param connection
	 * @return
	 * @
	 */
	public static synchronized String getBackletterId(Connection connection) {
		return getCurrentDate_yyyymmdd()+querySequenceFromDB("SEQ_BACKLETTER_ID", connection);
	}
	
	private static synchronized String querySequenceFromDB(String sequenceName, Connection connection)  {
		String sqlStr = null;
		ResultSet rs = null;
		String cur_sernum=null;
		Statement stmt = null;
		try{
			sqlStr = "select to_char("+sequenceName+".nextval) from dual";
			stmt = connection.createStatement();
			rs = stmt.executeQuery(sqlStr);
			if(rs == null){
			}
			
			if(rs.next()){
				cur_sernum = rs.getString(1);
				cur_sernum = String.format("%1$6s",cur_sernum).replaceAll("\\s", "0");
			}else{
			}
		}catch(Exception e){
			
		}finally {
			if(rs != null){
				try {
					rs.close();
				} catch (SQLException e) {}
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {}
			}
			return cur_sernum;
		}
	}
	
	/**
	 * 
	 * @param sequenceName
	 * @param num  补充为x位数
	 * @param connection
	 * @return
	 * @
	 */
	private static synchronized String querySequenceFromDB2(String sequenceName, String num, Connection connection)  {
		String sqlStr = null;
		ResultSet rs = null;
		String cur_sernum=null;
		Statement stmt = null;
		try{
			sqlStr = "select to_char("+sequenceName+".nextval) from dual";
			stmt = connection.createStatement();
			rs = stmt.executeQuery(sqlStr);
			if(rs == null){
			}
			
			if(rs.next()){
				cur_sernum = rs.getString(1);
				cur_sernum = String.format("%1$"+num+"s",cur_sernum).replaceAll("\\s", "0");
			}else{
			}
		}catch(Exception e){
		}finally {
			if(rs != null){
				try {
					rs.close();
				} catch (SQLException e) {}
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {}
			}
			return cur_sernum;
		}
	}
	
	
	
	public static synchronized String getPKValue(){
		String pkValue = "";
		
		Random r = new Random();
		for(int i = 0;i<=31;i++){
			double type = Math.random()*10;
			if(type>=5){
				
				pkValue+=LATTER_UP[r.nextInt(26)];
				
			}else{
				
				pkValue+=LATTER_DOWN[r.nextInt(26)];
				
			}
			
		}
		
		
		return pkValue;
		
		
	}
	
	 public static synchronized String getPkId(Connection connection)  {  
	       //当前系统时间戳精确到毫秒  
	       Long simple=System.currentTimeMillis();  
	       //三位随机数  
	       int random=new Random().nextInt(900)+100;//为变量赋随机值100-999;  
	       return "LOP"+getCurrentDate_yyyymmdd()+ querySequenceFromDB("FNC_CUS_ITEM_SEQ", connection);    
	 } 
	 
	 
	 
	 //根据指定长度生成字母和数字的随机数
	    //0~9的ASCII为48~57
	    //A~Z的ASCII为65~90
	    //a~z的ASCII为97~122
	    public static synchronized String createRandomCharData(int length)
	    {
	        StringBuilder sb=new StringBuilder();
	        Random rand=new Random();//随机用以下三个随机生成器
	        Random randdata=new Random();
	        int data=0;
	        for(int i=0;i<length;i++)
	        {
	            int index=rand.nextInt(3);
	            //目的是随机选择生成数字，大小写字母
	            switch(index)
	            {
	            case 0:
	                 data=randdata.nextInt(10);//仅仅会生成0~9
	                 sb.append(data);
	                break;
	            case 1:
	                data=randdata.nextInt(26)+65;//保证只会产生65~90之间的整数
	                sb.append((char)data);
	                break;
	            case 2:
	                data=randdata.nextInt(26)+97;//保证只会产生97~122之间的整数
	                sb.append((char)data);
	                break;
	            }
	        }
	        String result=sb.toString();
	        return result;
	    }
	                       
	   



}
