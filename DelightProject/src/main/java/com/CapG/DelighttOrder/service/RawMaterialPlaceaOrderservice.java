package com.CapG.DelighttOrder.service;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.CapG.DelighttOrder.dao.RawMaterialOrderdao;
import com.CapG.DelighttOrder.dao.RawMaterialStockdao;
import com.CapG.DelighttOrder.dto.RawMaterialOrderdto;
import com.CapG.DelighttOrder.dto.RawMaterialStockdto;
import com.CapG.DelighttOrder.exception.InvalidIdException;
import com.CapG.DelighttOrder.exception.InvalidNameException;
import com.CapG.DelighttOrder.exception.InvalidPriceException;
import com.CapG.DelighttOrder.exception.InvalidQuantityException;
import com.CapG.DelighttOrder.exception.InvalidSupplierIdException;

public class RawMaterialPlaceaOrderservice implements RawMaterialServices {
	Scanner scan = new Scanner(System.in);
	RawMaterialOrderdao orderdao = new RawMaterialOrderdao();
	RawMaterialOrderdto bean = new RawMaterialOrderdto();
	RawMaterialStockdao objDao = new RawMaterialStockdao();
	 public List<RawMaterialOrderdto> getList(){
		 return(orderdao.getDaoList());
	 }
	 List<RawMaterialOrderdto> list = getList();
	Map<Integer,RawMaterialStockdto> map = objDao.getMapDao();
	public Map<Integer,RawMaterialStockdto> getMap()
	{
		return map;
	}
	public boolean idValidation(int id) throws InvalidIdException
	{
		if(map.containsKey(id))
		{
			return true;
		}
		else
		{
			throw new InvalidIdException("InvalidId");
		}
	}
	public boolean nameValidation(int id,String name) throws InvalidNameException
	{
		if(map.get(id).getName().equals(name))
		{
			return true;
		}
		else
		{
			throw new InvalidNameException("Invalid RawMaterial Name");
		}
	}

	public boolean supplierIdValidation(int id,String supplierId) throws InvalidSupplierIdException
	{
		if(map.get(id).getSupplierId().equals(supplierId))
		{
			return true;
		}
		else
		{
			
			throw new InvalidSupplierIdException("Invalid SupplierId");
		}
	}
	public boolean priceValidation(int id,double price) throws InvalidPriceException
	{
		if(map.get(id).getPricePerUnit() == price)
		{
			return true;
		}
		else
		{
			throw new InvalidPriceException("Invalid Price");
		}
	}
	public boolean quantityValidation(int id,double quantity) throws InvalidQuantityException
	{
		if(map.get(id).getQuantity() >= quantity)
		{
			return true;
		}
		else
		{
			throw new InvalidQuantityException("Out of Stock");
		}
	}
	public boolean orderIdValidation(int id,String name,String orderid)
	{
		if(map.get(id).getName().equals(name))
			return true;
		return true;
	}
	public void displayOrderDetails(String orderId)
	{
		int temp=-1;
		for(int loop=0;loop<list.size();loop++)
		{
			if(list.get(loop).getOrderid().equals(orderId))
			{
				//System.out.println("Raw Material:"+list.get(loop).getName()+"\n"+"SupplierId:"+list.get(loop).getSupplierId()+"\n"+"Price:"+list.get(loop).getPricePerUnit()+"\n"+"Quantity:"+list.get(loop).getQuantityValue());
				temp=loop;
			}
			else
				System.out.println("OrderId Not Exists");
		}
		if(temp!=-1)
		{
			System.out.println("Raw Material:"+list.get(temp).getName()+"\n"+"SupplierId:"+list.get(temp).getSupplierId()+"\n"+"Price:"+list.get(temp).getPricePerUnit()+"\n"+"Quantity:"+list.get(temp).getQuantityValue());
		}
	}
	public void updateOrderDetails(String orderid) throws InvalidQuantityException
	{
		System.out.println("What Will You update");
		System.out.println("1:Quantity");
		System.out.println("2:Break");
		int a =scan.nextInt();
		switch(a)
		{
			case 1:
				int temp=-1;
				for(int loop=0;loop<list.size();loop++)
				{
					if(list.get(loop).getOrderid().equals(orderid))
					{
						temp=loop;
					}
					else
						System.out.println("OrderId Not Exists");
				}
				if(temp!=-1)
				{
					double quantity;
					while(true)
					{
						System.out.println("Update your quantiy value");
						quantity =scan.nextDouble();
						try
						{
							if(quantityValidation(list.get(temp).getId(),quantity))
								break;
						}
						catch(InvalidQuantityException e)
						{
							System.out.println(e.getMessage());
						}
					}
					list.get(temp).setQuantityValue(quantity);
					break;
				}
			case 2:
				break;
		}
		
	}
	public boolean placeOrder(RawMaterialOrderdto bean) {
		orderdao.placeAnOrder(bean);
		return true;
	}
}