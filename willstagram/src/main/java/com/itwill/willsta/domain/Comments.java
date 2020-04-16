package com.itwill.willsta.domain;

public class Comments {
	private Integer cNo;
	private Integer pNo;
	private String mId;
	private String cContents;
	private String cTime;
	private Integer recNo;
	
	public Comments() {
		// TODO Auto-generated constructor stub
	}

	public Comments(Integer cNo, Integer pNo, String mId, String cContents, String cTime, Integer recNo) {
		super();
		this.cNo = cNo;
		this.pNo = pNo;
		this.mId = mId;
		this.cContents = cContents;
		this.cTime = cTime;
		this.recNo = recNo;
	}

	public Comments(Integer cNo, Integer pNo, String mId, String cContents, Integer recNo) {
		super();
		this.cNo = cNo;
		this.pNo = pNo;
		this.mId = mId;
		this.cContents = cContents;
		this.recNo = recNo;
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

	public String getcTime() {
		return cTime;
	}

	public void setcTime(String cTime) {
		this.cTime = cTime;
	}

	public Integer getRecNo() {
		return recNo;
	}

	public void setRecNo(Integer recNo) {
		this.recNo = recNo;
	}

	@Override
	public String toString() {
		return "Comments [cNo=" + cNo + ", pNo=" + pNo + ", mId=" + mId + ", cContents=" + cContents + ", cTime="
				+ cTime + ", recNo=" + recNo + "]\n";
	}
}
