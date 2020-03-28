package com.itwill.willsta.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import com.itwill.willsta.domain.Member;

@Mapper
public interface MemberMapper {
	
	/*회원 가입*/
	@Insert("INSERT INTO MEMBER VALUES (#{mId},#{mPass},#{mName},#{mEmail},#{mPhone},#{mImage},#{mRetire})")
	public boolean insert(Member member);
	
	/*회원정보 불러오기*/
	//update member set mRetire = 'T' where mId = 'pkr';
	/*
	@Select("SELECT mId, mPass, mName, mEmail, mPhone, mImage FROM MEMBER")
	 */
	
}
