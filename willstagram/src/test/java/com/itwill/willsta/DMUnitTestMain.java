package com.itwill.willsta;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.itwill.willsta.repository.DmDaoImpl;

public class DMUnitTestMain {

	public static void main(String[] args) throws Exception{
		ApplicationContext applicationContext =
				new FileSystemXmlApplicationContext("/src/main/webapp/WEB-INF/spring/root-context.xml");	
		DmDaoImpl dao = (DmDaoImpl)applicationContext.getBean("DmDaoImpl");
		System.out.println(dao.dmSelectAll());
	}
}
