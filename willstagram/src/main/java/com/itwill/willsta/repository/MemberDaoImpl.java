package com.itwill.willsta.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.itwill.willsta.domain.Member;
import com.itwill.willsta.mapper.MemberMapper;

@Repository
public class MemberDaoImpl implements MemberDao{
	@Autowired
	MemberMapper memberMapper;
	
	@Override
	public boolean insertMember(Member member) {
		return memberMapper.insertMember(member);
	}
	
	@Override
	public Member selectById(String mId) {
		return memberMapper.selectById(mId);
	}//

	@Override
	public boolean updateMember(Member member) {
		return memberMapper.updateMember(member);
	}//
	
	@Override
	public boolean updateMemberImg(String mId, String mImage) {
		return memberMapper.insertImg(mId, mImage);
	}
	
	@Override
	public boolean deleteMember(String mPass, String mEmail, String mRetire) {
		return memberMapper.deleteMember(mPass, mEmail, mRetire);
	}//

	@Override
	public boolean accountOn(String mRetire,String mEmail) {
		return memberMapper.accountOn(mRetire, mEmail);
	}

	@Override
	public boolean existedMember(String mId) {
		return memberMapper.existedMember(mId);
	}//


	@Override
	public boolean existedPassword(String mPass) {
		return memberMapper.existedPassword(mPass);
	}
	
	@Override
	public Member findId(String mEmail, String mName) {
		return memberMapper.findId(mEmail, mName);
	}//

	@Override
	public Member findPw(String mId, String mEmail) {
		return memberMapper.findPw(mId, mEmail);
	}//

	@Override
	public Member getTempPw(String mId, String mEmail) {
		return memberMapper.getTempPw(mId, mEmail);
	}//

	@Override
	public List<Member> memberList() {
		return memberMapper.memberList();
	}
	
	@Override
	public List<Member> addMemberList(String lastId) {
		return memberMapper.addMemberList(lastId);
	}
	
	@Override
	public List<Member> findMemberList(String search) {
		return memberMapper.findMemberList(search);
	}
	
	@Override
	public Member selectByIdContainFollowInfo(String mId) {
		return memberMapper.selectByIdContainFollowInfo(mId);
	}
	
	/*친구추천 - 랜덤로딩 5건*/
	@Override
	public List<Member> selectByRandom(String mId) {
		return memberMapper.selectByRandom(mId);
	}

	




	
	
}
