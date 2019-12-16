/**   
* @Title:：PaExtendList.java 
* @Package ：cn.com.sinosafe.domain.dto 
* @Description： TODO
* @author：xiewei
* @date： 2019年6月3日 上午10:29:22 
* @version ： 1.0   
*/
package cn.com.sinosafe.domain.dto;

import java.util.List;

/** 
 * @ClassName:：PaExtendList 
 * @Description： TODO
 * @author ：xiewei
 * @date ：2019年6月3日 上午10:29:22  
 */
public class PaExtendList {
	/**
	 * 扩展值类型
	 */
	private String valueType;
	/**
	 * 搜索键
	 */
	private String searchKey;
	/**
	 * 扩展值1(存基本信息）
	 */
	private List<PaBasicValue> basicValue;
	/**
	 * 扩展值2(存其它信息）
	 */
	private String otherValue;
	
	public String getValueType() {
		return valueType;
	}
	public void setValueType(String valueType) {
		this.valueType = valueType;
	}
	public String getSearchKey() {
		return searchKey;
	}
	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}
	public List<PaBasicValue> getBasicValue() {
		return basicValue;
	}
	public void setBasicValue(List<PaBasicValue> basicValue) {
		this.basicValue = basicValue;
	}
	public String getOtherValue() {
		return otherValue;
	}
	public void setOtherValue(String otherValue) {
		this.otherValue = otherValue;
	}
	
}
