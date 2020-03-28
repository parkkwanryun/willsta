package com.itwill.willsta;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.itwill.willsta.domain.DM;
import com.itwill.willsta.domain.DmContents;
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
		
//		List<DmContents> dmc;
		DmContentsMapper mapperContents = (DmContentsMapper)applicationContext.getBean(DmContentsMapper.class);
		System.out.println(mapperContents.dmcSelectAll());
//		dmc = (List<DmContents>)mapperContents.dmcSelectAll();
//		for (DmContents dmContents : dmc) {
//			System.out.println(dmContents.toString());
//		}
//		System.out.println(mapperContents.dmNoSelectAll(1));
//		System.out.println(mapperContents.dmcSelectOne(1));
//		System.out.println(mapperContents.dmcInsert(new DmContents(1, 1234, "한강 가즈앙", null, "")));
//		System.out.println(mapperContents.dmcUpdate(new DmContents(1, 1, "한강 가즈앙", null, "")));
		System.out.println(mapperContents.dmcDelete(4));
	
	}
}
