package com.CapG.DelighttOrder.ui;

import java.util.*;

import com.CapG.DelighttOrder.dao.RawMaterialOrderdao;
import com.CapG.DelighttOrder.dto.RawMaterialOrderdto;
import com.CapG.DelighttOrder.service.*;
import com.CapG.DelighttOrder.util.RamMaterialStockrepos;
import com.CapG.DelighttOrder.util.RawMaterialOrderrepos;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true)
		{
		System.out.println("1:Place An Order");
		System.out.println("2:Exit");
		int input =sc.nextInt();
		switch(input) {
		case 1:
		{
			RamMaterialStockrepos stockRepo = new RamMaterialStockrepos();
			stockRepo.setData();
			stockRepo.getData();
			RawMaterialPlaceaOrderservice orderservice = new RawMaterialPlaceaOrderservice();
			RawMaterialOrderdto bean = new RawMaterialOrderdto();
			System.out.println("ID NO:");
			int id= sc.nextInt();
			System.out.println("Raw Material name");
			String name=sc.next();
			System.out.println("supplierID");
			String supplierId =sc.next();
			System.out.println("PricePerUnit");
			double price = sc.nextDouble();
			System.out.println("quantity");
			double quantity =sc.nextDouble();
			double total = quantity*price;
			System.out.println("totalPrice:"+total);
			if(orderservice.service(id,name,supplierId,price,quantity,total))
				System.out.println("entered sucessfully");
			else
				System.out.println("error occured");
			continue;	
		}
		case 2:
			break;
		}
		break;
		}
		RawMaterialOrderrepos repo = new  RawMaterialOrderrepos();
		repo.display();
		sc.close();
	}
}