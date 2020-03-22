package com.CapG.DelighttOrder.util;

import java.util.ArrayList;
import java.util.List;


import com.CapG.DelighttOrder.dto.RawMaterialOrderdto;

public class RawMaterialOrderrepos {
	RawMaterialOrderdto obj = new RawMaterialOrderdto();
    public static List<RawMaterialOrderdto> rawRepo = new ArrayList<RawMaterialOrderdto>();
    
	public List<RawMaterialOrderdto> getRawRepo() 
	{
		return rawRepo;
	}

	public void setRawRepo(RawMaterialOrderdto bean)
	{
		rawRepo.add(bean);
	}
}