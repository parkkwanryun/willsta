package com.itwill.willsta.service;

import java.util.List;

import com.itwill.willsta.domain.Member;

public interface MemberService {
	List<Member> memberList();
	List<Member> findMemberList(String mid);
}
