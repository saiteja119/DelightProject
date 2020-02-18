package com.CapG.DelighttOrder.util;

import java.util.LinkedList;

import com.CapG.DelighttOrder.dto.RawMaterialOrderdto;

public class RawMaterialOrderrepos {
	static LinkedList<RawMaterialOrderdto> rawRepo = new LinkedList<RawMaterialOrderdto>();

	public static LinkedList<RawMaterialOrderdto> getRawRepo() {
		return rawRepo;
	}

	public static void setRawRepo(LinkedList<RawMaterialOrderdto> rawRepo) {
		RawMaterialOrderrepos.rawRepo = rawRepo;
	}
	public void display()
	{
		System.out.println(rawRepo.get(0).getOrderid()+" "+rawRepo.get(0).getName()+" "+rawRepo.get(0).getSupplierId()+" "+rawRepo.get(0).getTotalPrice());
		System.out.println(rawRepo.get(1).getOrderid()+" "+rawRepo.get(1).getName()+" "+rawRepo.get(1).getSupplierId()+" "+rawRepo.get(1).getTotalPrice());
	}
}