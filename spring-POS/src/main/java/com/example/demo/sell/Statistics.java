package com.example.demo.sell;

import java.time.LocalDateTime;

public class Statistics {
	private String ID;
	private String name;
	private int price;
	private int count;
	private int sellPrice;
	private int sellTotalPrice;
	private LocalDateTime sellDate;
	
	public Statistics(String ID, String name,int price,int count,int sellPrice,LocalDateTime sellDate) {
		this.ID=ID;
		this.name=name;
		this.price=price;
		this.count=count;
		this.sellPrice = sellPrice;
		this.sellDate=sellDate;
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

	public int getSellPrice() {
		return sellPrice;
	}

	public void setSellPrice(int sellPrice) {
		this.sellPrice = sellPrice;
	}

	public LocalDateTime getSellDate() {
		return sellDate;
	}

	public void setSellDate(LocalDateTime sellDate) {
		this.sellDate = sellDate;
	}
}
