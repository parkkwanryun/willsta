package com.itwill.willsta.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.itwill.willsta.domain.Follow;
import com.itwill.willsta.service.FollowService;




@RestController
public class FollowController {
	@Autowired
	FollowService followService;
	
	@RequestMapping(value="/followList")
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
	
	@RequestMapping(value="/followingList")
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
	
	
	
	
	
	
	
	
	
}








