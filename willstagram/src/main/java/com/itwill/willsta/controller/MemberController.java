package com.itwill.willsta.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.itwill.willsta.domain.Member;
import com.itwill.willsta.exception.MemberNotFoundException;
import com.itwill.willsta.exception.PasswordMismatchException;
import com.itwill.willsta.service.MemberService;

@Controller
public class MemberController {
	@Autowired
	MemberService memberService;
	
	@RequestMapping(value="/")
	public String index() {
		return "";
	}
	
	@RequestMapping(value="/sign_in")
	public String sign_in() {
		return "sign_in";
	}

	@ResponseBody
	@RequestMapping(value="/sign_in_action", method = RequestMethod.POST, produces="text/plain; charset=UTF-8")
	public String sign_in_action_post(@RequestParam("mId")String mId, @RequestParam("mPass")String mPass, 
										HttpSession session, Model model) {
		System.out.println("mId / mPass"+mId+mPass);
		String forwardPath = "";
		try {
			Member signInMember = memberService.signIn(mId, mPass);
			session.setAttribute("mId", mId);
			session.setAttribute("sMemberId", signInMember);
			forwardPath="true";
		} catch (MemberNotFoundException e) {
			model.addAttribute("fmId", mId);
			model.addAttribute("msg1", e.getMessage());
			forwardPath = "false";
			e.printStackTrace();
		} catch (PasswordMismatchException e) {
			model.addAttribute("fmId", mId);
			model.addAttribute("msg2", e.getMessage());
			forwardPath = "false";
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
			forwardPath = "false";
		}
		return forwardPath;
	}
	
	@MemberLoginCheck
	@RequestMapping(value="/sign_out_action")
	public String sign_out_action(HttpSession session) {
		session.invalidate();
		String forwardPath ="redirect:index";
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
	
	//@MemberLoginCheck
	@RequestMapping(value = "/profiles")
	public ModelAndView memberList() {
		ModelAndView mv=new ModelAndView();
		List<Member> memberList=memberService.memberList();
		mv.addObject("memberList",memberList);
		mv.setViewName("profiles");
		return mv;
	}
	
	//@MemberLoginCheck
	@ResponseBody
	@RequestMapping(value = "/search_member", method = RequestMethod.POST)
	public ModelAndView findMemberList(@RequestParam(value = "mId") String mId) {
		ModelAndView mv=new ModelAndView();
		List<Member> findMemberList=memberService.findMemberList(mId);
		mv.addObject("memberList",findMemberList);
		mv.setViewName("profiles");
		return mv;
	}
	
}
