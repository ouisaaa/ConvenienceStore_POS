package com.example.demo.inventory;

public class InventoryRegisterService {
	private InventoryDao inventoryDao;
	
	public InventoryRegisterService(InventoryDao inventoryDao) {
		this.inventoryDao=inventoryDao;
	}
	public String regist(InventoryRegisterRequest req) throws Exception{
		Inventory inventory = inventoryDao.selectByID(req.getID());
		
		if(inventory !=null) {
			throw new Exception("DuplicateMemberException");
		}
		Inventory newInventory = new Inventory(
					req.getID(),
					req.getName(),
					req.getPrice(),
					0,
					req.getExpiration_date()
		);
		inventoryDao.insert(newInventory);
		
		return newInventory.getID();
	}
}
