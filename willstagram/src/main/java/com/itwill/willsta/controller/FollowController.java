package com.itwill.willsta.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.itwill.willsta.domain.Follow;
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
	public ModelAndView followers(@RequestParam(value="mId",required = false)String mId) {
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
	public ModelAndView following(@RequestParam(value="mId",required = false)String mId) {
		ModelAndView mv = new ModelAndView();
		List<Follow> following = followService.following(mId);
		for(Follow follow : following) {
			follow.setmIdYou(mId);
		}
		mv.addObject("following",following);
		mv.setViewName("followingList");
		
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
	
	
	
	
	
	
	
}








