package com.itwill.willsta;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.itwill.willsta.domain.Comments;
import com.itwill.willsta.repository.CommentsDao;
import com.itwill.willsta.repository.CommentsDaoImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml", "file:src/main/webapp/WEB-INF/spring/appsurvlet/survlet-context.xml"})
public class CommentsDaoTest {
	@Autowired
	private ApplicationContext applicationContext;
	
	private CommentsDao commentsDao;
	private Comments comments;
	
	@Before
    public void setUp() {
        commentsDao = this.applicationContext.getBean("commentsDao", CommentsDaoImpl.class);
    }
    
    @Test
    public void commentsInsertTest() throws Exception {
    	comments = new Comments(-999, 22, "hjs", "DAO test insert");
    	
    	commentsDao.createComments(comments);
    }

	
}
