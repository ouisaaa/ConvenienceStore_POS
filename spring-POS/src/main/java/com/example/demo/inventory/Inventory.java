package com.example.demo.inventory;

import java.time.LocalDateTime;

public class Inventory {
	private String ID;
	private String name;
	private int price=0;
	private int	count=0;
	private int expiration_date=0;
	
	public Inventory(String ID, String name, int price, int count, int expiration_date) {
		this.ID = ID;
		this.name=name;
		this.price=price;
		this.count=count;
		this.expiration_date=expiration_date;
	}
	
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
