package com.itwill.willsta.mapper;

import java.util.List;
import java.util.Map;

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
	public int follow(Follow follow);
	
	/*UnFollow 언팔하기*/
	@Delete("delete from follow where mId =#{mId} and mIdYou =#{mIdYou}")
	public int unFollow(@Param("mId") String mId,@Param("mIdYou") String mIdYou );
	
	
	/*Following List 내가 팔로우하고있는사람들 보기*/
	@Select("select f.mid, f.midyou, m.mname, m.memail, m.mphone, m.mimage from follow f inner join member m on f.midyou = m.mid where f.mid =#{mId}")
	public List<Follow> followingList(String mId);
	
	
	/*Follower List 나를 팔로하고있는 사람들 */
	@Select("select f.midyou, f.mid, m.mname, m.memail, m.mphone, m.mimage from follow f inner join member m on f.mid = m.mid where f.midyou =#{mId}")
	public List<Follow> followerList(String mId);
	
	/*Following Count 내가 팔로하고있는 사람들 수  */
	@Select("select count(*) as followingcount from follow  where mId =#{mId}")
	public int followingCount(String mId);
	
	/*Followers count 나를 팔로하고있는 사람들 수   */
	@Select("select count(*) as followersCount from follow where mIdYou =#{mId}")
	public int followersCount(String mId);

	//Follow Check
	@Select("select count(*) as followCheck from follow where mId=#{mId} and mIdyou=#{mIdYou}")
	public int followCheck(@Param("mId") String mId,@Param("mIdYou") String mIdYou);
	
}


