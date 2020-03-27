package com.itwill.willsta.domain;

import java.util.Date;

public class Comments {
	private Integer cNo;
	private Integer pNo;
	private String mId;
	private String cContents;
	private Date cTime;
	
	public Comments() {
		// TODO Auto-generated constructor stub
	}

	public Integer getcNo() {
		return cNo;
	}

	public void setcNo(Integer cNo) {
		this.cNo = cNo;
	}

	public Integer getpNo() {
		return pNo;
	}

	public void setpNo(Integer pNo) {
		this.pNo = pNo;
	}

	public String getmId() {
		return mId;
	}

	public void setmId(String mId) {
		this.mId = mId;
	}

	public String getcContents() {
		return cContents;
	}

	public void setcContents(String cContents) {
		this.cContents = cContents;
	}

	public Date getcTime() {
		return cTime;
	}

	public void setcTime(Date cTime) {
		this.cTime = cTime;
	}

	@Override
	public String toString() {
		return "comments [cNo=" + cNo + ", pNo=" + pNo + ", mId=" + mId + ", cContents=" + cContents + ", cTime="
				+ cTime + "]";
	}
	
	
}
