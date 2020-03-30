package com.itwill.willsta.repository;

import java.util.List;

import com.itwill.willsta.domain.Follow;

public interface FollowDao {

	/* Follow someone 누군가를 팔로우 하기*/
	 boolean follow(Follow follow);

	 /* Follower 내 팔로워들 보기 */
	 public List<Follow> followers(String mId);
	 
	 /* Following 내가 팔로하는사람들 보기  */

	public List<Follow> following(String mId);
	 
	 /*Unfollow someone 누군가를 언팔하기*/
	 boolean unfollow(String mId);


	 
	 
	 
	 
}
