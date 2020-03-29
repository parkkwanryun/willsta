package com.itwill.willsta.repository;

import java.util.List;

import com.itwill.willsta.domain.DM;

public interface DmDao {
	// DM 채팅방 생성
	public int dmInsert(DM dm);
	
	// DM 채팅방 리스트 조회
	public List<DM> dmSelectAll();
	
	// DM 채팅방 선택조회
	public DM dmSelectOne(int dmNo);
	
	// DM 채팅방 업데이트
	public int dmUpdate(DM dm);
	
	// DM 채팅방 삭제
	public int dmDelete(int dmNo);
	
}
