package com.itwill.willsta.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
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
	
	
	/*로그인*/
	@ResponseBody
	@RequestMapping(value="/sign_in_action", method = RequestMethod.POST, produces="text/plain; charset=UTF-8")
	public String sign_in_action_post(@RequestParam("mId")String mId, @RequestParam("mPass")String mPass, 
										HttpSession session, Model model) {
		System.out.println("로그인 컨트롤러 테스트"+"mId:"+mId+" mPass:"+mPass);
		String forwardPath = "";
		try {
			Member signInMember = memberService.signIn(mId, mPass);
			session.setAttribute("mId", mId);
			session.setAttribute("sMemberId", signInMember);
			forwardPath="true";
		} catch (MemberNotFoundException e) {
			forwardPath = "false1";
			e.printStackTrace();
		} catch (PasswordMismatchException e) {
			forwardPath = "false2";
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
			forwardPath = "false";
		}
		return forwardPath;
	}
	
	/*로그아웃*/
	@ResponseBody
	@RequestMapping(value="/sign_out_action")
	public String sign_out_action(HttpSession session) {
		System.out.println("sign_out_action 컨트롤러 테스트");
		session.invalidate();
		return "sign_in";
	}
	
	/*회원가입*/
	@ResponseBody
	@RequestMapping(value="/sign_up_action",method = RequestMethod.POST, produces="application/json; charset=UTF-8")
	public boolean sign_up_action(@RequestParam("mId")String mId,
								@RequestParam("mPass")String mPass,
								@RequestParam("mName")String mName,
								@RequestParam("mEmail")String mEmail,
								@RequestParam("mPhone")String mPhone,
								@RequestParam("mImage")String mImage,
								@RequestParam("mRetire")String mRetire,
								HttpServletRequest request, HttpSession session) {
		//String mId1 = (String) request.getSession().getAttribute("mId");
		boolean newMember = memberService.insertMember(new Member(mId,mPass,mName,mEmail,mPhone,mImage,mRetire));
			if(newMember) {
				System.out.println("이제 자네는 우리 회원일세");
				newMember= true;
			}else {
				newMember= false;
			}
		return newMember;
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
	
	@MemberLoginCheck
	@ResponseBody
	@RequestMapping(value = "/add_profile", produces = "text/html;charset=utf-8")
	public ModelAndView addMember(@RequestParam(value = "lastId", required = true)String lastId) {
		ModelAndView mv=new ModelAndView();
		System.out.println("### 마지막 아이디 ->"+lastId);
		List<Member> addMemberList=memberService.addMemberList(lastId);
		mv.addObject("memberList",addMemberList);
		mv.setViewName("profile");
		return mv;
		
	}
	
	@MemberLoginCheck
	@ResponseBody
	@RequestMapping(value = "/search_member", method = RequestMethod.POST)
	public ModelAndView findMemberList(@RequestParam(value = "findId") String findId) {
		ModelAndView mv=new ModelAndView();
		List<Member> findMemberList=memberService.findMemberList(findId);
		mv.addObject("memberList",findMemberList);
		mv.setViewName("profiles");
		return mv;
	}
	
}
