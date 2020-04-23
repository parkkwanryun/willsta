package com.itwill.willsta.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.itwill.willsta.domain.Member;
import com.itwill.willsta.exception.MemberNotFoundException;
import com.itwill.willsta.exception.PasswordMismatchException;
import com.itwill.willsta.service.MemberService;
import com.itwill.willsta.service.PostService;

@Controller
public class MemberController {
	@Autowired
	MemberService memberService;
	@Autowired
	PostService postService;
	
	@RequestMapping(value="/")
	public String index() {
		return "";
	}
	
	@RequestMapping(value="/sign_in")
	public String sign_in() {
		return "sign_in";
	}
	Logger logger;
	
	/* 로그인 */
	@ResponseBody
	@RequestMapping(value = "/sign_in_action", method = RequestMethod.POST, produces = "text/plain; charset=UTF-8")
	public String sign_in_action_post(@RequestParam("mId") String mId, @RequestParam("mPass") String mPass,
			HttpSession session, Model model, HttpServletRequest request) {
		System.out.println("################로그인 컨트롤러 테스트" + "mId:" + mId + " mPass:" + mPass);
		String forwardPath = "";
		// String a= request.getSession().getServletContext().getRealPath("/");
		Member member = memberService.selectById(mId);
		// logger.info("프로젝트 경로 찾기" + a);
		
		try {
			Member signInMember = memberService.signIn(mId, mPass);
			System.out.println();
			if (member.getmRetire().trim().equals("on")) {
				System.out.println("############계정 활성화 여부:" + member.getmRetire());
				session.setAttribute("mId", mId);
				session.setAttribute("mName", member.getmName());
				session.setAttribute("mImage", member.getmImage());
				session.setAttribute("sMemberId", signInMember);
				forwardPath = "true";
			} else {
				System.out.println("### 계정 활성화 상태:" + member.getmRetire());
				forwardPath = "false3";
			}
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
		/*
		 * if(member.getmRetire()=="off"){
		 * System.out.println("## 비활성화된 계정으로 로그인 할 수 없음"); //forwardPath = 계정 활성화 창으로
		 * 포워딩 }
		 */
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
	@RequestMapping(value="/sign_up_action",method = RequestMethod.POST, produces="text/plain; charset=UTF-8")
	public String sign_up_action(Member member){
		//수정 중
		boolean newMember = memberService.insertMember(member);
			if(newMember) {
				newMember= true;
			}else{
				newMember= false;
				}
		return newMember+"";
	}	
	
	/*아이디 중복 체크*/
	@ResponseBody
	@RequestMapping(value="/duplicate_check", method= RequestMethod.GET, produces="text/plain; charset=UTF-8")
	public String existedMember(@RequestParam(name = "mId") String mId) {
		boolean newId = memberService.existedMember(mId);
		if(newId) {
			System.out.println("중복된 아이디 입니다.");
			newId = false;
		}else {
			newId = true;
		}
		return newId+"";
	}
	/*비밀번호 일치 여부 체크*/
	@MemberLoginCheck
	@ResponseBody
	@RequestMapping(value="/pw_Check",method= RequestMethod.GET, produces="text/plain; charset=UTF-8")
	public String retirePwCheck(@RequestParam(name="mPass")String mPass) {
		boolean truePw = memberService.existedPassword(mPass);
		if(truePw) {
			System.out.println("## 비밀번호 일치 여부:"+truePw);
			truePw = true;
		}else {
			System.out.println("## 비밀번호 일치 여부:"+truePw);
		}
		return truePw+"";
	}
	
	/*계정 활성화 창 이동*/
	@RequestMapping(value="/account_on", method= {RequestMethod.GET,RequestMethod.POST}, produces="text/plain; charset=UTF-8")
	public String accountOn() {
		return "account_on";
	}
	/*계정 활성화 컨트롤러 */
	@ResponseBody
	@RequestMapping(value="/member_account_on_action",method= RequestMethod.POST, produces="text/plain; charset=UTF-8")
	public String member_account_on_action(@RequestParam("mEmail")String mEmail, @RequestParam("mRetire")String mRetire) {
		boolean onMember = memberService.accountOn(mRetire, mEmail);
		if(onMember) {
			System.out.println("## 계정이 활성화 되었습니다.");
		}else {
			System.out.println("## 계정이 활성화 되지 못했습니다.");
		}
		return onMember+"";
	}

	
	/*회원 관리 탭 이동*/
	@MemberLoginCheck
	@RequestMapping(value="/profile-account-setting", method= {RequestMethod.GET,RequestMethod.POST}, produces="text/plain; charset=UTF-8")
	public String accountSettingAccess() {
		return "profile-account-setting";
	}
	/*회원 정보 수정(이미지 제외)*/
	@MemberLoginCheck
	@ResponseBody
	@RequestMapping(value="/account-setting", method=RequestMethod.POST, produces="text/plain; charset=UTF-8")
	public String accountSetting(@RequestParam(name="mId")String mId,
								@RequestParam("mPass")String mPass,
								@RequestParam("mName")String mName,
								@RequestParam("mEmail")String mEmail,
								@RequestParam("mPhone")String mPhone,
								HttpServletRequest request) {
		String path = request.getSession().getServletContext().getRealPath("/")+"contents\\member_image\\";
		System.out.println("## 이미지 저장경로:"+path);
		
		boolean updateMember = memberService.updateMember(new Member(mId, mPass, mName, mEmail, mPhone,",","off"));
		System.out.println(updateMember);
		if(updateMember) {
			System.out.println("회원 정보 수정 성공");
			updateMember= true;
		}else {
			System.out.println("회원 정보 수정 실패");
			updateMember= false;
		}
	return updateMember+"";
	}
	
	/*회원정보 수정(이미지)*/
	@MemberLoginCheck
	@ResponseBody
	@RequestMapping(value="/account_img_setting", method=RequestMethod.POST, produces="text/plain; charset=UTF-8")
	public String accountSetting(@RequestParam("mId")String mId,
								@RequestParam("uploadImg")MultipartFile uploadImg,
								HttpServletRequest request,
								HttpSession session) {
		String path = request.getSession().getServletContext().getRealPath("/")+"contents\\member_image\\";
		System.out.println("############ 이미지 저장경로:"+path);
		boolean updateMemberImg = memberService.updateMemberImg(mId, uploadImg);
		System.out.println(updateMemberImg);
		if(updateMemberImg) {
			System.out.println("회원 이미지 수정 성공");
			updateMemberImg= true;
			Member member=memberService.selectById(mId);
			session.setAttribute("mImage", member.getmImage());
		}else {
			System.out.println("회원 이미지 수정 실패");
			updateMemberImg= false;
		}
	return updateMemberImg+"";
	}

	/*비밀번호 찾기 - 페이지 이동*/ 
	@RequestMapping(value="findPw", method= {RequestMethod.GET,RequestMethod.POST}, produces="text/plain; charset=UTF-8")
	public String findPw() {
		return "findPw";
		
	}
	/*비밀번호 찾기 - mName , mEmail*/ 
	@ResponseBody
	@RequestMapping(value="findPw_action", method= RequestMethod.POST, produces="text/plain; charset=UTF-8")
	public String findPw(@RequestParam("mId")String mId,
						@RequestParam("mEmail")String mEmail) {
		Member findPw = memberService.findPw(mId, mEmail);
		
		if(findPw!= null) {
			System.out.println("## 회원의 비밀번호는:"+findPw.getmPass()+"입니다.");
			String pw = findPw.getmPass();
			return pw;
		}
		return "";
	}
	
	/*회원탈퇴*/
	@ResponseBody
	@RequestMapping(value="member_retire", method= RequestMethod.POST, produces="text/plain; charset=UTF-8")
	public String member_retire(@RequestParam("mPass")String mPass,
								@RequestParam("mEmail")String mEmail,
								@RequestParam("mRetire")String mRetire) {
		mRetire = "off";
		boolean retireOnMember = memberService.deleteMember(mPass,mEmail,mRetire);
		if(retireOnMember) {
			System.out.println("## 계정 비활성화 성공:"+retireOnMember);
		}else {
			System.out.println("## 계정 비활성화 실패:"+retireOnMember);
		}
		return retireOnMember+"";
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
	/*유저목록,검색목록*/
	@MemberLoginCheck
	@RequestMapping(value = "/profiles")
	public ModelAndView memberList(@Param(value = "search") String search) {
		ModelAndView mv=new ModelAndView();
		System.out.println("##검색 ->"+search);
		if (search==null) {
			//유저목록
			List<Member> memberList=memberService.memberList();
			mv.addObject("memberList",memberList);
		}else {
			//검색목록
			List<Member> findMemberList=memberService.findMemberList(search);
			mv.addObject("memberList",findMemberList);
		}
		mv.setViewName("profiles");
		return mv;
	}
	
	/*유저목록 스크롤*/
	@MemberLoginCheck
	@ResponseBody
	@RequestMapping(value = "/add_profile", produces = "text/html;charset=utf-8")
	public ModelAndView addMember(@RequestParam(value = "lastId", required = true)String lastId) {
		ModelAndView mv=new ModelAndView();
		System.out.println("###1 마지막 아이디 ->"+lastId);
		List<Member> addMemberList=memberService.addMemberList(lastId);
		mv.addObject("memberList",addMemberList);
		mv.setViewName("profiles_scroll");
		return mv;
	}
	
	
	/*상대방페이지*/
	@MemberLoginCheck
	@RequestMapping(value = "/user-profile")
	public ModelAndView userProfile(@Param("youId")String youId, HttpSession session) {
		String mId=(String)session.getAttribute("mId");
		ModelAndView mv=new ModelAndView();
		mv=postService.you_main_page(mId, youId);
		mv.setViewName("user-profile");
		return mv;
	}
	
	
}
