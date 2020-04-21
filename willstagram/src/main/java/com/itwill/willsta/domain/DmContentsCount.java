package com.itwill.willsta.domain;

public class DmContentsCount {
	Integer dmNo;
	Integer dmChatReadCount;
	public DmContentsCount(Integer dmNo, Integer dmChatReadCount) {
		super();
		this.dmNo = dmNo;
		this.dmChatReadCount = dmChatReadCount;
	}
	public DmContentsCount() {
		super();
	}
	public Integer getDmNo() {
		return dmNo;
	}
	public void setDmNo(Integer dmNo) {
		this.dmNo = dmNo;
	}
	public Integer getDmChatReadCount() {
		return dmChatReadCount;
	}
	public void setDmChatReadCount(Integer dmChatReadCount) {
		this.dmChatReadCount = dmChatReadCount;
	}
	@Override
	public String toString() {
		return "DmContentsCount [dmNo=" + dmNo + ", dmChatReadCount=" + dmChatReadCount + "]\n";
	}
	
}
