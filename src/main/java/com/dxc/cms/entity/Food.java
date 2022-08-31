package com.dxc.cms.entity;

public class Food {
	
	private Integer fId;
	private String fDesc;
	private Double fUnitPrice;
	
	public Food() {}
	public Food(Integer fId, String fDesc, Double fUnitPrice) {
		this.fId=fId;
		this.fDesc=fDesc;
		this.fUnitPrice=fUnitPrice;
	}
	public Integer getfId() {
		return fId;
	}
	public void setfId(Integer fId) {
		this.fId = fId;
	}
	public String getfDesc() {
		return fDesc;
	}
	public void setfDesc(String fDesc) {
		this.fDesc = fDesc;
	}
	public Double getfUnitPrice() {
		return fUnitPrice;
	}
	public void setfUnitPrice(Double fUnitPrice) {
		this.fUnitPrice = fUnitPrice;
	}
	@Override
	public String toString() {
		return "Food [fId=" + fId + ", fDesc=" + fDesc + ", fUnitPrice=" + fUnitPrice + "]";
	}		
}