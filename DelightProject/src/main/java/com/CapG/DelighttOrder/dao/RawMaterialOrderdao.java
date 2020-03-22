package com.CapG.DelighttOrder.dao;
import java.util.List;

import com.CapG.DelighttOrder.dto.RawMaterialOrderdto;
import com.CapG.DelighttOrder.dto.RawMaterialStockdto;
import com.CapG.DelighttOrder.util.RawMaterialOrderrepos;

public class RawMaterialOrderdao {
	RawMaterialOrderdto obj = new RawMaterialOrderdto();
	RawMaterialOrderrepos orderrepo = new RawMaterialOrderrepos();
	public void placeAnOrder(RawMaterialOrderdto bean)
	{
		orderrepo.setRawRepo(bean);
	}
	List<RawMaterialOrderdto> daoList;
	public RawMaterialOrderdao()
	{
		daoList=orderrepo.getRawRepo();
	}
	public List<RawMaterialOrderdto> getDaoList()
	{
		return daoList;
	}
}