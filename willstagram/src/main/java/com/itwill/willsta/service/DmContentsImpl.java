package com.itwill.willsta.service;
import java.util.List;
import org.springframework.stereotype.Service;
import com.itwill.willsta.domain.DmContents;
import com.itwill.willsta.repository.DmContentsDao;
@Service
public class DmContentsImpl implements DmContentsDao {
	private DmContentsDao dmContentsDao;
	
	@Override
	public int dmcInsert(DmContents dmContents) {
		return dmContentsDao.dmcInsert(dmContents);
	}
	@Override
	public List<DmContents> dmcSelectAll() {
		return dmContentsDao.dmcSelectAll();
	}
	@Override
	public List<DmContents> dmNoSelectAll(int dmNo) {
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