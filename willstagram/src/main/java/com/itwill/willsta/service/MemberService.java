package com.itwill.willsta.service;

import java.util.List;

import com.itwill.willsta.domain.Member;

public interface MemberService {
		
	boolean insertMember(Member member);
	
	Member selectById(String mId);
	
	boolean updateMember(Member member);
	
	boolean deleteMember(String mId);
	
	boolean existedMember(String mId);
	
	Member findId(String mEmail, String mName);
	
	Member findPw(String mId, String mName);
	
	Member getTempPw(String mPass, String mId);
	
	List<Member> memberList();
	List<Member> findMemberList(String mId);
}
