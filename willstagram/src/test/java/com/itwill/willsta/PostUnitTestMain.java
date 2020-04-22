package com.itwill.willsta;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.itwill.willsta.repository.PostDao;
import com.itwill.willsta.repository.PostDaoImpl;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class PostUnitTestMain {
	
	public static void main(String[] args) {

		ApplicationContext applicationContext = new FileSystemXmlApplicationContext(
				"/src/main/webapp/WEB-INF/spring/root-context.xml");
		PostDao postDao = applicationContext.getBean(PostDaoImpl.class);
	}
	   
	   @Autowired
	   private ApplicationContext applicationContext;
	   private PostDaoImpl postDao;
	   //private MemberServiceImpl memberService;
	   
	@Before
    public void setUp() {
		postDao = this.applicationContext.getBean(PostDaoImpl.class);
		//postService = this.applicationContext.getBean("postService", PostServiceImpl.class);
    }
	
	@Test // 상태변경
	@Ignore
	public void change_status() {
		int success= postDao.status_update(18, "");
		System.out.println("####상태 변경 성공:"+success);
	}
	
	@Test 
	@Ignore
	public void test1() {
		int i = postDao.delete(18);
		System.out.println("#### 포스트 삭제 테스트"+i);
	}
}
