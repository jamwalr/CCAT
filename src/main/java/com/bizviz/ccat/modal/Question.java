package com.bizviz.ccat.modal;

import java.util.List;

public class Question {

	private int qid;
	private String txt;
	private String image_url;
	private List<Answer> ansList;
	private int ansId;
	
	public int getQid() {
		return qid;
	}
	public void setQid(int qid) {
		this.qid = qid;
	}
	public String getTxt() {
		return txt;
	}
	public void setTxt(String txt) {
		this.txt = txt;
	}
	public String getImage_url() {
		return image_url;
	}
	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}
	public List<Answer> getAnsList() {
		return ansList;
	}
	public void setAnsList(List<Answer> ansList) {
		this.ansList = ansList;
	}
	public int getAnsId() {
		return ansId;
	}
	public void setAnsId(int ansId) {
		this.ansId = ansId;
	}
}
