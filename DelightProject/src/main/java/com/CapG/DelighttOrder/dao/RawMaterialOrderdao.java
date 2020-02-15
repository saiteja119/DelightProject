package com.CapG.DelighttOrder.dao;

import java.util.ArrayList;
import java.util.List;

import com.CapG.DelighttOrder.dto.RawMaterialOrderdto;

public class RawMaterialOrderdao {

List<RawMaterialOrderdto> orderList = new ArrayList<RawMaterialOrderdto>();
	
	public List<RawMaterialOrderdto> getOrderList() {
	return orderList;
}

public void setOrderList(List<RawMaterialOrderdto> orderList) {
	this.orderList = orderList;
}

	public boolean addOrder(RawMaterialOrderdto bean)
	{
		orderList.add(bean);
		return true;
	}
	public List<RawMaterialOrderdto> display()
	{
		return orderList;
	}
}