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
	}//
	
	@Override
	public Member selectById(String mId) {
		return memberMapper.selectById(mId);
	}//

	@Override
	public boolean updateMember(Member memeber) {
		return memberMapper.updateMember(memeber);
	}//

	@Override
	public boolean deleteMember(String mId) {
		return memberMapper.deleteMember(mId);
	}//
	
	@Override
	public boolean existedMember(String mId) {
		return memberMapper.existedMember(mId);
	}//

	@Override
	public Member findId(String mEmail, String mName) {
		return memberMapper.findId(mEmail, mName);
	}//

	@Override
	public Member findPw(String mId, String mName) {
		return memberMapper.findPw(mId, mName);
	}//

	@Override
	public Member getTempPw(String mId, String mEmail) {
		return memberMapper.getTempPw(mId, mEmail);
	}//

	@Override
	public List<Member> memberList(String lastId) {
		return memberMapper.memberList(lastId);
	}
	
	@Override
	public List<Member> findMemberList(String findId) {
		return memberMapper.findMemberList(findId);
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
