package com.bjsxt.pojo;

import java.util.Date;

/**
 * 审核类
 * @author Administrator
 *
 */
public class Auditing {

	private int auditId; //审核编号
	private int expId; //报销单编号
	private String empId;//审核人的编号
	
	private String result;//审核结果   通过   打回  拒绝
	private String auditDesc; //审核意见
	private Date  time;
	
	
	
	
	public Auditing(int expId, String empId, String result, String auditDesc,
			Date time) {
		super();
		this.expId = expId;
		this.empId = empId;
		this.result = result;
		this.auditDesc = auditDesc;
		this.time = time;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public Auditing() {
		super();
	}

	public int getAuditId() {
		return auditId;
	}

	public void setAuditId(int auditId) {
		this.auditId = auditId;
	}

	public int getExpId() {
		return expId;
	}

	public void setExpId(int expId) {
		this.expId = expId;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getAuditDesc() {
		return auditDesc;
	}

	public void setAuditDesc(String auditDesc) {
		this.auditDesc = auditDesc;
	}

	public Auditing(int auditId, int expId, String empId, String result,
			String auditDesc) {
		super();
		this.auditId = auditId;
		this.expId = expId;
		this.empId = empId;
		this.result = result;
		this.auditDesc = auditDesc;
	}

	@Override
	public String toString() {
		return "Auditing [auditId=" + auditId + ", expId=" + expId + ", empId="
				+ empId + ", result=" + result + ", auditDesc=" + auditDesc
				+ ", time=" + time + "]";
	}
	
	
	
	
	
	
}
