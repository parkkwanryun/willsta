package com.itwill.willsta.domain;

import org.springframework.web.multipart.MultipartFile;

public class Member {
	private String mId;
	private String mPass;
	private String mName;
	private String mEmail;
	private String mPhone;
	private String mImage;
	private MultipartFile mUploadImage;
	private String mRetire;
	
	private Integer followerCount;
	private Integer followingCount;
	
	public Member() {
		// TODO Auto-generated constructor stub
	}

	public Member(String mId, String mPass, String mName, String mEmail, String mPhone, String mImage, String mRetire,
			Integer followerCount, Integer followingCount) {
		super();
		this.mId = mId;
		this.mPass = mPass;
		this.mName = mName;
		this.mEmail = mEmail;
		this.mPhone = mPhone;
		this.mImage = mImage;
		this.mRetire = mRetire;
		this.followerCount = followerCount;
		this.followingCount = followingCount;
	}


	public Member(String mId, String mPass, String mName, String mEmail, String mPhone, String mImage, String mRetire) {
		super();
		this.mId = mId;
		this.mPass = mPass;
		this.mName = mName;
		this.mEmail = mEmail;
		this.mPhone = mPhone;
		this.mImage = mImage;
		this.mRetire = mRetire;
	}
	
	public Member(String mId, String mPass, String mName, String mEmail, String mPhone, MultipartFile mUploadImage, String mRetire) {
		super();
		this.mId = mId;
		this.mPass = mPass;
		this.mName = mName;
		this.mEmail = mEmail;
		this.mPhone = mPhone;
		this.mUploadImage = mUploadImage;
		this.mRetire = mRetire;
	}
	
	public String getmId() {
		return mId;
	}


	public void setmId(String mId) {
		this.mId = mId;
	}


	public String getmPass() {
		return mPass;
	}


	public void setmPass(String mPass) {
		this.mPass = mPass;
	}


	public String getmName() {
		return mName;
	}


	public void setmName(String mName) {
		this.mName = mName;
	}


	public String getmEmail() {
		return mEmail;
	}


	public void setmEmail(String mEmail) {
		this.mEmail = mEmail;
	}


	public String getmPhone() {
		return mPhone;
	}


	public void setmPhone(String mPhone) {
		this.mPhone = mPhone;
	}

	public String getmImage() {
		return mImage;
	}


	public void setmImage(String mImage) {
		this.mImage = mImage;
	}
	
	
	
	public String getmRetire() {
		return mRetire;
	}


	public void setmRetire(String mRetire) {
		this.mRetire = mRetire;
	}

	
	

	public Integer getFollowerCount() {
		return followerCount;
	}

	public void setFollowerCount(Integer followerCount) {
		this.followerCount = followerCount;
	}

	public Integer getFollowCount() {
		return followerCount;
	}


	public void setFollowCount(Integer followCount) {
		this.followerCount = followCount;
	}


	public Integer getFollowingCount() {
		return followingCount;
	}


	public void setFollowingCount(Integer followingCount) {
		this.followingCount = followingCount;
	}


	public boolean isMatchPassword(String mPass){
		boolean isMatch=false;
		if(this.mPass.equals(mPass)){
			isMatch=true;
		}
		return isMatch;
	}


	@Override
	public String toString() {
		return "Member [mId=" + mId + ", mPass=" + mPass + ", mName=" + mName + ", mEmail=" + mEmail + ", mPhone="
				+ mPhone + ", mImage=" + mImage + ", mRetire=" + mRetire+"]";
	}

	
	
	
	
	
}
