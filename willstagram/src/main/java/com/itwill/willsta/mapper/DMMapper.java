package com.itwill.willsta.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.itwill.willsta.domain.DM;

@Mapper
public interface DMMapper {
	
	@Select("SELECT dmNo, mId, mIdYou, to_char(dmDate,'MM/DD') as dmDate FROM dm")
	public List<DM> dmSelectAll();
}
