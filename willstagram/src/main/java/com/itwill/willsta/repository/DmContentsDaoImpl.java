package com.itwill.willsta.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.willsta.domain.DmContents;
import com.itwill.willsta.mapper.DmContentsMapper;

@Repository(value = "dmContentsDao")
public class DmContentsDaoImpl implements DmContentsDao {
	@Autowired
	private DmContentsMapper dmContentsMapper;
	
	//메시지 전송
	@Override
	public int dmcInsert(DmContents dmContents) {
		return dmContentsMapper.dmcInsert(dmContents);
	}
	
	//메시지 전체 조회
	@Override	
	public List<DmContents> dmcSelectAll() {
		return dmContentsMapper.dmcSelectAll();
	}
	// 특정 방번호 메시지 전체 조회
	@Override
	public List<DmContents> dmNoSelectAll(int dmNo) {
		return dmContentsMapper.dmNoSelectAll(dmNo);
	}

	// 특정 메시지 조회
	@Override
	public DmContents dmcSelectOne(int dmContentsNo) {
		return dmContentsMapper.dmcSelectOne(dmContentsNo);
	}

	// 특정 메시지 업데이트
	@Override
	public int dmcUpdate(DmContents dmContents) {
		return dmContentsMapper.dmcUpdate(dmContents);
	}
	
	// 특정 메시지 삭제
	@Override
	public int dmcDelete(int dmContentsNo) {
		return dmContentsMapper.dmcDelete(dmContentsNo);
	}

}
