package com.itwill.willsta;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.itwill.willsta.domain.Comments;
import com.itwill.willsta.repository.CommentsDaoImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class CommentsDaoTest {
	@Autowired
	private ApplicationContext applicationContext;
	private CommentsDaoImpl commentsDao;
	
	@Before
    public void setUp() {
        commentsDao = this.applicationContext.getBean("commentsDao", CommentsDaoImpl.class);
    }
    
    @Test
    public void findCommentsTest() throws Exception {
    	Comments comments = new Comments();
    	comments = commentsDao.findComments(3);
    	System.out.println(comments);
    }

	
}
