package com.example.demo.inventory;

public class InventoryModifyService {
	private InventoryDao inventoryDao;
	
	public InventoryModifyService(InventoryDao inventoryDao) {
		this.inventoryDao=inventoryDao;
	}
	public String modify(Inventory req) throws Exception{
		Inventory inventory = inventoryDao.selectByID(req.getID());
		
		System.out.println(inventory.getID());
		
		if(inventory ==null) {
			throw new Exception("NullWorkerException");
		}
		Inventory modifyInventory = new Inventory(
				req.getID(),
				req.getName(),
				req.getPrice(),
				req.getCount(),
				req.getExpiration_date()
		);
		inventoryDao.update(modifyInventory);
		
		return modifyInventory.getID();
	}
}
