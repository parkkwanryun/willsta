package com.itwill.willsta.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.itwill.willsta.domain.Follow;
import com.itwill.willsta.domain.Likes;
import com.itwill.willsta.domain.Post;
import com.itwill.willsta.domain.PostImage;
import com.itwill.willsta.service.FollowService;
import com.itwill.willsta.service.PostService;




@RestController
public class FollowController {
	@Autowired
	FollowService followService;
	@Autowired
	PostService postService;

	@MemberLoginCheck
	@RequestMapping(value="/my_page")
	public ModelAndView myPage(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		String mId = (String)request.getSession().getAttribute("mId");
		List<Post> postList = postService.selectMyList(mId);
		for (Post post : postList) {
			post.setTagArray(post.getHasTag().split(" "));
		}
		mv.addObject("postList", postList);
		mv.setViewName("myPage");
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
	
	
	
	@RequestMapping(value="/followList" , produces = "text/html;charset=utf-8")
	public ModelAndView followers(@RequestParam(value="mId",required = true )String mId) { 
		ModelAndView mv = new ModelAndView();
		List<Follow> followers = followService.followers(mId);
		for(Follow follow : followers) {
			follow.setmIdYou(mId);
		}
		mv.addObject("followers",followers);
		mv.setViewName("followList");
		
		return mv;
	}
	
	@RequestMapping(value="/followingList" , produces = "text/html;charset=utf-8")
	public ModelAndView following(@RequestParam(value="mId",required = true)String mId) {
		ModelAndView mv = new ModelAndView();
		List<Follow> following = followService.following(mId);
		for(Follow follow : following) {
			follow.setmIdYou(mId);
		}
		mv.addObject("following",following);
		mv.setViewName("followingList");
		
		return mv;
				
	}
	@RequestMapping(value="/followingCount" , produces = "text/html;charset=utf-8")
	public ModelAndView followingCount(@RequestParam(value="mIdYou",required = true )String mIdYou) {
		ModelAndView mv = new ModelAndView();
		int followingCount = followService.followingCount(mIdYou);
		
		mv.addObject("followingCount", followingCount);
		mv.setViewName("followingCount");
		
		return mv;
	}
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

	@RequestMapping(value = "/follow_Check")
	   public ModelAndView followCheck(@RequestParam(value = "mIdYou") String mIdYou,HttpSession session) {
	      ModelAndView mv=new ModelAndView();
	      String mId=(String) session.getAttribute("mId");
	      System.out.println(mIdYou);
	      //mIdYou="ss501";
	      int followCheck=followService.followCheck(mId, mIdYou);
	      if (followCheck == 1 ) {
			System.out.println("### follow상태");
	      }else {
			System.out.println("### follow 아닌 상태");
	      }
	      mv.addObject("followCheck",followCheck);
	      mv.setViewName("profiles");
	      return mv;
	   }
	
	@RequestMapping(value = "/follow")
		public ModelAndView follow(@RequestParam(value = "mIdYou") String mIdYou,HttpSession session) {
		ModelAndView mv=new ModelAndView();
		String mId=(String)session.getAttribute("mId");
		int follow=followService.follow(new Follow(mId, mIdYou));
		mv.addObject("follow", follow);
		mv.setViewName("profiles");
		return mv;
	}
	
	@RequestMapping(value = "/unFollow")
		public ModelAndView unFollow(@RequestParam(value = "mIdYou") String mIdYou,HttpSession session) {
		ModelAndView mv=new ModelAndView();
		String mId=(String)session.getAttribute("mId");
		int unFollow=followService.unfollow(mIdYou, mId);
		mv.addObject("unFollow", unFollow);
		mv.setViewName("profiles");
		return mv;
	}
	

}








