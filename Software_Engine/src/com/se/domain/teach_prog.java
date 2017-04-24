package com.se.domain;

import java.util.Date;

public class teach_prog {
	private int id;
	private String title;
	private String content;
	private int yeaR;
	private Date time;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public int getYeaR() {
		return yeaR;
	}
	public void setYeaR(int yeaR) {
		this.yeaR = yeaR;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	
}
