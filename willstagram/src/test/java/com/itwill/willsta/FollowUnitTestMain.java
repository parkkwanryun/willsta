package com.itwill.willsta;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;


public class FollowUnitTestMain {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new FileSystemXmlApplicationContext("/src/main/webapp/WEB-INF/spring/root-context.xml");
	}

}
