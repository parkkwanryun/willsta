package com.itwill.willsta.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.itwill.willsta.domain.Follow;

@Mapper
public interface FollowMapper {

	/* Follow Someone  팔로우하기*/
	@Insert("INSERT INTO FOLLOW VALUES(#{mId},#{mIdYou})")
	public boolean follow(Follow follow);
	
	/*Following List 내가 팔로우하고있는사람들 보기*/
	@Select("SELECT f.mIdYou From follow f inner join member m on  f.mId= m.mId where mid =#{mId}")
	public Follow following(String mId);
	
	/*Follower List 나를 팔로하고있는 사람들 */
	@Select("SELECT f.mIdYou From follow f inner join member m on  f.mId= m.mId where mid =#{mId}")
	public Follow follower(String mId);
	
	/*UnFollow 언팔하기*/
	@Delete("delete mIdYou from follow f inner join member m on  f.mId= m.mId where mid = #{mId}")
	public boolean unFollow(String mId);
	
}
