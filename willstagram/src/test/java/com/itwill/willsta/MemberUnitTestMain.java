package com.itwill.willsta;


import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.itwill.willsta.domain.Member;
import com.itwill.willsta.repository.MemberDaoImpl;

		//System.out.println("비밀번호 찾기"+memberDao.findPw("pkr", "세미"));
		//System.out.println("회원 가입"+memberDao.insertMember(new Member("소진이고생하네","111","매퍼소진","sj@naver.com","010"," ","T")));
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
	@Test //아이디 찾기 
	@Ignore
	public void findMemberById() {
		Member member = memberDao.findId("mEmail","mName");
		System.out.println("##멤버 하나 찾기:"+member);
	}
	
	@Test // 회원탈퇴
	@Ignore
	public void delelteMember() {
		boolean member = memberDao.delelteMember("corona");
		System.out.println("## 회원탈퇴:"+member);
	}
	
	@Test // 아이디 중복 확인 
	@Ignore
	public void existedMember() {
		boolean member = memberDao.existedMember("corona");
		System.out.println("## 아이디 중복 여부:"+member);
	}
	
	
	
	
	@Test //회원정보 수정
	@Ignore
	public void updateMember() {
		boolean member = memberDao.updateMember(new Member("222","김소진","sj@naver.com","0100"," ","F","소진이고생하네"));
		System.out.println("## 회원정보 수정 성공 여부:"+member);
	}
	
	@Test //임시비밀번호 발급
	@Ignore
	public void getTempPw() {
		Member memberTempPw= memberDao.getTempPw("123","소진이고생하네");
		System.out.println("memberTempPw:"+memberTempPw);
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
