package com.CapG.DelighttOrder.daotest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Set;
import java.util.Map.Entry;

import org.junit.jupiter.api.Test;

import com.CapG.DelighttOrder.dto.RawMaterialStockdto;
import com.CapG.DelighttOrder.service.RawMaterialPlaceaOrderservice;
import com.CapG.DelighttOrder.util.RamMaterialStockrepos;

public class RawMaterialStockdaoTest {
	RawMaterialPlaceaOrderservice obj = new RawMaterialPlaceaOrderservice();
	RamMaterialStockrepos objStock = new RamMaterialStockrepos();
	@Test
	public void getMapTest()
	{
		Set<Entry<Integer,RawMaterialStockdto>> original = obj.getMap().entrySet();
		Set<Entry<Integer,RawMaterialStockdto>> expected = objStock.getStockRepo().entrySet();
	}
}
