package com.itwill.willsta.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.itwill.willsta.domain.DmContents;
import com.itwill.willsta.domain.DmContentsCount;

@Mapper
public interface DmContentsMapper {
	
	@Select("SELECT dmNo, dmContentsNo, dmContentsMessage, to_char(dmContentsDate,'HH24:MI') as dmContentsDate " + 
			"FROM dm_contents "+
			"ORDER BY dmContentsDate ASC")
	public List<DmContents> dmcSelectAll();
	
	@Select("SELECT d.dmNo, d.dmContentsNo, d.dmContentsMessage, to_char(d.dmContentsDate,'DD/HH24/MI') as dmContentsDate, d.dmSenderId, " + 
			"  (SELECT m.mImage FROM member m WHERE m.mId IN( "+ 
			"    (SELECT d.dmSenderId FROM DM_CONTENTS WHERE m.mId = d.dmSenderId))) as dmContentsImage, dmChatRead " + 
			"FROM dm_contents d " + 
			"WHERE d.dmNo = #{dmNo} " + 
			"ORDER BY d.dmContentsDate ASC")
	public List<DmContents> dmNoSelectAll(@Param("dmNo") Integer dmNo);
	
	@Select("SELECT dmNo, dmContentsNo, dmContentsMessage, to_char(dmContentsDate,'HH24:MI:SS') as dmContentsDate " + 
			"FROM dm_contents " + 
			"WHERE dmContentsNo = #{dmContentsNo}")
	public DmContents dmcSelectOne(@Param("dmContentsNo") int dmContentsNo);
	
	@Insert("INSERT INTO dm_contents(dmNo, dmContentsNo, dmContentsMessage, dmContentsDate, dmSenderId, dmContentsImage, dmChatRead) " + 
			"VALUES(#{dmNo}, dm_contents_number_seq.nextval, #{dmContentsMessage}, sysdate, #{dmSenderId}, (SELECT m.mImage FROM member m WHERE m.mId =#{dmSenderId}),#{dmChatRead})")
	public int dmcInsert(DmContents dmContents);
	
	@Update("UPDATE dm_contents " + 
			"SET dmContentsMessage = #{dmContentsMessage}, dmContentsDate = sysdate " + 
			"WHERE dmContentsNo = #{dmContentsNo}")
	public int dmcUpdate(DmContents dmContents);
	
	@Delete("DELETE FROM dm_contents WHERE dmContentsNo = #{dmContentsNo}")
	public int dmcDelete(int dmContentsNo);
	
	// DM메시지 수신 시 플래그 변경
	@Update("UPDATE dm_contents "+
			"SET dmChatRead = #{dmChatRead} "+
			"WHERE dmSenderId != #{dmSenderId} AND dmNo = #{dmNo} AND dmChatRead = 0")
	public int dmcReadChat(DmContents dmContents);
	
	// DM메시지 특정 유저 읽지 않은 메세지 갯수
	@Select("SELECT COUNT(dmChatRead) " + 
			"FROM DM_CONTENTS " + 
			"WHERE dmNo = #{dmNo} AND dmSenderId != #{dmSenderId} AND dmChatRead = #{dmChatRead}")
	public int dmNotReadCount(DmContents dmContents);

	// DM 메세지 전체 유저 읽지않은 메세지 정보
	@Select("SELECT d.dmNo, d.dmContentsNo, d.dmContentsMessage, to_char(d.dmContentsDate,'DD/HH24/MI') as dmContentsDate, d.dmSenderId, " + 
			"  (SELECT m.mImage FROM member m WHERE m.mId IN( " + 
			"    (SELECT d.dmSenderId FROM DM_CONTENTS WHERE m.mId = d.dmSenderId))) as dmContentsImage, dmChatRead " + 
			"FROM dm_contents d " + 
			"WHERE dmSenderId != #{dmSenderId} AND dmChatRead = #{dmChatRead} " + 
			"ORDER BY d.dmContentsDate ASC")
	public List<DmContents> dmAllNotReadMessage(DmContents dmContents);
	
	// DM 메세지 전체 유저의 읽지 않은 메세지 채팅방별 합
	@Select("SELECT dmNo, count(dmChatRead) as dmChatReadCount " + 
			"FROM dm_contents " + 
			"WHERE dmSenderId != #{mId} AND dmChatRead = 0" + 
			"GROUP BY dmNo " + 
			"ORDER BY dmNo")
	public List<DmContentsCount> dmAllNotReadCount(@Param("mId") String mId);
}
