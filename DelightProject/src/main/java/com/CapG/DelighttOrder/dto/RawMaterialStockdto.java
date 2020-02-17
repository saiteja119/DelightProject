package com.CapG.DelighttOrder.dto;

public class RawMaterialStockdto {
	String name;
	String supplierId;
	double pricePerUnit;
	double quantity;
	

	public RawMaterialStockdto(String name,String supplierid,double pricePerUnit,double quantity)
	{
		this.name = name;
		this.supplierId = supplierid;
		this.pricePerUnit = pricePerUnit;
		this.quantity =quantity;
	}
	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
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
	public double getPricePerUnit() {
		return pricePerUnit;
	}
	public void setPricePerUnit(double pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}
}