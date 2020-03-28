package com.itwill.willsta.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.itwill.willsta.domain.DM;

@Mapper
public interface DMMapper {
	//채팅방 목록 전체 출력
	@Select("SELECT dmNo, mId, mIdYou, to_char(dmDate,'MM/DD') as dmDate FROM dm")
	public List<DM> dmSelectAll();	
	
	//특정 채팅방 번호만 출력
	@Select("SELECT dmNo, mId, mIdYou, to_char(dmDate,'MM/DD') as dmDate"
			+ " FROM dm "
			+ "WHERE dmNo = #{dmNo}")
	public DM dmSelectOne(int dmNo);
	
	//채팅방 유저 수정
	@Update("UPDATE dm " + 
			"SET mId = #{mId}, mIdyou = #{mIdYou}, dmDate = sysdate " + 
			"WHERE dmNo = #{dmNo}")
	public int dmUpdate(DM dm);
	
	//채팅방 생성
	@Insert("INSERT INTO dm(dmNo, mId, mIdYou, dmDate) VALUES(dm_number_seq.nextval, #{mId}, #{mIdYou}, sysdate)")
	public int dmInsert(DM dm);
	
	//채팅방 삭제
	@Delete("DELETE FROM dm " + 
			"WHERE dmNo = #{dmNo}")
	public int dmDelete(int dmNo);
}
