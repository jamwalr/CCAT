package com.bizviz.ccat.modal;

import java.util.Map;

public class UserResponse {

	private Test test;
	private Map<Question, Answer> userRes;
	public Test getTest() {
		return test;
	}
	public void setTest(Test test) {
		this.test = test;
	}
	public Map<Question, Answer> getUserRes() {
		return userRes;
	}
	public void setUserRes(Map<Question, Answer> userRes) {
		this.userRes = userRes;
	}
}
