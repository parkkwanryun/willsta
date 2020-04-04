package com.itwill.willsta.service;

import java.util.List;

import org.springframework.web.servlet.ModelAndView;

import com.itwill.willsta.domain.Follow;

public interface FollowService {

	boolean follow(Follow follow);

	boolean unfollow(String mIdYou, String mId);

	List<Follow> followers(String mId);

	List<Follow> following(String mId);

	int followingCount(String mIdYou);

	int followersCount(String mId);
	
	int followCheck(String mId,String mIdYou);

}
