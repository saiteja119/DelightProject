package com.CapG.DelighttOrder.service;
import com.CapG.DelighttOrder.dao.RawMaterialOrderdao;
import com.CapG.DelighttOrder.dto.RawMaterialOrderdto;

public class RawMaterialPlaceaOrderservice implements RawMaterialServices {
	RawMaterialOrderdao orderdao = new RawMaterialOrderdao(); 
	public boolean addOrderDetails(RawMaterialOrderdto bean)
	{
		
		return(orderdao.addOrder(bean));
	}
}