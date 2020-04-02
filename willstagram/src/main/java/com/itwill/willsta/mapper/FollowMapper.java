package com.itwill.willsta.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.itwill.willsta.domain.Follow;

@Mapper
public interface FollowMapper {

	/* Follow Someone  팔로우하기*/
	@Insert("INSERT INTO FOLLOW VALUES(#{mId},#{mIdYou})")
	public boolean follow(Follow follow);
	
	/*UnFollow 언팔하기*/
	@Delete("delete from follow where mIdYou =#{mIdYou} and mId =#{mId}")
	public boolean unFollow(@Param("mIdYou") String mIdYou, @Param("mId") String mId);
	
	
	/*Following List 내가 팔로우하고있는사람들 보기*/
	@Select(" select mId  from follow where mIdYou =#{mIdYou}")
	public List<Follow> following(String mIdYou);
	
	
	/*Follower List 나를 팔로하고있는 사람들 */
	@Select("select midYou from follow where mid =#{mId}")
	public List<Follow> followers(String mId);
	
	/*Followers count 나를 팔로하고있는 사람들 수   */
	@Select("select count(*) as followersCount from follow where mid =#{mId}")
	public int followersCount(String mId);
	
	
	/*Following Count 내가 팔로하고있는 사람들 수  */
	@Select("select count(*) as followingcount from follow  where mIdYou =#{mIdYou}")
	public int followingCount(String mIdYou);
	
	//Follow Check
	@Select("select count(*) as followCheck from follow where mId=#{mId} and mIdyou=#{mIdYou}")
	public int followCheck(@Param("mId") String mId,@Param("mIdYou") String mIdYou);
	
}
