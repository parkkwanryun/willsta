package com.itwill.willsta.repository;

import java.util.List;

import com.itwill.willsta.domain.DM;

public interface DmDao {
	public int dmInsert(DM dm);
	public List<DM> dmSelectAll();
	public DM dmSelectOne(int dmNo);
	public int dmUpdate(DM dm);
	public int dmDelete(int dmNo);
	
}
