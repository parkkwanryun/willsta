package com.itwill.willsta.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
	public Member selectById(String mId, String mPhone) {
		return memberMapper.selectById(mId, mPhone);
	}

	@Override
	public boolean updateMember(Member memeber) {

		return false;
	}

	@Override
	public boolean delelteMember(String mId) {
		
		return false;
	}
	@Override
	public boolean existedMember(String mId) {
		return false;
	}

	@Override
	public Member findId(String mEmail, String mName) {
		return null;
	}

	@Override
	public Member findPw(String mId, String mName) {
		return null;
	}

	@Override
	public Member getTempPw(Member findMember) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Member> selectAllMemberList(String mId) {
		// TODO Auto-generated method stub
		return null;
	}
}
