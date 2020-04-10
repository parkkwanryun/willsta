package com.itwill.willsta.repository;

import java.util.List;
import java.util.Map;

import com.itwill.willsta.domain.Follow;

public interface FollowDao {

	/* Follow someone 누군가를 팔로우 하기*/
	 int follow(Follow follow);

	 /*Unfollow someone 누군가를 언팔하기*/
	 int unfollow(String mIdYou, String mId);
	
	 /* Followers 내 팔로워들 보기 */
	  List<Follow> followerList(String mId);
	 
	 /* Following 내가 팔로하는사람들 보기  */

	 List<Follow> followingList(String mId);
	 
	 
	 /*FollowingCount  */
	 int followingCount(String mIdYou);

	 /* FollowersCount */
	 int followersCount(String mId);
	 
	 int followCheck(String mId, String mIdYou);
	 
	/*
	 * // FollowingList List<Map> followingList(String mId);
	 * 
	 * //Follower List List<Map> followerList(String mIdYou);
	 */
	 
}
