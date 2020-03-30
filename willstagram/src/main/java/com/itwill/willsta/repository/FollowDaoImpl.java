package com.itwill.willsta.repository;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.willsta.domain.Follow;
import com.itwill.willsta.mapper.FollowMapper;

@Repository("followDao")
public class FollowDaoImpl implements FollowDao{
	@Autowired
	FollowMapper followMapper;

	@Override
	public boolean follow(Follow follow) {
		return followMapper.follow(follow);
	}

	@Override
	public List<Follow> followers(String mId) {
		
		return followMapper.followers(mId);
	}

	@Override
	public List<Follow> following(String mId) {
		
		return followMapper.following(mId);
	}

	@Override
	public boolean unfollow(String mId) {
		
		return followMapper.unFollow(mId);
	}



	

	

	




}
