package com.CapG.DelighttOrder.dao;

import com.CapG.DelighttOrder.util.RamMaterialStockrepos;

import java.util.Map;

import com.CapG.DelighttOrder.dto.*;
public class RawMaterialStockdao {
	Map<Integer,RawMaterialStockdto> daoMap;
	public RawMaterialStockdao()
	{
		daoMap=RamMaterialStockrepos.getStockRepo();
	}
	public Map<Integer,RawMaterialStockdto> getMapDao()
	{
		return daoMap;
	}	
}