package com.itwill.willsta.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.itwill.willsta.domain.DM;
import com.itwill.willsta.domain.Member;
import com.itwill.willsta.service.DmService;
import com.itwill.willsta.service.MemberService;

@Controller
public class DmController {
	@Autowired
	private DmService dmService;
	
	@RequestMapping(value = "/messages")
	public String messageForm(HttpServletRequest httpServletRequest) {
		List<DM> dmList = dmService.dmSelectAll(); 
		httpServletRequest.getSession().setAttribute("dmList", dmList);
		
		System.out.println("컨트롤러 호출 성공");
		String mId = (String)httpServletRequest.getSession().getAttribute("mId");
		httpServletRequest.getSession().setAttribute("mId", mId);
		
		return "messages";
	}
}
