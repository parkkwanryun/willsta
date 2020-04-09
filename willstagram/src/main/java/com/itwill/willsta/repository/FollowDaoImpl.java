package com.itwill.willsta.repository;



import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.willsta.domain.Follow;
import com.itwill.willsta.mapper.FollowMapper;

@Repository("followDao")
public class FollowDaoImpl implements FollowDao{
	@Autowired
	FollowMapper followMapper;

	@Override
	public int follow(Follow follow) {
		return followMapper.follow(follow);
	}

	@Override
	public int unfollow(String mIdYou, String mId) {

		return followMapper.unFollow(mIdYou, mId);
	}
	
	/*
	 * @Override public List<Follow> followers(String mId) {
	 * 
	 * return followMapper.followerList(mId); }
	 * 
	 * @Override public List<Follow> following(String mIdYou) {
	 * 
	 * return followMapper.followingList(mIdYou); }
	 */

	@Override
	public int followingCount(String mIdYou) {
		
		return followMapper.followingCount(mIdYou);
	}

	@Override
	public int followersCount(String mId) {
		
		return followMapper.followersCount(mId);
	}

	@Override
	public int followCheck(String mId, String mIdYou) {
		return followMapper.followCheck(mId, mIdYou);
	}

	@Override
	public List<Follow> followerList(String mId) {
		return followMapper.followerList(mId);
	}

	@Override
	public List<Follow> followingList(String mIdYou) {
		return followMapper.followingList(mIdYou);
	}

	/*
	 * @Override public List<Map> followingList(String mId) {
	 * 
	 * return followMapper.followingList(mId); }
	 * 
	 * @Override public List<Map> followerList(String mIdYou) {
	 * 
	 * return followMapper.followerList(mIdYou); }
	 */


	

	

	




}
