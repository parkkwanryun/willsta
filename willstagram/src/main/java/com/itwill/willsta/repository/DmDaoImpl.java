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
		System.out.println("### dmMapper Injecetion:"+dmMapper);
	}

	@Override
	public List<DM> dmSelectAll() {
		return dmMapper.dmSelectAll();
	}

	@Override
	public int dmInsert(DM dm) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public DM dmSelectOne(int dmNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int dmUpdate(DM dm) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int dmDelete(int dmNo) {
		// TODO Auto-generated method stub
		return 0;
	}

}
