package cn.com.sinosafe.domain.bean;

/**
 * 
 * 马上消费状态枚举 <br>
 * @Author : ChenLiang <br>
 * @Date : 2019年9月3日<br>
 */
public enum MsxfStatus {
	
	核保申请		(MsxfNextStatus.待核保.name()),
	核保通过		(MsxfNextStatus.待放款.name()),
	核保拒绝		(""),
	放款结果通知	(MsxfNextStatus.待出单.name()),
	已出单		(""),
	已取消		(""),
	核赔申请		(MsxfNextStatus.待核赔.name()),
	核赔通过		(MsxfNextStatus.待理赔核销.name()),
	核赔拒绝		(""),
	代偿结清		(MsxfNextStatus.待追偿.name()),
	正常结清		(""),
	提前结清		(""),
	追偿结清		("");
	
	private String next;
	
//	private MsxfStatus() {
//	}
	
	private MsxfStatus(String next) {
		this.next = next;
	}

	public String getNext() {
		return next;
	}

	public void setNext(String next) {
		this.next = next;
	}
	

}
