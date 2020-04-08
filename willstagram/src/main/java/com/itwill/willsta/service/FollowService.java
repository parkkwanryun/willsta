package com.itwill.willsta.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.servlet.ModelAndView;

import com.itwill.willsta.domain.Follow;

public interface FollowService {

	int follow(Follow follow);

	int unfollow(String mIdYou, String mId);

	List<Follow> followers(String mId);

	List<Follow> following(String mId);

	int followingCount(String mIdYou);

	int followersCount(String mId);
	
	int followCheck(String mId,String mIdYou);

	List<Map> followingList(String mId);
	
	List<Map> followerList(String mIdYou);	
}
