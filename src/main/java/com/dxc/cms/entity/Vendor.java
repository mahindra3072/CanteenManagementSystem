package com.dxc.cms.entity;

public class Vendor {
	
	private Integer vId;
	private String vName;
	private String vPhone;
	private String vEmail;
	
	public Vendor() {}
	public Vendor(Integer vId, String vName, String vPhone, String vEmail) {
		this.vId=vId;
		this.vName=vName;
		this.vPhone=vPhone;
		this.vEmail=vEmail;
	}
	
	public Integer getvId() {
		return vId;
	}
	public void setvId(Integer vId) {
		this.vId = vId;
	}
	public String getvName() {
		return vName;
	}
	public void setvName(String vName) {
		this.vName = vName;
	}
	public String getvPhone() {
		return vPhone;
	}
	public void setvPhone(String vPhone) {
		this.vPhone = vPhone;
	}
	public String getvEmail() {
		return vEmail;
	}
	public void setvEmail(String vEmail) {
		this.vEmail = vEmail;
	}
	@Override
	public String toString() {
		return "Vendor [vId=" + vId + ", vName=" + vName + ", vPhone=" + vPhone + ", vEmail=" + vEmail + "]";
	}
}