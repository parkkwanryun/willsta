package com.itwill.willsta.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.itwill.willsta.domain.DM;

@Mapper
public interface DMMapper {
	// 채팅방 채팅중인 목록 전체 출력
	@Select("SELECT d.dmNo, d.mId, to_char(dmDate,'MM/DD') as dmDate, " + 
			"        (SELECT m.mImage FROM member m WHERE m.mId IN( " + 
			"            (SELECT d.mId FROM DM WHERE m.mId = d.mId))) as mImage " + 
			"FROM dm d " + 
			"WHERE d.mId != #{mId} AND d.dmNo IN(SELECT DMNO FROM DM WHERE mId = #{mId})")
	public List<DM> dmRoomSelectAll(String mId);
	
	//현재 생성된 마지막 방번호 조회
	@Select("SELECT DM_NUMBER_SEQ.currval FROM dual")
	public String dmGetCurrentDmNo();
	
	//로그인한 사람의 채팅방만 출력
	@Select("SELECT dmNo, mId, mIdYou, to_char(dmDate,'MM/DD') as dmDate"
			+ " FROM dm "
			+ "WHERE dmNo = #{dmNo}")
	public DM dmSelectOne(int dmNo);
	
	//채팅방 유저 수정
	@Update("UPDATE dm " + 
			"SET mId = #{mId}, mIdyou = #{mIdYou}, dmDate = sysdate " + 
			"WHERE dmNo = #{dmNo}")
	public int dmUpdate(DM dm);
	
	//상대 채팅방 생성
	@Insert("INSERT INTO dm(dmNo, mId, dmDate) VALUES(#{dmNo}, #{mId}, sysdate)")
	public int dmLastInsert(@Param("dmNo") Integer dmNo, @Param("mId") String mId);
	
	//첫 채팅방 생성
	@Insert("INSERT INTO dm(dmNo, mId, dmDate) VALUES(dm_number_seq.nextval, #{mId}, sysdate)")
	public int dmFirstInsert(String mId);
	
	//채팅방 삭제
	@Delete("DELETE FROM dm " + 
			"WHERE dmNo = #{dmNo}")
	public int dmDelete(int dmNo);
}
