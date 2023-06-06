package com.example.demo.Worker;

//신규 직원 회원가입 요구사항
public class WorkerRegisterRequest {
	private String ID;
	private String password;
	private String confirmPassword;
	private String name;
	private String title;
	
	public boolean isPasswordEqualToConfirmPassword() {
		return password.equals(confirmPassword);
	}
	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}