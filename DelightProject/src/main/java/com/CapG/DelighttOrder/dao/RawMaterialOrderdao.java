package com.CapG.DelighttOrder.dao;

import java.util.ArrayList;
import java.util.List;

import com.CapG.DelighttOrder.dto.RawMaterialOrderdto;
import com.CapG.DelighttOrder.util.RawMaterialOrderrepos;

public class RawMaterialOrderdao {
	public boolean placeAnOrder(RawMaterialOrderdto bean)
	{
		System.out.println("dao");
		RawMaterialOrderrepos rawRepo = new RawMaterialOrderrepos();
		RawMaterialOrderrepos.getRawRepo().add(bean);
		return true;
	}	
}