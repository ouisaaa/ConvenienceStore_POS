package com.example.demo.sell;

import java.time.LocalDateTime;


public class SellStatisticsRegister {
	private SellDao sellDao;
	
	public SellStatisticsRegister(SellDao sellDao) {
		this.sellDao=sellDao;
	}
	
	public void regist(Sell req){
		Statistics newSregReq = new Statistics(
					req.getID(),
					req.getName(),
					req.getPrice(),
					req.getCount(),
					(req.getPrice()*req.getCount()),
					LocalDateTime.now()
		);
		sellDao.insert(newSregReq);
		
	}
	
}
