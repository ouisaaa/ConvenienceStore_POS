package com.example.demo.sell;

public class Sell {
	private String ID;
	private String name;
	private int price;
	private int count;
	
	public Sell(String ID,String name, int price, int count) {
		this.ID=ID;
		this.name=name;
		this.price=price;
		this.count=count;
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
	
	
}
