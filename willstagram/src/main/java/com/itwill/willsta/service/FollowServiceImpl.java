package com.itwill.willsta.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.web.servlet.ModelAndView;

import com.itwill.willsta.domain.Follow;
import com.itwill.willsta.domain.Member;
import com.itwill.willsta.domain.Post;
import com.itwill.willsta.repository.FollowDao;
import com.itwill.willsta.repository.PostDao;


@Service(value = "followService")
public class FollowServiceImpl implements FollowService {
	@Autowired
	FollowDao followDao;
	@Autowired
	PostDao postDao;
	
	@Autowired
	MemberService memberService;
	
	
	@Override
	public int follow(Follow follow) {
		
		return followDao.follow(follow);
	}
	
	@Override
	public int unfollow(String mIdYou, String mId) {
		
		return followDao.unfollow(mIdYou,mId);
	}

	@Override
	public List<Follow> followerList(String mId) {
		
		return followDao.followerList(mId);
	}
	

	@Override
	public List<Follow> followingList(String mIdYou) {
		
		return followDao.followingList(mIdYou);
	}


	@Override
	public int followingCount(String mIdYou) {
		
		return followDao.followingCount(mIdYou);
	}

	@Override
	public int followersCount(String mId) {
		
		return followDao.followersCount(mId);
	}

	@Override
	public int followCheck(String mId, String mIdYou) {
		return followDao.followCheck(mId, mIdYou);
	}

	/*
	 * @Override public List<Map> followingList(String mId) {
	 * 
	 * return followDao.followingList(mId); }
	 * 
	 * @Override public List<Map> followerList(String mIdYou) {
	 * 
	 * return followDao.followerList(mIdYou); }
	 * 
	 */

}
