package com.CapG.DelighttOrder.service;

import com.CapG.DelighttOrder.dto.RawMaterialOrderdto;

public interface RawMaterialServices {
	boolean service(int id,String name,String supplierId,double price,double quantity,double total);
}
