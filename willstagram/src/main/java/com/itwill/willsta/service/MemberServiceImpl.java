package com.itwill.willsta.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwill.willsta.domain.Member;
import com.itwill.willsta.repository.MemberDao;
@Service
public class MemberServiceImpl implements MemberService{
	@Autowired
	MemberDao memberDao;
	
	@Override
	public List<Member> memberList() {
		return memberDao.memberList();
	}

	@Override
	public List<Member> findMemberList(String mid) {
		return memberDao.findMemberList(mid);
	}

}
