package com.itwill.willsta.repository;

import java.util.List;

import com.itwill.willsta.domain.DM;

public interface DmDao {
	// DM 상대 채팅방 생성
	public int dmFirstInsert(String mId);
	// DM 첫 채팅방 생성
	public int dmLastInsert(int dmNo, String mId);
	
	
	// DM 채팅중인 리스트 조회
	public List<DM> dmSelectAll(String mId, Integer dmNo);

	// DM 채팅방 전체 리스트 조회
	public List<DM> dmRoomSelectAll(String mId);
	
	// DM 채팅방 선택조회
	public DM dmSelectOne(int dmNo);
	
	
	// DM 채팅방 업데이트
	public int dmUpdate(DM dm);
	
	// DM 채팅방 삭제
	public int dmDelete(int dmNo);
	
}
