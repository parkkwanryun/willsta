package com.itwill.willsta.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.itwill.willsta.domain.DmContents;

@Mapper
public interface DmContentsMapper {
	
	@Select("SELECT dmNo, dmContentsNo, dmContentsMessage, to_char(dmContentsDate,'HH24:MI') as dmContentsDate, dmContentsImage " + 
			"FROM dm_contents"+
			"ORDER BY dmContentsDate ASC")
	public List<DmContents> dmcSelectAll();
}
