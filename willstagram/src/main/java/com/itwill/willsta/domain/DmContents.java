package com.itwill.willsta.domain;

import java.util.Date;

public class DmContents {
	private Integer dmNo;
	private Integer dmContentsNo;
	private String dmContentsMessage;
	private Date dmContentsDate;
	private String dmContentsImage;
	
	public DmContents() {
		// TODO Auto-generated constructor stub
	}

	public DmContents(Integer dmNo, Integer dmContentsNo, String dmContentsMessage, Date dmContentsDate,
			String dmContentsImage) {
		super();
		this.dmNo = dmNo;
		this.dmContentsNo = dmContentsNo;
		this.dmContentsMessage = dmContentsMessage;
		this.dmContentsDate = dmContentsDate;
		this.dmContentsImage = dmContentsImage;
	}

	public Integer getDmNo() {
		return dmNo;
	}

	public void setDmNo(Integer dmNo) {
		this.dmNo = dmNo;
	}

	public Integer getDmContentsNo() {
		return dmContentsNo;
	}

	public void setDmContentsNo(Integer dmContentsNo) {
		this.dmContentsNo = dmContentsNo;
	}

	public String getDmContentsMessage() {
		return dmContentsMessage;
	}

	public void setDmContentsMessage(String dmContentsMessage) {
		this.dmContentsMessage = dmContentsMessage;
	}

	public Date getDmContentsDate() {
		return dmContentsDate;
	}

	public void setDmContentsDate(Date dmContentsDate) {
		this.dmContentsDate = dmContentsDate;
	}

	public String getDmContentsImage() {
		return dmContentsImage;
	}

	public void setDmContentsImage(String dmContentsImage) {
		this.dmContentsImage = dmContentsImage;
	}
	
	
}
