package com.itwill.willsta.repository;



import org.springframework.beans.factory.annotation.Autowired;

import com.itwill.willsta.domain.Follow;
import com.itwill.willsta.mapper.FollowMapper;


public class FollowDaoImpl implements FollowDao{
	@Autowired
	FollowMapper followMapper;
	
	
	@Override
	public boolean follow(Follow follow) {
		return followMapper.follow(follow);
	}

	@Override
	public Follow follower(String mId) {
		
		return followMapper.follower(mId);
	}

	@Override
	public Follow following(String mId) {
		
		return followMapper.following(mId);
	}

	@Override
	public boolean unfollow(String mId) {
		
		return false;
	}

}
