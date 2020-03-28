package com.itwill.willsta;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.itwill.willsta.domain.DM;
import com.itwill.willsta.mapper.DMMapper;
import com.itwill.willsta.mapper.DmContentsMapper;
import com.itwill.willsta.repository.DmDao;
import com.itwill.willsta.repository.DmDaoImpl;

public class DMUnitTestMain {

	public static void main(String[] args) throws Exception{
		ApplicationContext applicationContext =
				new FileSystemXmlApplicationContext("/src/main/webapp/WEB-INF/spring/root-context.xml");	
		/*
		DMMapper mapper = (DMMapper)applicationContext.getBean(DMMapper.class);
		System.out.println(mapper.dmSelectAll());
		*/
//		DMMapper mapper = applicationContext.getBean(DMMapper.class);
//		System.out.println(mapper.dmSelectAll());
//		System.out.println(mapper.dmSelectOne(1));
//		System.out.println(mapper.dmUpdate(new DM(1, "rkp", "호에엥", "")));
//		System.out.println(mapper.dmInsert(new DM(-999, "kpr", "나와라요", "")));
//		System.out.println(mapper.dmDelete(2));

		DmContentsMapper mapperContents = (DmContentsMapper)applicationContext.getBean(DmContentsMapper.class);
		System.out.println(mapperContents.dmcSelectAll());
	}
}
