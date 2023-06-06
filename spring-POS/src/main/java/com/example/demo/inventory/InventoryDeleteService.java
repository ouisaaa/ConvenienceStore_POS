package com.example.demo.inventory;

public class InventoryDeleteService {
	private InventoryDao inventoryDao;
	
	public InventoryDeleteService(InventoryDao inventoryDao) {
		this.inventoryDao=inventoryDao;
	}
	
	public void delete(Inventory req) throws Exception{
		Inventory inventory = inventoryDao.selectByID(req.getID());
		
		if(inventory ==null) {
			throw new Exception("NullWorkerException");
		}
		
		
		inventoryDao.delete(inventory);
	}
}
