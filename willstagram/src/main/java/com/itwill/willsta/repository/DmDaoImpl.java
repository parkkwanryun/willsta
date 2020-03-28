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

}
