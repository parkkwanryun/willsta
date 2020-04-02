package com.itwill.willsta.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.itwill.willsta.domain.Member;

@Controller
public class DmController {
	@RequestMapping(value = "/messages")
	public String messageForm(HttpServletRequest httpServletRequest) {
		System.out.println("컨트롤러 호출 성공");
		String mId = (String)httpServletRequest.getSession().getAttribute("mId");
		httpServletRequest.getSession().setAttribute("mId", mId);
		
		return "messages";
	}
}
