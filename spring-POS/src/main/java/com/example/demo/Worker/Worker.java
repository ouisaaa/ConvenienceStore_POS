package com.example.demo.Worker;

import java.time.LocalDateTime;

public class Worker {
	private String ID; 			//직원 ID
	private String password;	//직원PWD
	private String name; 		//직원 이름
	private LocalDateTime start_date;	//직원 등록일
	private String title;		//직원 등급
	
	public Worker(String ID, String password, String name, LocalDateTime start_date, String title) {
		this.ID=ID;
		this.password=password;
		this.name= name;
		this.start_date=start_date;
		this.title=title;
	}
	
	//setter getter
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDateTime getStart_date() {
		return start_date;
	}
	public void setStart_date(LocalDateTime start_date) {
		this.start_date = start_date;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
}
