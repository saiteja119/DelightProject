package com.CapG.DelighttOrder.ui;

import java.util.*;

import com.CapG.DelighttOrder.dao.RawMaterialOrderdao;
import com.CapG.DelighttOrder.dto.RawMaterialOrderdto;
import com.CapG.DelighttOrder.exception.InvalidNameException;
import com.CapG.DelighttOrder.exception.InvalidPriceException;
import com.CapG.DelighttOrder.exception.InvalidQuantityException;
import com.CapG.DelighttOrder.exception.InvalidSupplierIdException;
import com.CapG.DelighttOrder.service.*;
import com.CapG.DelighttOrder.util.RamMaterialStockrepos;
import com.CapG.DelighttOrder.util.RawMaterialOrderrepos;

public class Main {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		RawMaterialPlaceaOrderservice orderService = new RawMaterialPlaceaOrderservice();
		RawMaterialOrderdto bean = new RawMaterialOrderdto();
		RawMaterialOrderrepos orderRepo = new RawMaterialOrderrepos();
		int i=100;
		while(true)
		{
		System.out.println("1:Place An Order");
		System.out.println("2:Update");
		System.out.println("3:Break");
		int input =sc.nextInt();
		switch(input) {
		case 1:
		{
			RamMaterialStockrepos stockRepo = new RamMaterialStockrepos();
			stockRepo.setData();
			stockRepo.getData();
			System.out.println("ID NO:");
			int id= sc.nextInt();
				while(true)
				{
					System.out.println("Raw Material name");
					String name=sc.next();
					try
					{
						if(orderService.nameValidation(id,name))
							break;
					}
					catch(InvalidNameException e)
					{
						System.out.println(e);
					}
				}
				while(true)
				{
					System.out.println("supplierID");
					String supplierId =sc.next();
					try
					{
						if(orderService.supplierIdValidation(id,supplierId))
							break;
					}
					catch(InvalidSupplierIdException e)
					{
						System.out.println(e);
					}
				}
				while(true)
				{
					System.out.println("PricePerUnit");
					double price = sc.nextDouble();
					try
					{
						if(orderService.priceValidation(id,price))
							break;
					}
					catch(InvalidPriceException e)
					{
						System.out.println(e);
					}
				}
			loop3:
				while(true)
				{
					System.out.println("quantity");
					double quantity =sc.nextDouble();
					try
					{
						if(orderService.quantityValidation(id,quantity))
							break loop3;
					}
					catch(InvalidQuantityException e)
					{
						System.out.println(e);
					}
				}
				if(orderService.serviceValidation())
				{
					System.out.println("entered sucessfully");
				}
				else
				{
					System.out.println("error occured");
				}
				orderService.total();
				orderService.orderId();
				continue;
			}
		case 2:
		{
			
		}
		case 3:
			break;
		}
		break;
	}
	orderRepo.display();
	}
}