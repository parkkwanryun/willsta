package com.itwill.willsta.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.itwill.willsta.domain.Member;

public interface MemberService {
	
	boolean insertMember(Member member);
	
	boolean updateMember(Member member, MultipartFile mUploadImg);

	Member selectById(String mId);
	
	Member selectByIdContainFollowInfo(String mId);
	
	List<Member> selectByRandom(String mId);

	boolean deleteMember(String mId);
	
	boolean existedMember(String mId);
	
	Member findId(String mEmail, String mName);
	
	Member findPw(String mId, String mName);
	
	Member getTempPw(String mPass, String mId);
	
	Member signIn(String mId, String mPass) throws Exception;
	
	List<Member> memberList();
	
	List<Member> addMemberList(String lastId);
	
	List<Member> findMemberList(String findId);

}
