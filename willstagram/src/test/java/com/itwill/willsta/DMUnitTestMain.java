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

import com.itwill.willsta.domain.DM;
import com.itwill.willsta.domain.DmContents;
import com.itwill.willsta.repository.DmDaoImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class DMUnitTestMain {
	@Autowired
	private ApplicationContext applicationContext;
	private DmDaoImpl dmDao;
	
		@Before
		 public void setUp() throws Exception{
			dmDao = this.applicationContext.getBean("dmDao", DmDaoImpl.class);
		}
		
		@Test //채팅방 전체 조회
		 public void findAllChat() throws Exception {
	    	List<DM> dmListAll = dmDao.dmSelectAll();
	    	System.out.println("### dmListAll: "+dmListAll);
	    }
		
		@Test
		public void findAllMessage() throws Exception {
			DM dm = dmDao.dmSelectOne(1);
			System.out.println("######################"+dm);
		}
		
}
