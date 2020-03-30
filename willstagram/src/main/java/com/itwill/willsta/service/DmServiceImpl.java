package com.itwill.willsta.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwill.willsta.domain.DM;
import com.itwill.willsta.repository.DmDao;
@Service
public class DmServiceImpl implements DmService {
	@Autowired
	private DmDao dmDao;
	
	@Override
	public int dmInsert(DM dm) {
		return dmDao.dmInsert(dm);
	}
	@Override
	public List<DM> dmSelectAll() {
		return dmDao.dmSelectAll();
	}
	@Override
	public DM dmSelectOne(int dmNo) {
		return dmDao.dmSelectOne(dmNo);
	}
	@Override
	public int dmUpdate(DM dm) {
		return dmDao.dmUpdate(dm);
	}
	@Override
	public int dmDelete(int dmNo) {
		return dmDao.dmDelete(dmNo);
	}
}
