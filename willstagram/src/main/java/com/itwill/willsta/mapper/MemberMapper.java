package com.itwill.willsta.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.itwill.willsta.domain.Member;

@Mapper
public interface MemberMapper {
	
	/*회원 가입*/
	@Insert("INSERT INTO MEMBER VALUES (#{mId},#{mPass},#{mName},#{mEmail},#{mPhone},#{mImage},#{mRetire})")
	public boolean insertMember(Member member);
	
	/*회원정보 로딩*/
	
	@Select("SELECT mId, mPass, mName, mEmail, mPhone, mImage FROM MEMBER")
	public Member selectById(String mId, String mPhone);
	
	/*회원정보 수정*/
	//"update member set m_pw = ?, m_name = ?, m_phone = ? where m_id = ?;
	@Update("UPDATE MEMBER SET #{mPass}, #{mName}, #{mPhone} where mId=#{mId}")
	public boolean updateMember(Member memeber);
	
	/*회원 탈퇴*/
	//
	@Delete("")
	public boolean deleteMember(String mId);
}
