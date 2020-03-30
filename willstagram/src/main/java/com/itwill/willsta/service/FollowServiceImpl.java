package com.itwill.willsta.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.itwill.willsta.domain.Follow;
import com.itwill.willsta.repository.FollowDao;

public class FollowServiceImpl implements FollowService {
	@Autowired
	FollowDao followDao;
	
	
	@Override
	public boolean follow(Follow follow) {
		
		return followDao.follow(follow);
	}

	@Override
	public List<Follow> followers(String mId) {
		
		return followDao.followers(mId);
	}

	@Override
	public List<Follow> following(String mId) {
		
		return followDao.following(mId);
	}

	@Override
	public boolean unfollow(String mId) {
		
		return followDao.unfollow(mId);
	}

}
