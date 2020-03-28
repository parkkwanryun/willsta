package com.itwill.willsta.mapper;

import java.util.List;

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
	@Update("UPDATE MEMBER SET #{mPass}, #{mName}, #{mPhone} WHERE mId=#{mId}")
	public boolean updateMember(Member memeber);
	
	/*회원 탈퇴*/
	@Update("UPDATE MEMBER SET mRetire =#{T} WHERE mId=#{mId}")
	public boolean deleteMember(String mRetire);
	
	/*아이디 중복체크*/
	@Select("SELECT count(*) cnt FROM MEMBER WHERE mId= #{mId}")
	public boolean existedMember(String mId);
	
	
	
	@Select("SELECT mid, mname, mimage FROM member")
	public List<Member> memberList();
	
	@Select("SELECT mid, mname, mimage FROM member where mid like ‘%'||#{mid}||'%’ ")
	public List<Member> findMemberList(String mid);
}
