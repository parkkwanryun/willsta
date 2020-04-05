package com.itwill.willsta.repository;

import java.util.List;

import com.itwill.willsta.domain.DmContents;

public interface DmContentsDao {
	//DM 메시지 전송
	public int dmcInsert(DmContents dmContents);
	
	//DM 메시지 전체 조회
	public List<DmContents> dmcSelectAll();
	
	//DM 특정 방번호에 대한 메시지 전체 조회
	public List<DmContents> dmNoSelectAll(int dmNo);
	
	//DM 특정 메시지 조회
	public DmContents dmcSelectOne(int dmContentsNo);
	
	//DM 메시지 수정
	public int dmcUpdate(DmContents dmContents);
	
	//DM 메시지 삭제
	public int dmcDelete(int dmContentsNo);
}
