package com.CapG.DelighttOrder.servicetest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.jupiter.api.Test;

import com.CapG.DelighttOrder.dto.RawMaterialOrderdto;
import com.CapG.DelighttOrder.dto.RawMaterialStockdto;
import com.CapG.DelighttOrder.exception.InvalidNameException;
import com.CapG.DelighttOrder.exception.InvalidPriceException;
import com.CapG.DelighttOrder.exception.InvalidQuantityException;
import com.CapG.DelighttOrder.exception.InvalidSupplierIdException;

import com.CapG.DelighttOrder.service.RawMaterialPlaceaOrderservice;
import com.CapG.DelighttOrder.util.RamMaterialStockrepos;
import com.CapG.DelighttOrder.util.RawMaterialOrderrepos;

public class RawMaterialPlaceaOrderservicetest {
	RawMaterialPlaceaOrderservice obj = new RawMaterialPlaceaOrderservice();
	RamMaterialStockrepos objStock = new RamMaterialStockrepos();
	RawMaterialOrderrepos objOrder = new RawMaterialOrderrepos();
 	@Test
	public void nameValidationTest() throws InvalidNameException
	{
		assertTrue(obj.nameValidation(5,"pineapple"));
	}
	@Test
	public void nameValidationTest1()
	{
		Throwable exception = assertThrows(InvalidNameException.class, ()-> {
			obj.nameValidation(5,"apple");
		});
	}
	@Test
	public void supplierIdValidationTest() throws InvalidSupplierIdException
	{
		assertTrue(obj.supplierIdValidation(1,"1111"));
	}
	@Test
	public void supplierValidationTest1()
	{
		Throwable exception = assertThrows(InvalidSupplierIdException.class, ()-> {
			obj.supplierIdValidation(2,"1111");
		});
	}
	@Test
	public void priceValidationTest() throws InvalidPriceException
	{
		assertTrue(obj.priceValidation(1, 50));
	}
	@Test
	public void priceValidationTest1()
	{
		Throwable exception = assertThrows(InvalidPriceException.class, ()-> {
			obj.priceValidation(2,1010);
		});
	}
	@Test
	public void quantityValidationTest() throws InvalidQuantityException
	{
		assertTrue(obj.quantityValidation(1, 50));
	}
	@Test
	public void quantityValidationTest1()
	{
		Throwable exception = assertThrows(InvalidQuantityException.class, ()-> {
			obj.quantityValidation(2,1010);
		});
	}
	@Test
	public void orderIdValidationTest()
	{
			assertTrue(obj.orderIdValidation(2, "apple","rawapple101" ));
	}
	@Test
	public void getMapTest()
	{
		Set<Entry<Integer,RawMaterialStockdto>> original = obj.getMap().entrySet();
		Set<Entry<Integer,RawMaterialStockdto>> expected = objStock.getStockRepo().entrySet();
		assertEquals(original,expected);
	}
	@Test
	public void getListTest()
	{
		List<RawMaterialOrderdto> original = obj.getList();
		List<RawMaterialOrderdto> expected = objOrder.getRawRepo();
		assertEquals(original,expected);
	}	
}