package com.itwill.willsta.domain;

import java.util.Date;

public class DM {
	private Integer dm_no;
	private String dm_id;
	private String dm_youId;
	private Date dm_date;
	
	public DM() {
		// TODO Auto-generated constructor stub
	}

	public DM(Integer dm_no, String dm_id, String dm_youId, Date dm_date) {
		super();
		this.dm_no = dm_no;
		this.dm_id = dm_id;
		this.dm_youId = dm_youId;
		this.dm_date = dm_date;
	}

	public Integer getDm_no() {
		return dm_no;
	}

	public void setDm_no(Integer dm_no) {
		this.dm_no = dm_no;
	}

	public String getDm_id() {
		return dm_id;
	}

	public void setDm_id(String dm_id) {
		this.dm_id = dm_id;
	}

	public String getDm_youId() {
		return dm_youId;
	}

	public void setDm_youId(String dm_youId) {
		this.dm_youId = dm_youId;
	}

	public Date getDm_date() {
		return dm_date;
	}

	public void setDm_date(Date dm_date) {
		this.dm_date = dm_date;
	}

	@Override
	public String toString() {
		return "DM [dm_no=" + dm_no + ", dm_id=" + dm_id + ", dm_youId=" + dm_youId + ", dm_date=" + dm_date + "]";
	}
	
	
}
	