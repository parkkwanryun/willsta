package com.itwill.willsta.repository;

import java.util.List;

import com.itwill.willsta.domain.Follow;

public interface FollowDao {

	/* Follow someone 누군가를 팔로우 하기*/
	 boolean follow(Follow follow);

	 /*Unfollow someone 누군가를 언팔하기*/
	 boolean unfollow(String mIdYou, String mId);
	
	 /* Followers 내 팔로워들 보기 */
	  List<Follow> followers(String mId);
	 
	 /* Following 내가 팔로하는사람들 보기  */

	 List<Follow> following(String mIdYou);
	 
	 
	 /*FollowingCount  */
	 int followingCount(String mIdYou);

	 /* FollowersCount */
	 int followersCount(String mId);
	 
	 
	 
	 
}
