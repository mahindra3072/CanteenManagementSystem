package com.dxc.cms.entity;

public class Customer {

	private Integer cId;
	private String cName;
	private String cPhone;
	private String cEmail;
	private Double cWalletBalance;
	
	public Customer() {}
	public Customer(Integer cId, String cName, String cPhone, String cEmail, Double cWalletBalance) {
		this.cId=cId;
		this.cName=cName;
		this.cPhone=cPhone;
		this.cEmail=cEmail;
		this.cWalletBalance=cWalletBalance;
	}
	
	public Integer getcId() {
		return cId;
	}
	public void setcId(Integer cId) {
		this.cId = cId;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public String getcPhone() {
		return cPhone;
	}
	public void setcPhone(String cPhone) {
		this.cPhone = cPhone;
	}
	public String getcEmail() {
		return cEmail;
	}
	public void setcEmail(String cEmail) {
		this.cEmail = cEmail;
	}
	public Double getcWalletBalance() {
		return cWalletBalance;
	}
	public void setcWalletBalance(Double cWalletBalance) {
		this.cWalletBalance = cWalletBalance;
	}
	@Override
	public String toString() {
		return "Customer [cId=" + cId + ", cName=" + cName + ", cPhone=" + cPhone + ", cEmail=" + cEmail
				+ ", cWalletBalance=" + cWalletBalance + "]";
	}
}