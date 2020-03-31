package com.itwill.willsta.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwill.willsta.domain.Follow;
import com.itwill.willsta.repository.FollowDao;

@Service(value = "followService")
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
	public List<Follow> following(String mIdYou) {
		
		return followDao.following(mIdYou);
	}

	@Override
	public boolean unfollow(String mIdYou, String mId) {
		
		return followDao.unfollow(mIdYou,mId);
	}

	@Override
	public int followingCount(String mIdYou) {
		
		return followDao.followingCount(mIdYou);
	}

	@Override
	public int followersCount(String mId) {
		// TODO Auto-generated method stub
		return followDao.followersCount(mId);
	}

	

}
