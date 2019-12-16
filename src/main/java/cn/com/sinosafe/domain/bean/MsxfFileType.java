package cn.com.sinosafe.domain.bean;

import cn.com.sinosafe.common.util.StringUtils;

/**
 * 
 * 马上消费文件类型对应枚举 <br>
 * @Author : ChenLiang <br>
 * @Date : 2019年9月3日<br>
 */
public enum MsxfFileType {

	证件正面		("0101","XFD_00201"),
	证件反面		("0102","XFD_00201"),
	投保单		("05",	"XFD_T170205"),
	人脸识别影像	("02",	"XFD_00201"),
	借据合同		("06",	"XFD_T170201");
	
	private String msxfType;
	private String haType;
	
	/**
	 * 根据马上文件类型获取华安影像目录
	 * @param msxfType
	 * @return
	 */
	public static String getHaType(String msxfType) {
		String haType = null;
		for (MsxfFileType fileType : MsxfFileType.values()) {
			if(StringUtils.equals(fileType.getMsxfType(), msxfType)) {
				haType = fileType.getHaType();
				break;
			}
		}
		return haType;
	}
	
	private MsxfFileType(String msxfType,String haType) {
		this.msxfType = msxfType;
		this.haType = haType;
	}

	public String getMsxfType() {
		return msxfType;
	}

	public void setMsxfType(String msxfType) {
		this.msxfType = msxfType;
	}

	public String getHaType() {
		return haType;
	}

	public void setHaType(String haType) {
		this.haType = haType;
	}
	
	
}
