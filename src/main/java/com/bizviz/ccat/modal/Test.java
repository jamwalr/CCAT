package com.bizviz.ccat.modal;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {

	public Test(User user, String startDate, String expiryDate) {
		// TODO Auto-generated constructor stub
		this.uid = user;
		
	    DateFormat df = new SimpleDateFormat("MM/dd/yyyy"); 
	    try {
	    	this.beginDate = df.parse(startDate);
	    	this.endDate = df.parse(expiryDate);
	    } catch (ParseException e) {
	        e.printStackTrace();
	    }
	}
	private int testId;
	private User uid;
	private Date beginDate;
	private Date endDate;
	private boolean attempted;
	private int finalScore;
	public int getTestId() {
		return testId;
	}
	public void setTestId(int testId) {
		this.testId = testId;
	}
	public User getUid() {
		return uid;
	}
	public void setUid(User uid) {
		this.uid = uid;
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
