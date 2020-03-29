package com.itwill.willsta;


import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.itwill.willsta.domain.Member;
import com.itwill.willsta.repository.MemberDao;
import com.itwill.willsta.repository.MemberDaoImpl;
import com.itwill.willsta.service.MemberServiceImpl;
		//MemberDao memberDao = applicationContext.getBean(MemberDaoImpl.class);
		//System.out.println("회원 탈퇴 "+memberDao.delelteMember("kpr"));
		//System.out.println("회원 찾기"+memberDao.existedMember("pkr"));
		//System.out.println("비밀번호 찾기"+memberDao.findPw("pkr", "세미"));
		//System.out.println(memberDao.insertMember(new Member("소진이고생하네","111","매퍼소진","sj@naver.com","010"," ","T")));
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class MemberUnitTestMain {
	
	@Autowired
	private ApplicationContext applicationContext;
	private MemberDaoImpl memberDao;
	//private MemberServiceImpl memberService;
	
	@Before
	public void setUp() {
		memberDao=this.applicationContext.getBean(MemberDaoImpl.class);
		//memberService=this.applicationContext.getBean(MemberServiceImpl.class); 
	}
	
	@Test //유저 목록
	@Ignore
	public void memberList() {
		List<Member>memberList=memberDao.memberList();
		//List<Member>memberList=memberService.memberList();
		System.out.println("### memberList: "+memberList);
	}
	
	@Test //유저 검색
	@Ignore
	public void findMemberList() {
		List<Member>findMemberList=memberDao.findMemberList("j");
		//List<Member>findMemberList=memberService.findMemberList("j");
		System.out.println("### findMemberList: "+findMemberList);
	}

	
}
