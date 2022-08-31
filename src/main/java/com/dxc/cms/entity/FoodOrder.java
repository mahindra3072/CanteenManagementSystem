package com.dxc.cms.entity;

import java.time.LocalDateTime;

public class FoodOrder {
	
	private Integer cId;
	private Integer vId;
	private Integer fId;
	private LocalDateTime orderDate;
	private String orderStatus;
	private String remark;

	public FoodOrder() {}
	public FoodOrder(Integer cId, Integer vId, Integer fId, LocalDateTime orderDate) {
		this.cId=cId;
		this.vId=vId;
		this.fId=fId;
		this.orderDate=orderDate;
	}
	
	public Integer getcId() {
		return cId;
	}
	public void setcId(Integer cId) {
		this.cId = cId;
	}
	public Integer getvId() {
		return vId;
	}
	public void setvId(Integer vId) {
		this.vId = vId;
	}
	public Integer getfId() {
		return fId;
	}
	public void setfId(Integer fId) {
		this.fId = fId;
	}
	public LocalDateTime getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "FoodOrder [cId=" + cId + ", vId=" + vId + ", fId=" + fId + ", orderDate=" + orderDate + ", orderStatus="
				+ orderStatus + ", remark=" + remark + "]";
	}
}
