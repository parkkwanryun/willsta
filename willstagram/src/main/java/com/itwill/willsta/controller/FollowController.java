package com.itwill.willsta.controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.itwill.willsta.domain.Follow;
import com.itwill.willsta.domain.Likes;
import com.itwill.willsta.domain.Member;
import com.itwill.willsta.domain.Post;
import com.itwill.willsta.domain.PostImage;
import com.itwill.willsta.service.FollowService;
import com.itwill.willsta.service.MemberService;
import com.itwill.willsta.service.PostService;




@Controller
public class FollowController {
	@Autowired
	FollowService followService;
	@Autowired
	PostService postService; 
	@Autowired
	MemberService memberService;
	
	
	@MemberLoginCheck
	@RequestMapping(value="/personal_info")
	public ModelAndView personal_info(HttpServletRequest request) {
		
		String mId = (String)request.getSession().getAttribute("mId");
		ModelAndView mv = postService.personal_main_page(mId);
		
		mv.setViewName("personal");
		return mv;
	}
	
	@RequestMapping(value="/click_post" , produces = "text/html;charset=utf-8")
	public ModelAndView selectPost(@RequestParam(value="pNo", required = true) Integer pNo, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		String mId = (String)request.getSession().getAttribute("mId");
		Post post = postService.selectPost(pNo, mId);
		post.setTagArray(post.getHasTag().split(" "));
		List<PostImage> postImages = postService.selectContents(pNo);
		
		mv.addObject("post", post);
		mv.addObject("postImages", postImages);
		mv.setViewName("clickPost");
		return mv;
	}

	@ResponseBody // 애는팔로워 팔로잉 바뀌면서 발류랑 펑션이랑다르지만 값잘나오니까 냅둬.
	@RequestMapping(value = "/followerList", method = RequestMethod.POST)
	public List<Member> followerList(@RequestParam(value = "mId", required = true) String mId) {
		ModelAndView mv = new ModelAndView();
		List<Follow> following = followService.followerList(mId);
		List<Member> youMemberList=new ArrayList<Member>();
		for (Follow follow : following) {
			Member youMmeber = memberService.selectById(follow.getmIdYou());
			youMemberList.add(youMmeber);
		}
		
		return youMemberList;

	}
	
	
	@ResponseBody // 애는팔로워 팔로잉 바뀌면서 발류랑 펑션이랑다르지만 값잘나오니까 냅둬.
	@RequestMapping(value = "/followingList", method = RequestMethod.POST)
	public List<Member> followingList(@RequestParam(value = "mId", required = true) String mId) {
		ModelAndView mv = new ModelAndView();
		List<Follow> following = followService.followingList(mId);
		List<Member> youMemberList=new ArrayList<Member>();
		for (Follow follow : following) {
			Member youMmeber = memberService.selectById(follow.getmIdYou());
			youMemberList.add(youMmeber);
		}
		return youMemberList;

	}
	
	@ResponseBody
	@RequestMapping(value="/followingCount" , produces = "text/html;charset=utf-8")
	public ModelAndView followingCount(@RequestParam(value="mIdYou",required = true )String mIdYou) {
		ModelAndView mv = new ModelAndView();
		int followingCount = followService.followingCount(mIdYou);
		
		mv.addObject("followingCount", followingCount);
		mv.setViewName("followingCount");
		
		return mv;
	}
	
	@ResponseBody
	@RequestMapping(value="/followersCount" , produces = "text/html;charset=utf-8")
	public ModelAndView followerCount(@RequestParam(value="mId",required = true )String mId) {
		ModelAndView mv = new ModelAndView();
		int followersCount = followService.followersCount(mId);
		
		mv.addObject("followerCount", followersCount);
		mv.setViewName("followersCount");
		
		return mv;
	}
	
	
	
	@RequestMapping(value="/delete_mypost", method = RequestMethod.POST, produces = "text/plain;charset=utf-8")
	public String deleteMyPost(@RequestParam(value="pNo", required = true) int pNo) {
		//1.데이터 저장처리
		try {
			int rn = postService.removePost(pNo);
			if(rn >0) {
				return "success";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}

		return "fail";
		
	}
	
	@RequestMapping(value="/click_like", method = RequestMethod.POST, produces = "text/plain;charset=utf-8")
	public String click_like(@RequestParam(value="pNo", required = true) int pNo) {
		String mId = "김소진";
		Likes lk = new Likes(pNo, mId);
		return postService.insert_like(lk);
		
	}

	@MemberLoginCheck
	@RequestMapping(value="/my_page_post")
	public ModelAndView selectMainList(HttpServletRequest request) {
		
		String mId = (String)request.getSession().getAttribute("mId");
		ModelAndView mv = postService.main_page(mId);
		
		mv.setViewName("myPage");
		return mv;
	}
	@ResponseBody
	@RequestMapping(value = "/follow_Check", method = RequestMethod.POST)
	   public String followCheck(@RequestParam(value = "mIdYou") String mIdYou,HttpSession session, Model model) {
	      String mId=(String) session.getAttribute("mId");
	      System.out.println(mIdYou);
	      //mIdYou="ss501";
	      String check="";
	      int followCheck=followService.followCheck(mId, mIdYou);
	      if (followCheck > 0 ) {
			System.out.println("### follow상태");
			check="true";
	      }else {
			System.out.println("### follow 아닌 상태");
			check="false";
	      }
	      return check;
	   }

	@ResponseBody
	@RequestMapping(value = "/follow")
	public String follow(@RequestParam String mIdYou, HttpSession session) {	
		String mId = (String) session.getAttribute("mId");
		int follow = followService.follow(new Follow(mId, mIdYou));
		System.out.println("2." + follow);
		return follow + "";
	}
	

	  @ResponseBody
	  @RequestMapping(value = "/unFollow") 
	  public String unFollow(@RequestParam String mIdYou,HttpSession session) {
	  System.out.println("### unfollow 컨트롤러 테스트");
	  String mId=(String)session.getAttribute("mId"); 
	  int unfollow=followService.unfollow(mId, mIdYou);
	  System.out.println("unfollow."+unfollow);
	 return unfollow+"";
	 
	  }

}








