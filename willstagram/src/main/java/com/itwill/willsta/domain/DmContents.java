package com.itwill.willsta.domain;

import java.util.Date;

public class DmContents {
	private Integer dmNo;
	private Integer dmContentsNo;
	private String dmContentsMessage;
	private String dmContentsDate;
	private String dmSenderId;
	private String dmContentsImage;
	private Integer dmChatRead;
	
	public DmContents(Integer dmNo, Integer dmContentsNo, String dmContentsMessage, String dmContentsDate,
			String dmSenderId, String dmContentsImage, Integer dmChatRead) {
		super();
		this.dmNo = dmNo;
		this.dmContentsNo = dmContentsNo;
		this.dmContentsMessage = dmContentsMessage;
		this.dmContentsDate = dmContentsDate;
		this.dmSenderId = dmSenderId;
		this.dmContentsImage = dmContentsImage;
		this.dmChatRead = dmChatRead;
	}

	public DmContents() {
		super();
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

	public String getDmContentsDate() {
		return dmContentsDate;
	}

	public void setDmContentsDate(String dmContentsDate) {
		this.dmContentsDate = dmContentsDate;
	}

	public String getDmSenderId() {
		return dmSenderId;
	}

	public void setDmSenderId(String dmSenderId) {
		this.dmSenderId = dmSenderId;
	}

	public String getDmContentsImage() {
		return dmContentsImage;
	}

	public void setDmContentsImage(String dmContentsImage) {
		this.dmContentsImage = dmContentsImage;
	}

	public Integer getDmChatRead() {
		return dmChatRead;
	}

	public void setDmChatRead(Integer dmChatRead) {
		this.dmChatRead = dmChatRead;
	}

	@Override
	public String toString() {
		return "DmContents [dmNo=" + dmNo + ", dmContentsNo=" + dmContentsNo + ", dmContentsMessage="
				+ dmContentsMessage + ", dmContentsDate=" + dmContentsDate + ", dmSenderId=" + dmSenderId
				+ ", dmContentsImage=" + dmContentsImage + ", dmChatRead=" + dmChatRead + "]\n";
	}
	
	
}
