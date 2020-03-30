package com.itwill.willsta.service;

import java.util.List;

import com.itwill.willsta.domain.Follow;

public interface FollowService {

	
	boolean follow(Follow follow);
	
	List<Follow> followers(String mId);
	
	List<Follow> following(String mId);
	
	boolean unfollow(String mId);
	
}
