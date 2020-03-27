package com.itwill.willsta.domain;

public class PostImage {
	private Integer pNo;
	private String fileName;
	
	public PostImage() {
		// TODO Auto-generated constructor stub
	}

	public PostImage(Integer pNo, String fileName) {
		super();
		this.pNo = pNo;
		this.fileName = fileName;
	}

	public Integer getpNo() {
		return pNo;
	}

	public void setpNo(Integer pNo) {
		this.pNo = pNo;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	
}
