package com.itwill.willsta.domain;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class DM {
	private Integer dmNo;
	private String mId;
	private String dmDate;
	private String mImage;
	private Integer dmChatReadCount;
	
	public DM() {
		super();
	}
	
	public DM(Integer dmNo, String mId, String dmDate, String mImage) {
		super();
		this.dmNo = dmNo;
		this.mId = mId;
		this.dmDate = dmDate;
		this.mImage = mImage;
	}

	public DM(Integer dmNo, String mId, String dmDate, String mImage, Integer dmChatReadCount) {
		super();
		this.dmNo = dmNo;
		this.mId = mId;
		this.dmDate = dmDate;
		this.mImage = mImage;
		this.dmChatReadCount = dmChatReadCount;
	}
	public Integer getDmNo() {
		return dmNo;
	}
	public void setDmNo(Integer dmNo) {
		this.dmNo = dmNo;
	}
	public String getmId() {
		return mId;
	}
	public void setmId(String mId) {
		this.mId = mId;
	}
	public String getDmDate() {
		return dmDate;
	}
	public void setDmDate(String dmDate) {
		this.dmDate = dmDate;
	}
	public String getmImage() {
		return mImage;
	}
	public void setmImage(String mImage) {
		this.mImage = mImage;
	}
	public Integer getDmChatReadCount() {
		return dmChatReadCount;
	}
	public void setDmChatReadCount(Integer dmChatReadCount) {
		this.dmChatReadCount = dmChatReadCount;
	}
	@Override
	public String toString() {
		return "DM [dmNo=" + dmNo + ", mId=" + mId + ", dmDate=" + dmDate + ", mImage=" + mImage + ", dmChatReadCount="
				+ dmChatReadCount + "]";
	}
	
	




	
}
	