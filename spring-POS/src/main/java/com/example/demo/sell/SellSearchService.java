package com.example.demo.sell;

import com.example.demo.inventory.Inventory;

public class SellSearchService {
	private SellDao sellDao;
	
	public SellSearchService(SellDao sellDao) {
		this.sellDao=sellDao;
	}
	
	public Sell search(String req)throws Exception{
		Sell sell = sellDao.selectByID(req);
		
		if(sell ==null) {
			throw new Exception("NullWorkerException");
		}
		Sell newSell = new Sell(
					sell.getID(),
					sell.getName(),
					sell.getPrice(),
					1
		);
		return newSell;
	}
}
