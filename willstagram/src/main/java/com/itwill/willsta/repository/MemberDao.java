package com.itwill.willsta.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.web.multipart.MultipartFile;

import com.itwill.willsta.domain.Member;

public interface MemberDao {
	
	/*Create(회원가입- 이미지 없음)*/
	boolean insertMember(Member member);
	
	/*Read One(회원정보로딩)*/
	Member selectByIdContainFollowInfo(String mId);

	/*친구추천 - 랜덤로딩 5건*/
	public List<Member> selectByRandom(@Param("mId") String mId);
	
	/*Read One(회원정보로딩)*/
	Member selectById(String mId);
	
	/*Update One(회원정보 수정)*/
	boolean updateMember(Member memeber);
	
	/*Update One(회원 이미지 업로드)*/
	boolean updateMemberImg(String mId, String mImage);
	
	/* 계정 비활성화 (mRetire ON --> OFF)*/
	boolean deleteMember(String mPass, String mEmail, String mRetire);
	
	/* 계정 활성화 (mRetire OFF --> ON)*/
	boolean accountOn(String mRetire, String mEmail);
	
	/*아이디 중복체크*/
	boolean existedMember(String mId);
	
	/*비밀번호 일치여부 체크*/
	boolean existedPassword(String mPass);
	
	/*아이디 찾기*/
	Member findId(String mEmail, String mName);
	
	/*비밀번호 찾기*/
	Member findPw(String mId, String mEmail);
	
	/*임시비밀번호 발급*/
	Member getTempPw(String mPass, String mId);
	
	/*사용자 목록*/
	List<Member> memberList();
	
	/*사용자 다음목록*/
	List<Member> addMemberList(String lastId);
	
	/*사용자 검색*/
	List<Member> findMemberList(String search);
}
