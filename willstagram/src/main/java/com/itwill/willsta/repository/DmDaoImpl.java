package com.itwill.willsta.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.willsta.domain.DM;
import com.itwill.willsta.mapper.DMMapper;

@Repository
public class DmDaoImpl implements DmDao {
	@Autowired
	private DMMapper dmMapper;
	
	
	public DmDaoImpl() {
	}
	//채팅방 전체 조회
	@Override
	public List<DM> dmSelectAll() {
		return dmMapper.dmSelectAll();
	}
	
	//채팅방 생성
	@Override
	public int dmInsert(DM dm) {
		return dmMapper.dmInsert(dm);
	}
	// 채팅방 선택 조회
	@Override
	public DM dmSelectOne(int dmNo) {
		return dmMapper.dmSelectOne(dmNo);
	}
	//채팅방 업데이트
	@Override
	public int dmUpdate(DM dm) {
		return dmMapper.dmUpdate(dm);
	}

	//채팅방 삭제
	@Override
	public int dmDelete(int dmNo) {
		return dmMapper.dmDelete(dmNo);
	}
}
