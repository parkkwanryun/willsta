package com.itwill.willsta;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.itwill.willsta.repository.MemberDao;
import com.itwill.willsta.repository.MemberDaoImpl;


public class MemberUnitTestMain {
	
	public static void main(String[] args) {

		ApplicationContext applicationContext = 
				new FileSystemXmlApplicationContext("/src/main/webapp/WEB-INF/spring/root-context.xml");
		MemberDao memberDao = applicationContext.getBean(MemberDaoImpl.class);
		 System.out.println(memberDao.delelteMember("kpr"));
	}
}
