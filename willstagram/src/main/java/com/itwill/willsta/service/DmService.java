package com.itwill.willsta.service;

import java.util.List;
import java.util.Map;

import com.itwill.willsta.domain.DM;

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
}
