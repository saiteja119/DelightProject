package com.CapG.DelighttOrder.ui;

import java.util.*;
import com.CapG.DelighttOrder.dto.RawMaterialOrderdto;
import com.CapG.DelighttOrder.dto.RawMaterialStockdto;
import com.CapG.DelighttOrder.exception.InvalidIdException;
import com.CapG.DelighttOrder.exception.InvalidNameException;
import com.CapG.DelighttOrder.exception.InvalidPriceException;
import com.CapG.DelighttOrder.exception.InvalidQuantityException;
import com.CapG.DelighttOrder.exception.InvalidSupplierIdException;
import com.CapG.DelighttOrder.service.*;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		RawMaterialServices orderService = new RawMaterialPlaceaOrderservice();
		RawMaterialOrderdto bean = new RawMaterialOrderdto();
		int loop1=100;
		String name;
		String supplierId;
		double price;
		double quantity;
		String orderid;
		while(true)
		{
		System.out.println("------------------------------");
		System.out.println("1:Place An Order");
		System.out.println("2:Display Order Details");
		System.out.println("3:Update");
		System.out.println("4:Break");
		System.out.println("------------------------------");
		int input =scan.nextInt();
		switch(input) {
		case 1:
		{
			Map<Integer,RawMaterialStockdto> map1 = orderService.getMap();
			System.out.println("-------------------------------------------");
			for(Map.Entry<Integer,RawMaterialStockdto> map: map1.entrySet())
			{
				System.out.println(map.getKey()+" "+map.getValue().getName()+"  "+map.getValue().getSupplierId()+" "+map.getValue().getPricePerUnit()+" "+map.getValue().getQuantity());
			}
			System.out.println("--------------------------------------------");
			int id;
			while(true)
			{
				System.out.println("ID NO:");
				id= scan.nextInt();
			try
			{
				if(orderService.idValidation(id))
					break;
			}
			catch(InvalidIdException e)
			{
				System.out.println(e.getMessage());
			}
			}
			while(true)
			{
				System.out.println("Raw Material name");
				name=scan.next();
				try
				{
					if(orderService.nameValidation(id,name))
						break;
				}
				catch(InvalidNameException e)
				{
					System.out.println(e.getMessage());
				}
				}
			while(true)
			{
				System.out.println("supplierID");
				supplierId =scan.next();
				try
				{
					if(orderService.supplierIdValidation(id,supplierId))
						break;
				}
				catch(InvalidSupplierIdException e)
				{ 
					System.out.println(e.getMessage());
				}
			}
			while(true)
			{
				System.out.println("PricePerUnit");
				price = scan.nextDouble();
				try
				{
					if(orderService.priceValidation(id,price))
						break;
				}
				catch(InvalidPriceException e)
				{
					System.out.println(e.getMessage());
				}
			}
			while(true)
			{
				System.out.println("quantity");
				quantity =scan.nextDouble();
				try
				{
					if(orderService.quantityValidation(id,quantity))
						break;
				}
				catch(InvalidQuantityException e)
				{
					System.out.println(e.getMessage());
				}
			}
			while(true)
			{
				StringBuilder sb = new StringBuilder();
				sb.append("raw");
				sb.append(name);
				sb.append(++loop1);
				orderid = sb.toString();
			if(orderService.orderIdValidation(id, orderid,name))
			{
				break ;
			}
			}
			bean.setId(id);
			bean.setName(name);
			bean.setSupplierId(supplierId);
			bean.setPricePerUnit(price);
			bean.setQuantityValue(quantity);
			bean.setOrderid(orderid);
			if(orderService.placeOrder(bean))
			{
				System.out.println("entered sucessfully");
			}
			else
			{
				System.out.println("error occured");
			}
			continue;
		}
		case 2:
			System.out.println("Enter Id");
			String orderId = scan.next();
			orderService.displayOrderDetails(orderId);
			continue;
		case 3:
			System.out.println("Enter Id");
			String orderID =scan.next();
			orderService.updateOrderDetails(orderID);
			continue;
		case 4:
			break;
		}
		break;
	}
	}
}