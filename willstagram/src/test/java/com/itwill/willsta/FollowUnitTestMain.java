package com.itwill.willsta;

import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.itwill.willsta.domain.Follow;
import com.itwill.willsta.repository.FollowDaoImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class FollowUnitTestMain {
	@Autowired
	private ApplicationContext applicationContext;
	private FollowDaoImpl followDao;

	@Before
	 public void setUp() throws Exception{
		followDao = this.applicationContext.getBean("followDao", FollowDaoImpl.class);
	}
	
	@Test
	@Ignore
	public void follow() throws Exception{
		boolean follow = followDao.follow(new Follow("준수","예준"));
		System.out.println("## 팔로"+follow);
		
	}

	@Test
	public void unfollow() throws Exception{
		boolean unfollow = followDao.unfollow("똑순이", "e");
		System.out.println("## 당신 언팔." +unfollow);
		
	}
	
	@Test
	@Ignore
	public void followers() throws Exception{
		List<Follow> followers = followDao.followers("mId");
		System.out.println("### followers: "+followers);
	}
	
	@Test
	@Ignore
	public void following() throws Exception{
		List<Follow> following = followDao.following("mId");
		System.out.println("### following:"+following);
	}
	
	@Test
	@Ignore
	public void followCheck() {
		int followCheck=followDao.followCheck("hjs", "ss501");
		System.out.println("### followCheck :"+followCheck);
	}
		
	
	
}

























