package com.itwill.willsta.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.itwill.willsta.domain.DmContents;

@Mapper
public interface DmContentsMapper {
	
	@Select("SELECT dmNo, dmContentsNo, dmContentsMessage, to_char(dmContentsDate,'HH24:MI') as dmContentsDate " + 
			"FROM dm_contents "+
			"ORDER BY dmContentsDate ASC")
	public List<DmContents> dmcSelectAll();
	
	@Select("SELECT d.dmNo, d.dmContentsNo, d.dmContentsMessage, d.dmContentsDate, d.dmSenderId, " + 
			"  (SELECT m.mImage FROM member m WHERE m.mId IN( "+ 
			"    (SELECT d.dmSenderId FROM DM_CONTENTS WHERE m.mId = d.dmSenderId))) as dmContentsImage " + 
			"FROM dm_contents d " + 
			"WHERE d.dmNo = #{dmNo} " + 
			"ORDER BY d.dmContentsDate ASC")
	public List<DmContents> dmNoSelectAll(@Param("dmNo") Integer dmNo);
	
	@Select("SELECT dmNo, dmContentsNo, dmContentsMessage, to_char(dmContentsDate,'HH24:MI:SS') as dmContentsDate " + 
			"FROM dm_contents " + 
			"WHERE dmContentsNo = #{dmContentsNo}")
	public DmContents dmcSelectOne(@Param("dmContentsNo") int dmContentsNo);
	
	@Insert("INSERT INTO dm_contents(dmNo, dmContentsNo, dmContentsMessage, dmContentsDate, dmSenderId) " + 
			"VALUES(#{dmNo}, dm_contents_number_seq.nextval, #{dmContentsMessage}, sysdate, #{dmSenderId})")
	public int dmcInsert(DmContents dmContents);
	
	@Update("UPDATE dm_contents " + 
			"SET dmContentsMessage = #{dmContentsMessage}, dmContentsDate = sysdate " + 
			"WHERE dmContentsNo = #{dmContentsNo}")
	public int dmcUpdate(DmContents dmContents);
	
	@Delete("DELETE FROM dm_contents WHERE dmContentsNo = #{dmContentsNo}")
	public int dmcDelete(int dmContentsNo);

	
}
