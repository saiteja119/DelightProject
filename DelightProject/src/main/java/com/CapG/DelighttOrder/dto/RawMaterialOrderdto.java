package com.CapG.DelighttOrder.dto;

import java.sql.Date;

public class RawMaterialOrderdto {
	private String orderid;
	private String name;
    private String supplierId;
	private double quantityValue;
	private double pricePerUnit;
	private double totalPrice; 
//	private String deliveryStatus;
	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}
	public double getQuantityValue() {
		return quantityValue;
	}
	public void setQuantityValue(double quantityValue) {
		this.quantityValue = quantityValue;
	}

	public double getPricePerUnit() {
		return pricePerUnit;
	}
	public void setPricePerUnit(double pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
//	public String getDeliveryStatus() {
//		return deliveryStatus;
//	}
//	public void setDeliveryStatus(String deliveryStatus){
//		this.deliveryStatus = deliveryStatus;
//	}
}