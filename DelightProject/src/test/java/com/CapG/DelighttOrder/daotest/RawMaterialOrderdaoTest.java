package com.CapG.DelighttOrder.daotest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.CapG.DelighttOrder.dto.RawMaterialOrderdto;
import com.CapG.DelighttOrder.service.RawMaterialPlaceaOrderservice;
import com.CapG.DelighttOrder.util.RamMaterialStockrepos;
import com.CapG.DelighttOrder.util.RawMaterialOrderrepos;

public class RawMaterialOrderdaoTest {
	RawMaterialPlaceaOrderservice obj = new RawMaterialPlaceaOrderservice();
	RawMaterialOrderrepos objOrder = new RawMaterialOrderrepos();

	@Test
	public void getListTest()
	{
		List<RawMaterialOrderdto> original = obj.getList();
		List<RawMaterialOrderdto> expected = objOrder.getRawRepo();
		assertEquals(original,expected);
	}	
}
