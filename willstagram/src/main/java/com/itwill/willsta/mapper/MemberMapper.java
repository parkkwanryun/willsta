package com.itwill.willsta.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.itwill.willsta.domain.Member;

@Mapper
public interface MemberMapper {
	
	/*회원 가입*/
	@Insert("INSERT INTO MEMBER VALUES (#{mId},#{mPass},#{mName},#{mEmail},#{mPhone},#{mImage},#{mRetire})")
	public boolean insertMember(Member member);
	
	/*회원정보 로딩*/
	@Select("SELECT m.mId, m.mPass, m.mName, m.mEmail, m.mPhone, m.mImage FROM MEMBER M INNER JOIN FOLLOW F ON f.mId=#{mId} WHERE #{mId}=f.mId")
	public Member selectByIdContainFollowInfo(@Param("mId") String mId);
	
	/*팔로우 정보 없는 회원정보 로딩*/
	@Select("SELECT mId, mPass, mName, mEmail, mPhone, mImage FROM MEMBER WHERE mId=#{mId} ")
	public Member selectById(@Param("mId") String mId);
	
	/*회원정보 수정*/
	@Update("UPDATE MEMBER SET mId=#{mId}, mPass=#{mPass}, mName=#{mName}, mEmail=#{mEmail}, mPhone=#{mPhone}, mImage=#{mImage} WHERE mId=#{mId}")
	public boolean updateMember(Member memeber);
	
	/*회원 탈퇴*/
	@Update("UPDATE MEMBER SET mRetire = 'T' WHERE mId = #{mId}")
	public boolean deleteMember(@Param("mId") String mId);
	
	/*아이디 중복체크*/
	@Select("SELECT count(*) cnt FROM MEMBER WHERE mId=#{mId}")
	public boolean existedMember(@Param("mId") String mId);
	
	/*아이디 찾기*/
	@Select("SELECT mId FROM MEMBER WHERE mEmail=#{mEmail} and mName=#{mName}")
	public Member findId(@Param("mEmail") String mEmail, @Param("mName") String mName);
	
	/*비밀번호 찾기*/
	@Select("SELECT mPass FROM MEMBER WHERE mId=#{mId} and mName=#{mName}")
	public Member findPw(@Param("mId") String mId, @Param("mName") String mName);
	
	/*임시비밀번호 발급*/
	@Update("UPDATE MEMBER SET mPass=#{mPass} WHERE mId=#{mId}")
	public Member getTempPw(@Param("mId") String mPass, @Param("mEmail") String mId);

	
	@Select("SELECT mid, mname, mimage FROM member")
	public List<Member> memberList();
	
	@Select("SELECT mid, mname, mimage FROM member where mid like '%${mId}%' ")
	public List<Member> findMemberList(@Param("mId") String mId);
}
