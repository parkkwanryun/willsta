package com.itwill.willsta.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itwill.willsta.domain.Member;
import com.itwill.willsta.service.MemberService;

@Controller
public class MemberController {
	@Autowired
	MemberService memberService;
	
	@RequestMapping(value = "/profiles")
	public ModelAndView memberList() {
		ModelAndView mv=new ModelAndView();
		List<Member> memberList=memberService.memberList();
		mv.addObject("memberList",memberList);
		mv.setViewName("profiles");
		return mv;
	}
	
	
}
