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
	public boolean unfollow(String mIdYou, String mId) {

		return followMapper.unFollow(mIdYou, mId);
	}
	
	@Override
	public List<Follow> followers(String mId) {
		
		return followMapper.followers(mId);
	}

	@Override
	public List<Follow> following(String mIdYou) {
		
		return followMapper.following(mIdYou);
	}


	@Override
	public int followingCount(String mIdYou) {
		
		return followMapper.followingCount(mIdYou);
	}

	@Override
	public int followersCount(String mId) {
		
		return followMapper.followersCount(mId);
	}



	

	

	




}
