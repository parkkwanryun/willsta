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

import com.itwill.willsta.domain.Comments;
import com.itwill.willsta.repository.CommentsDaoImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class CommentsUnitTest {
	@Autowired
	private ApplicationContext applicationContext;
	private CommentsDaoImpl commentsDao;
	
	@Before
    public void setUp() {
        commentsDao = this.applicationContext.getBean("commentsDao", CommentsDaoImpl.class);
    }
    
	@Test //댓글 전체 조회
	@Ignore
    public void findCommentsListTest() throws Exception {
    	List<Comments> commentsList = commentsDao.findCommentsList();
    	System.out.println("### findCommentsList: "+commentsList);
    }
	
    @Test //댓글 하나 조회
    @Ignore
    public void findCommentsTest() throws Exception {
    	Comments comments = new Comments();
    	comments = commentsDao.findComments(3);
    	System.out.println("### findComments: "+comments);
    }
    
    @Test //댓글 작성
    @Ignore
    public void createCommentsTest() throws Exception {
    	Comments comments = new Comments(-999, 8, "hjs", "DAO insert test");
    	commentsDao.createComments(comments);
    }
    
    @Test //댓글 삭제
    @Ignore
    public void removeCommentsTest() throws Exception {
    	int removeResult = commentsDao.removeComments(9);
    	Assert.assertEquals(1, removeResult);
    }
    
    @Test //댓글 수정
    @Ignore
    public void updateCommentsTest() throws Exception {
    	Comments comments = commentsDao.findComments(11);
    	comments.setcContents("Dao 댓글 변경 Test");
    	int updateResult = commentsDao.updateComments(comments);
    	Assert.assertEquals(1, updateResult);
    }
    
    @Test //하나의 포스트에 따른 한 맴버의 댓글 수
    @Ignore
    public void postCommentsCountBymId() throws Exception {
    	int postCommentsCount = commentsDao.postCommentsCountBymId(10, "KJS");
    	Assert.assertEquals(3, postCommentsCount);
    }
     
    @Test //한 맴버가 작성한 총 댓글 수
    @Ignore
    public void totalCommentsCount() throws Exception {
    	int totalCommentsCount = commentsDao.totalCommentsCountBymId("KJS");
    	Assert.assertEquals(5, totalCommentsCount);
    }
    
    @Test //하나의 포스트에 달린 총 댓글 수
    @Ignore
    public void postCommentsCount() throws Exception {
    	int postCommentsCount = commentsDao.postCommentsCount(15);
    	Assert.assertEquals(10, postCommentsCount);
    }
    
	
}
