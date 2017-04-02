package com.bizviz.ccat.modal;

public class User {

	private int uid;
	private String email;
	private String name;

	public User(String userName, String user_email) {
		// TODO Auto-generated constructor stub
		this.name = userName;
		this.email = user_email;
	}
	public User(int uid , String userName, String user_email) {
		// TODO Auto-generated constructor stub
		this.uid = uid;
		this.name = userName;
		this.email = user_email;
	}
	
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}	
}
