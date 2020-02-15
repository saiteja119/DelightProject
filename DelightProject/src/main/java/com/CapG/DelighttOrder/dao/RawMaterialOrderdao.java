package com.CapG.DelighttOrder.dao;

import java.util.ArrayList;
import java.util.List;

import com.CapG.DelighttOrder.dto.RawMaterialOrderdto;
import com.CapG.DelighttOrder.util.RawMaterialOrderrepos;

public class RawMaterialOrderdao {
	public boolean addOrder(RawMaterialOrderdto bean)
	{
		RawMaterialOrderrepos rawRepo = new RawMaterialOrderrepos();
		return(rawRepo.repo(bean));
	}
}