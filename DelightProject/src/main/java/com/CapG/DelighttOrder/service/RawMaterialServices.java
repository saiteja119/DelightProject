package com.CapG.DelighttOrder.service;

import java.util.Map;

import com.CapG.DelighttOrder.dto.RawMaterialOrderdto;
import com.CapG.DelighttOrder.dto.RawMaterialStockdto;
import com.CapG.DelighttOrder.exception.InvalidIdException;
import com.CapG.DelighttOrder.exception.InvalidNameException;
import com.CapG.DelighttOrder.exception.InvalidPriceException;
import com.CapG.DelighttOrder.exception.InvalidQuantityException;
import com.CapG.DelighttOrder.exception.InvalidSupplierIdException;

public interface RawMaterialServices {
	public boolean idValidation(int id)throws InvalidIdException;
	public boolean nameValidation(int id,String name) throws InvalidNameException;
	public boolean supplierIdValidation(int id,String supplierId) throws InvalidSupplierIdException;
	public boolean priceValidation(int id,double price) throws InvalidPriceException;
	public boolean quantityValidation(int id,double quantity) throws InvalidQuantityException;
	public boolean orderIdValidation(int id,String name,String orderid);
	public boolean placeOrder(RawMaterialOrderdto bean);
	public Map<Integer,RawMaterialStockdto> getMap();
	public void displayOrderDetails(String orderId);
	public void updateOrderDetails(String orderid) throws InvalidQuantityException;
}