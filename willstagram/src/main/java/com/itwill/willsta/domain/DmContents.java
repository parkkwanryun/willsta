package com.itwill.willsta.domain;

import java.util.Date;

public class DmContents {
	private Integer dm_no;
	private Integer dm_contents_no;
	private String dm_contents_message;
	private String dImage;
	private Date dm_contents_date;
	
	public DmContents() {
		// TODO Auto-generated constructor stub
	}

	public DmContents(Integer dm_no, Integer dm_contents_no, String dm_contents_message, String dImage,
			Date dm_contents_date) {
		super();
		this.dm_no = dm_no;
		this.dm_contents_no = dm_contents_no;
		this.dm_contents_message = dm_contents_message;
		this.dImage = dImage;
		this.dm_contents_date = dm_contents_date;
	}

	public Integer getDm_no() {
		return dm_no;
	}

	public void setDm_no(Integer dm_no) {
		this.dm_no = dm_no;
	}

	public Integer getDm_contents_no() {
		return dm_contents_no;
	}

	public void setDm_contents_no(Integer dm_contents_no) {
		this.dm_contents_no = dm_contents_no;
	}

	public String getDm_contents_message() {
		return dm_contents_message;
	}

	public void setDm_contents_message(String dm_contents_message) {
		this.dm_contents_message = dm_contents_message;
	}

	public String getdImage() {
		return dImage;
	}

	public void setdImage(String dImage) {
		this.dImage = dImage;
	}

	public Date getDm_contents_date() {
		return dm_contents_date;
	}

	public void setDm_contents_date(Date dm_contents_date) {
		this.dm_contents_date = dm_contents_date;
	}

	@Override
	public String toString() {
		return "DmContents [dm_no=" + dm_no + ", dm_contents_no=" + dm_contents_no + ", dm_contents_message="
				+ dm_contents_message + ", dImage=" + dImage + ", dm_contents_date=" + dm_contents_date + "]";
	}
	
	
}
