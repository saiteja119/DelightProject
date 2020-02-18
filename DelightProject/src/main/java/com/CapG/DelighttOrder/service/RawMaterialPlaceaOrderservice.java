package com.CapG.DelighttOrder.service;
import com.CapG.DelighttOrder.dao.RawMaterialOrderdao;
import com.CapG.DelighttOrder.dto.RawMaterialOrderdto;
import com.CapG.DelighttOrder.exception.InvalidNameException;
import com.CapG.DelighttOrder.exception.InvalidPriceException;
import com.CapG.DelighttOrder.exception.InvalidQuantityException;
import com.CapG.DelighttOrder.exception.InvalidSupplierIdException;
import com.CapG.DelighttOrder.util.RamMaterialStockrepos;

public class RawMaterialPlaceaOrderservice{
	RawMaterialOrderdao orderdao = new RawMaterialOrderdao();
	RawMaterialOrderdto bean = new RawMaterialOrderdto();
	RamMaterialStockrepos stock = new RamMaterialStockrepos();
	public boolean nameValidation(int id,String name) throws InvalidNameException
	{
		stock.setData();
		if(stock.getStockRepo().get(id).getName().equals(name))
		{
			bean.setName(name);
			return true;
		}
		else
		{
			//return false;
			throw new InvalidNameException("Invalid Name");
		}
	}

	public boolean supplierIdValidation(int id,String supplierId) throws InvalidSupplierIdException
	{
		if(stock.getStockRepo().get(id).getSupplierId().equals(supplierId))
		{
			bean.setSupplierId(supplierId);
			return true;
		}
		else
		{
			return false;
			//throw new InvalidSupplierIdException("Invalid SupplierId");
		}
	}
	public boolean priceValidation(int id,double price) throws InvalidPriceException
	{
		if(stock.getStockRepo().get(id).getPricePerUnit() == price)
		{
			bean.setPricePerUnit(price);
			return true;
		}
		else
		{
			return false;
//			throw new InvalidPriceException("Invalid Price");
		}
	}
	public boolean quantityValidation(int id,double quantity) throws InvalidQuantityException
	{
		if(stock.getStockRepo().get(id).getQuantity() >= quantity)
		{
			bean.setQuantityValue(quantity);
			return true;
		}
		else
		{
			return false;
//			throw new InvalidQuantityException("Quantity Unavaliable");
		}
	}
	public boolean orderId()
	{
		StringBuffer strBuff = new StringBuffer();
		strBuff.append("raw");
		strBuff.append(bean.getName());
		String orderid=new String(strBuff);
		bean.setOrderid(orderid);
		return true;
	}
	public boolean total()
	{
		bean.setTotalPrice(bean.getPricePerUnit()*bean.getQuantityValue());
		return true;
	}
	public boolean serviceValidation()
	{
		return(orderdao.placeAnOrder(bean));
	}
}