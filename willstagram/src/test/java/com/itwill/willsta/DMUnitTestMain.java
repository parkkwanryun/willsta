package com.itwill.willsta;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.itwill.willsta.repository.DmDaoImpl;
import com.itwill.willsta.repository.PostDao;
import com.itwill.willsta.repository.PostDaoImpl;

public class DMUnitTestMain {

	public static void main(String[] args) throws Exception{
		ApplicationContext applicationContext =
				new FileSystemXmlApplicationContext("/src/main/webapp/WEB-INF/spring/root-context.xml");	
		PostDao dao = (PostDaoImpl)applicationContext.getBean(PostDaoImpl.class);
	}
}
