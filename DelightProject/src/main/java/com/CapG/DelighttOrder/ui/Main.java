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
		int input =sc.nextInt();
		switch(input) {
		case 1:
		{
			RamMaterialStockrepos stockRepo = new RamMaterialStockrepos();
			stockRepo.setData();
			stockRepo.getData();
			RawMaterialPlaceaOrderservice orderservice = new RawMaterialPlaceaOrderservice();
			RawMaterialOrderdto bean = new RawMaterialOrderdto();
			System.out.println("Raw Material name");
			String name=sc.next();
			bean.setName(name);
			System.out.println("supplierID");
			String supplierId =sc.next();
			bean.setSupplierId(supplierId);
			System.out.println("PricePerUnit");
			double price = sc.nextDouble();
			bean.setPricePerUnit(price);
			System.out.println("quantity");
			double quantity =sc.nextDouble();
			bean.setQuantityValue(quantity);
			double total = bean.getQuantityValue()*bean.getPricePerUnit();
			bean.setTotalPrice(total);
			System.out.println("totalPrice:"+total);
			if(orderservice.addOrderDetails(bean))
				System.out.println("entered sucessfully");
			else
				System.out.println("error occured");
			break;
		}	
		}
		sc.close();
	}
}