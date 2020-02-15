package com.CapG.DelighttOrder.dto;

public class RawMaterialStockdto {
	String name;
	String supplierId;
	double pricePerUnit;
	
	public RawMaterialStockdto(String name,String supplierid,double pricePerUnit)
	{
		this.name = name;
		this.supplierId = supplierid;
		this.pricePerUnit = pricePerUnit;
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