package com.CapG.DelighttOrder.util;

import java.util.*;

import com.CapG.DelighttOrder.dto.RawMaterialStockdto;

public class RamMaterialStockrepos {
	Map<Integer,RawMaterialStockdto> stockRepo = new LinkedHashMap<Integer,RawMaterialStockdto>();
	
	public void setData()
	{
		stockRepo.put(1,new RawMaterialStockdto("kiwi","1111",50));
		stockRepo.put(2, new RawMaterialStockdto("apple","5555",50));
		stockRepo.put(3, new RawMaterialStockdto("orange","4444",50));
		stockRepo.put(4, new RawMaterialStockdto("banana","3333",50));
		stockRepo.put(5, new RawMaterialStockdto("kiwi","2222",50));
	}
	public void getData()
	{
		for(Map.Entry<Integer,RawMaterialStockdto> map: stockRepo.entrySet())
		{
			System.out.println(map.getKey()+"  "+map.getValue().getSupplierId()+" "+map.getValue().getName()+" "+map.getValue().getPricePerUnit());
		}
	}
}