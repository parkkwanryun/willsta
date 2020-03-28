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
		return memberMapper.updateMember(memeber);
	}

	@Override
	public boolean delelteMember(String mId) {
		
		return memberMapper.deleteMember(mId);
	}
	
	@Override
	public boolean existedMember(String mId) {
		return memberMapper.existedMember(mId);
	}

	@Override
	public Member findId(String mEmail, String mName) {
		return memberMapper.findId(mEmail, mName);
	}

	@Override
	public Member findPw(String mId, String mName) {
		return memberMapper.findPw(mId, mName);
	}

	@Override
	public Member getTempPw(Member findMember) {
		return memberMapper.getTempPw(findMember);
	}

	@Override
	public List<Member> memberList() {
		return memberMapper.memberList();
	}
	
	@Override
	public List<Member> findMemberList(String mid) {
		return memberMapper.findMemberList(mid);
	}
	
}
