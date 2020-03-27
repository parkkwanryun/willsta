package com.itwill.willsta.domain;

public class Post {
	private String pNo;
	private String mId;
	private String pTitle;
	private String pContents;
	private String hasTag;
	private String pViewCount;
	private String pDate;
	
	
	public Post() {
		// TODO Auto-generated constructor stub
	}

	public Post(String pNo, String mId, String pTitle, String pContents, String hasTag, String pViewCount,
			String pDate) {
		super();
		this.pNo = pNo;
		this.mId = mId;
		this.pTitle = pTitle;
		this.pContents = pContents;
		this.hasTag = hasTag;
		this.pViewCount = pViewCount;
		this.pDate = pDate;
	}

	public String getpNo() {
		return pNo;
	}

	public void setpNo(String pNo) {
		this.pNo = pNo;
	}

	public String getmId() {
		return mId;
	}

	public void setmId(String mId) {
		this.mId = mId;
	}

	public String getpTitle() {
		return pTitle;
	}

	public void setpTitle(String pTitle) {
		this.pTitle = pTitle;
	}

	public String getpContents() {
		return pContents;
	}

	public void setpContents(String pContents) {
		this.pContents = pContents;
	}

	public String getHasTag() {
		return hasTag;
	}

	public void setHasTag(String hasTag) {
		this.hasTag = hasTag;
	}

	public String getpViewCount() {
		return pViewCount;
	}

	public void setpViewCount(String pViewCount) {
		this.pViewCount = pViewCount;
	}

	public String getpDate() {
		return pDate;
	}

	public void setpDate(String pDate) {
		this.pDate = pDate;
	}

	@Override
	public String toString() {
		return "post [pNo=" + pNo + ", mId=" + mId + ", pTitle=" + pTitle + ", pContents=" + pContents + ", hasTag="
				+ hasTag + ", pViewCount=" + pViewCount + ", pDate=" + pDate + "]";
	}
	
	
	
}
