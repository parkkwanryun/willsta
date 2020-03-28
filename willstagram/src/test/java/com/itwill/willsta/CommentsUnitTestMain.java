package com.itwill.willsta;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itwill.willsta.domain.Comments;
import com.itwill.willsta.repository.CommentsDaoImpl;

public class CommentsUnitTestMain {

	public static void main(String[] args) throws Exception {

		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/root-context.xml");
	//	CommentsDaoImpl commentDaoImpl = applicationContext.getBean(CommentsDaoImpl.class);
		
		//commentDaoImpl.createComments(new Comments(-999, 22, "hjs", "DAO test"));
		

	}

}
