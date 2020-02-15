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
			bean.setName("orange");
			bean.setSupplierId("1111");
			bean.setOrderid("0001");
			bean.setPricePerUnit(50);
			bean.setQuantityValue(10);
			bean.setTotalPrice(bean.getPricePerUnit()*bean.getQuantityValue());
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