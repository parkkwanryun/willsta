package com.itwill.willsta.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwill.willsta.domain.DM;
import com.itwill.willsta.domain.DmContents;
import com.itwill.willsta.domain.Member;
import com.itwill.willsta.repository.DmContentsDao;
import com.itwill.willsta.repository.DmDao;
import com.itwill.willsta.repository.MemberDao;
@Service
public class DmServiceImpl implements DmService {
	@Autowired
	private DmDao dmDao;
	
	@Autowired
	private DmContentsDao dmContentsDao;
	
	@Override
	public int dmInsert(DM dm) {
		 return dmDao.dmInsert(dm);
	}
	@Override
	public List<DM> dmSelectAll(String mId) {
		return dmDao.dmSelectAll(mId);
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
	@Override
	public int dmcInsert(DmContents dmContents) {
		return dmContentsDao.dmcInsert(dmContents);
	}
	@Override
	public List<DmContents> dmcSelectAll() {
		return dmContentsDao.dmcSelectAll();
	}
	@Override
	public List<DmContents> dmNoSelectAll(Integer dmNo) {
		return dmContentsDao.dmNoSelectAll(dmNo);
	}
	@Override
	public DmContents dmcSelectOne(int dmContentsNo) {
		return dmContentsDao.dmcSelectOne(dmContentsNo);
	}
	@Override
	public int dmcUpdate(DmContents dmContents) {
		return dmContentsDao.dmcUpdate(dmContents);
	}
	@Override
	public int dmcDelete(int dmContentsNo) {
		return dmContentsDao.dmcDelete(dmContentsNo);
	}
}
