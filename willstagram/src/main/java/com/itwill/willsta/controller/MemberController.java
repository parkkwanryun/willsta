package com.itwill.willsta.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.itwill.willsta.domain.Member;
import com.itwill.willsta.service.MemberService;

@Controller
public class MemberController {
	@Autowired
	MemberService memberService;
	
	@RequestMapping(value="/index")
	public String index() {
		return "index";
	}
	
	@RequestMapping(value="/sign_in")
	public String sign_in() {
		return "sign_in";
	}
	
	@MemberLoginCheck
	@RequestMapping(value="/sign_in_action", method = RequestMethod.GET)
	public String sign_in_action_get(@ModelAttribute(name="fMember") Member member, HttpSession session) {
		String forwardPath = "";
		try {
			Member signInMember = memberService.signIn(member.getmId(), member.getmPass());
			session.setAttribute("mId", member.getmId());
			session.setAttribute("smId", signInMember);
			return "redirect: index";
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return "sign_in";
	}

	@MemberLoginCheck
	@RequestMapping(value="/sign_in_action", method = RequestMethod.POST)
	public String sign_in_action_post(HttpSession session, Model model) {
		return "sign_in";
	}

	@MemberLoginCheck
	@RequestMapping(value="/sign_out_action")
	public String logout_action(HttpSession session) {
		String forwardPath ="redirect:index";
		session.invalidate();
		return forwardPath;
	}
	
	@MemberLoginCheck
	@RequestMapping(value="/my-profile-feed")
	public ModelAndView selectById(@Param("mId")String mId) {
		ModelAndView mv = new ModelAndView();
		memberService.selectById("mId");
		mv.addObject("mId",mId);
		mv.setViewName("my-profile-feed");
		return mv;
	}
	
	@MemberLoginCheck
	@RequestMapping(value = "/profiles")
	public ModelAndView memberList() {
		ModelAndView mv=new ModelAndView();
		List<Member> memberList=memberService.memberList();
		mv.addObject("memberList",memberList);
		mv.setViewName("profiles");
		return mv;
	}
	
	
}
