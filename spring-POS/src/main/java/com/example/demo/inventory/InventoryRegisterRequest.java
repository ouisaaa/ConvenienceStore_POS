package com.example.demo.inventory;

public class InventoryRegisterRequest {
	private String ID;
	private String name;
	private int price;
	private int count;
	private int expiration_date;
	
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getExpiration_date() {
		return expiration_date;
	}
	public void setExpiration_date(int expiration_date) {
		this.expiration_date = expiration_date;
	}
}
