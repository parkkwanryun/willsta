package com.itwill.willsta.domain;

public class Follow {
	private String mId; 
	private String mIdYou; 
	private Integer followingCount;
	private Integer followerCount;
	
	
	public Follow() {
		// TODO Auto-generated constructor stub
	}

	

	public Follow(String mId, String mIdYou, Integer followingCount, Integer followerCount) {
		super();
		this.mId = mId;
		this.mIdYou = mIdYou;
		this.followingCount = followingCount;
		this.followerCount = followerCount;
	}

	

	public Integer getFollowingCount() {
		return followingCount;
	}



	public void setFollowingCount(Integer followingCount) {
		this.followingCount = followingCount;
	}



	public Integer getFollowerCount() {
		return followerCount;
	}



	public void setFollowerCount(Integer followerCount) {
		this.followerCount = followerCount;
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
