package com.itwill.willsta;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.itwill.willsta.domain.Member;
import com.itwill.willsta.repository.MemberDao;
import com.itwill.willsta.repository.MemberDaoImpl;


public class MemberUnitTestMain {
	
	public static void main(String[] args) {

		ApplicationContext applicationContext = 
				new FileSystemXmlApplicationContext("/src/main/webapp/WEB-INF/spring/root-context.xml");
		MemberDao memberDao = applicationContext.getBean(MemberDaoImpl.class);
		//System.out.println("회원 탈퇴 "+memberDao.delelteMember("kpr"));
		//System.out.println("회원 찾기"+memberDao.existedMember("pkr"));
		//System.out.println("비밀번호 찾기"+memberDao.findPw("pkr", "세미"));
		//System.out.println(""+memberDao.findMemberList("pkr"));
		
		
		
		System.out.println(memberDao.insertMember(new Member("소진이고생하네","111","매퍼소진","sj@naver.com","010"," ","T")));
		 
	}
}
