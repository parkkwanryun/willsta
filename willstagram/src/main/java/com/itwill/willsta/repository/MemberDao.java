package com.itwill.willsta.repository;

import java.util.List;

import com.itwill.willsta.domain.Member;

public interface MemberDao {
	
	/*Create(회원가입)*/
	boolean insertMember(Member member);
	
	/*Read One(회원정보로딩)*/
	Member selectById(String mId);
	
	/*Update One(회원정보 수정)*/
	boolean updateMember(Member memeber);
	
	/*Delete One(회원탈퇴)(mRetire F --> T)(followerCount, followingCount --> 0)*/
	boolean deleteMember(String mId);
	
	/*아이디 중복체크*/
	boolean existedMember(String mId);
	
	/*아이디 찾기*/
	Member findId(String mEmail, String mName);
	
	/*비밀번호 찾기*/
	Member findPw(String mId, String mName);
	
	/*임시비밀번호 발급*/
	Member getTempPw(String mPass, String mId);
	
	/*사용자 전체목록*/
	List<Member> memberList();
	
	/*사용자 검색*/
	List<Member> findMemberList(String mId);
}
