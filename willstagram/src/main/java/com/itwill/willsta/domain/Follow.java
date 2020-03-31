package com.itwill.willsta.domain;

public class Follow {
	private String mId; 
	private String mIdYou; 
	
	
	public Follow() {
		// TODO Auto-generated constructor stub
	}

	

	public Follow(String mId, String mIdYou, Integer followingCount, Integer followerCount) {
		super();
		this.mId = mId;
		this.mIdYou = mIdYou;
	}

	public String getmId() {
		return mId;
	}

	public void setmId(String mId) {
		this.mId = mId;
	}

	public String getmIdYou() {
		return mIdYou;
	}

	public void setmIdYou(String mIdYou) {
		this.mIdYou = mIdYou;
	}

	@Override
	public String toString() {
		return "follow [mId=" + mId + ", mIdYou=" + mIdYou + "]";
	}



	
	
	
}
