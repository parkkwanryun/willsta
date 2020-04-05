package com.itwill.willsta;


import static org.junit.Assert.assertNotNull;

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
import com.itwill.willsta.repository.MemberDaoImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class MemberUnitTestMain {
	
<<<<<<< HEAD
	public static void main(String[] args) {

		ApplicationContext applicationContext = 
				new FileSystemXmlApplicationContext("/src/main/webapp/WEB-INF/spring/root-context.xml");
		MemberDao memberDao = applicationContext.getBean(MemberDaoImpl.class);
		//System.out.println("회원 탈퇴 "+memberDao.delelteMember("kpr"));
		//System.out.println("회원 찾기"+memberDao.existedMember("pkr"));
		//System.out.println("비밀번호 찾기"+memberDao.findPw("pkr", "세미"));
		//System.out.println(""+memberDao.findMemberList("pkr"));
		
		
		
		System.out.println(memberDao.insertMember(new Member("소진이고생하네","111","매퍼소진","sj@naver.com","010"," ","T")));
		 
=======
	@Autowired
	private ApplicationContext applicationContext;
	private MemberDaoImpl memberDao;
	//private MemberServiceImpl memberService;
	
	@Before
	public void setUp() {
		memberDao=this.applicationContext.getBean(MemberDaoImpl.class);
		//memberService=this.applicationContext.getBean(MemberServiceImpl.class); 
>>>>>>> branch 'master' of https://github.com/parkkwanryun/willsta.git
	}
		
	@Test //회원가입
	@Ignore
	public void insertMember() {
		//boolean member = memberDao.insertMember(new Member("ss501", "12345", "윌스타그램", "bluepk2034@Naver.com","010755555", "","F"));
		//System.out.println("## 회원가입(멤버 추가) :"+member);
	}
	
	@Test //회원탈퇴
	@Ignore
	public void delelteMember() {
		boolean member = memberDao.deleteMember("corona");
		System.out.println("## 회원탈퇴:"+member);
	}
	
	@Test //아이디 중복 확인 
	@Ignore
	public void existedMember() {
		boolean member = memberDao.existedMember("corona");
		System.out.println("## 아이디 중복 여부:"+member);
	}
	
	@Test //아이디 찾기
	@Ignore
	public void findId() {
		Member member = memberDao.findId("bluepk2034@naver.com","륜관팍");
		System.out.println("##아이디 찾기:"+member);
	}
	
	@Test //비밀번호 찾기
	@Ignore
	public void findPw() {
		Member member = memberDao.findPw("pkr", "세미");
		System.out.println("## 비밀번호 찾기:"+member);
	}
	
	@Test //회원정보 수정
	@Ignore
	public void updateMember() {
		//boolean member = memberDao.updateMember(new Member("ksj","12345","소진","sj@naver.com","0100","",""));
		//System.out.println("## 회원정보 수정 성공 여부:"+member);
	}
	
	@Test //임시비밀번호 발급
	@Ignore
	public void getTempPw() {
		Member memberTempPw= memberDao.getTempPw("소진","ksj");
		System.out.println("memberTempPw:"+memberTempPw);
	}
	
	@Test //회원 1명 조회 (팔로워,팔로우 불러오기 포함) 
	@Ignore
	public void selectById() {
		Member member = memberDao.selectById("hjs");
		System.out.println("## 회원 1명 불러오기 :"+member);
	}
	
	@Test //유저 목록
	@Ignore
	public void memberList() {
		List<Member>memberList = memberDao.memberList();
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
