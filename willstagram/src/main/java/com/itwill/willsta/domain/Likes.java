package com.itwill.willsta.domain;

public class Likes {
	private Integer pNo;
	private Integer mIdYou;
	
	public Likes() {
		// TODO Auto-generated constructor stub
	}

	public Likes(Integer pNo, Integer mIdYou) {
		super();
		this.pNo = pNo;
		this.mIdYou = mIdYou;
	}

	public Integer getpNo() {
		return pNo;
	}

	public void setpNo(Integer pNo) {
		this.pNo = pNo;
	}

	public Integer getmIdYou() {
		return mIdYou;
	}

	public void setmIdYou(Integer mIdYou) {
		this.mIdYou = mIdYou;
	}

	@Override
	public String toString() {
		return "likes [pNo=" + pNo + ", mIdYou=" + mIdYou + "]";
	}
	
	
	
}
