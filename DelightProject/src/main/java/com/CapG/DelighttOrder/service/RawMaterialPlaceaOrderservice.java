package com.CapG.DelighttOrder.service;
import com.CapG.DelighttOrder.dao.RawMaterialOrderdao;
import com.CapG.DelighttOrder.dto.RawMaterialOrderdto;
import com.CapG.DelighttOrder.exception.InvalidNameException;
import com.CapG.DelighttOrder.exception.InvalidPriceException;
import com.CapG.DelighttOrder.exception.InvalidQuantityException;
import com.CapG.DelighttOrder.exception.InvalidSupplierIdException;
import com.CapG.DelighttOrder.util.RamMaterialStockrepos;

public class RawMaterialPlaceaOrderservice implements RawMaterialServices {
	RawMaterialOrderdao orderdao = new RawMaterialOrderdao();
	RawMaterialOrderdto bean = new RawMaterialOrderdto();
	public boolean service(int id,String name,String supplierId,double price,double quantity,double total)
	{
		RamMaterialStockrepos stock = new RamMaterialStockrepos();
		stock.setData();
		try
		{
			if(stock.getStockRepo().get(id).getName().equals(name))
			{
				bean.setName(name);
			}
			else
			{
				throw new InvalidNameException("Invalid Name");
			}
		}
		catch(InvalidNameException e)
		{
			e.printStackTrace();
		}
		try
		{
			if(stock.getStockRepo().get(id).getSupplierId().equals(supplierId))
			{
				bean.setSupplierId(supplierId);
			}
			else
			{
				throw new InvalidSupplierIdException("Invalid SupplierId");
			}
		}
		catch(InvalidSupplierIdException e)
		{
			e.printStackTrace();
		}
		try
		{
			if(stock.getStockRepo().get(id).getPricePerUnit() == price)
			{
				bean.setPricePerUnit(price);
			}
			else
			{
				throw new InvalidPriceException("Invalid Price");
			}
		}
		catch(InvalidPriceException e)
		{
			e.printStackTrace();
		}
		try
		{
			if(stock.getStockRepo().get(id).getQuantity() >= quantity)
			{
				bean.setQuantityValue(quantity);
			}
			else
			{
				throw new InvalidQuantityException("Quantity Unavaliable");
			}
		}
		catch(InvalidQuantityException e)
		{
			e.printStackTrace();
		}
		//bean.setQuantityValue(quantity);
		bean.setTotalPrice(total);
		return(orderdao.addOrder(bean));
	}

}