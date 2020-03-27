package com.itwill.willsta.domain;

public class Member {
	private String mId;
	private String mPass;
	private String mName;
	private String mEmail;
	private String mPhone;
	private String mImage;
	
	public Member() {
		// TODO Auto-generated constructor stub
	}


	public Member(String mId, String mPass, String mName, String mEmail, String mPhone, String mImage) {
		super();
		this.mId = mId;
		this.mPass = mPass;
		this.mName = mName;
		this.mEmail = mEmail;
		this.mPhone = mPhone;
		this.mImage = mImage;
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
	
	public boolean isMatchPassword(String mPass){
		boolean isMatch=false;
		if(this.mPass.equals(mPass)){
			isMatch=true;
		}
		return isMatch;
	}

	@Override
	public String toString() {
		return "member [mId=" + mId + ", mPass=" + mPass + ", mName=" + mName + ", mEmail=" + mEmail + ", mPhone="
				+ mPhone + ", mNick=" + ", mImage=" + mImage + "]";
	}
	
	
}
