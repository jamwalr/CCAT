package com.bizviz.ccat.modal;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {

	private int testId;
	private User user;
	private Date beginDate;
	private Date endDate;
	private boolean attempted;
	private int finalScore;
	
	public Test(User user, String startDate, String expiryDate) {
		// TODO Auto-generated constructor stub
		this.user = user;
		
	    DateFormat df = new SimpleDateFormat("dd/MM/yyyy"); 
	    try {System.out.println(startDate);
	    	this.beginDate = df.parse(startDate);
	    	this.endDate = df.parse(expiryDate);
	    } catch (ParseException e) {
	        e.printStackTrace();
	    }
	}
	
	public int getTestId() {
		return testId;
	}
	public void setTestId(int testId) {
		this.testId = testId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User uid) {
		this.user = uid;
	}
	public Date getBeginDate() {
		return beginDate;
	}
	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public boolean isAttempted() {
		return attempted;
	}
	public void setAttempted(boolean attempted) {
		this.attempted = attempted;
	}
	public int getFinalScore() {
		return finalScore;
	}
	public void setFinalScore(int finalScore) {
		this.finalScore = finalScore;
	}
}
