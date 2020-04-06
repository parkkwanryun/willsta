package com.itwill.willsta.service;

import java.util.List;
import java.util.Map;

import com.itwill.willsta.domain.DM;
import com.itwill.willsta.domain.DmContents;

public interface DmService {
	// DM 채팅방 생성
	public int dmInsert(DM dm);

	// DM 채팅방 전체 조회
	public List<DM> dmSelectAll(String mId);
	
	// 특정 DM 채팅방 조회
	public DM dmSelectOne(int dmNo);
	
	// DM 채팅방 업데이트
	public int dmUpdate(DM dm);
	
	// DM 채팅방 삭제
	public int dmDelete(int dmNo);
	
	//DM 메시지 전송
	int dmcInsert(DmContents dmContents);
	
	//DM 메시지 전체 조회
	List<DmContents> dmcSelectAll();
	
	//DM 특정 방번호에 대한 메시지 전체 조회
	List<DmContents> dmNoSelectAll(Integer dmNo);
	
	//DM 특정 메시지 조회
	DmContents dmcSelectOne(int dmContentsNo);
	
	//DM 메시지 수정
	int dmcUpdate(DmContents dmContents);
	
	//DM 메시지 삭제
	int dmcDelete(int dmContentsNo);
}
