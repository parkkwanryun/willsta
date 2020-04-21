package com.itwill.willsta.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.itwill.willsta.domain.Member;

@Mapper
public interface MemberMapper {

	/* 회원 가입 */
	@Insert("INSERT INTO MEMBER VALUES (#{mId},#{mPass},#{mName},#{mEmail},#{mPhone},#{mImage},#{mRetire})")
	public boolean insertMember(Member member);

	// 이미지 넣을 INSERT 쿼리 1개 - 파일 이름으로 넣기 (회원수정 시 수행 될 쿼리문)
	// WHEN NOT MATCHED THEN INSERT (mImage) VALUES(null)
	@Insert("MERGE INTO MEMBER USING DUAL ON (mId = #{mId}) WHEN MATCHED THEN UPDATE SET mImage = #{mImage}")
	public boolean insertImg(@Param("mId")String mId,@Param("mImage")String mImage);

	/* 회원정보 로딩 */
	@Select("SELECT m.mId, m.mPass, m.mName, m.mEmail, m.mPhone, m.mImage, "
			+ " (select count(*) from follow x where x.midyou = m.mId) as followerCount,"
			+ " (select count(*) from follow x where x.mid = m.mId) as followingCount " + " FROM MEMBER M "
			+ " WHERE m.mId=#{mId}")
	public Member selectByIdContainFollowInfo(@Param("mId") String mId);

	/* 친구추천 - 랜덤로딩 5건 */
	@Select("SELECT * FROM (" + " SELECT m.mId, m.mPass, m.mName, m.mEmail, m.mPhone, m.mImage, "
			+ " (select count(*) from follow x where x.midyou = m.mId) as followerCount,"
			+ " (select count(*) from follow x where x.mid = m.mId) as followingCount " + " FROM MEMBER M "
			+ " WHERE MID NOT IN (SELECT MIDYOU FROM FOLLOW WHERE MID = #{mId}) " + " ORDER BY DBMS_RANDOM.RANDOM)"
			+ " WHERE ROWNUM < 6")
	public List<Member> selectByRandom(@Param("mId") String mId);

	/* 팔로우 정보 없는 회원정보 로딩 */
	@Select("SELECT mId, mPass, mName, mEmail, mPhone, mImage, mRetire FROM MEMBER WHERE mId=#{mId}")
	public Member selectById(@Param("mId") String mId);
	
	/* 회원정보 수정 */
	@Update("UPDATE MEMBER SET mId=#{mId}, mPass=#{mPass}, mName=#{mName}, mEmail=#{mEmail}, mPhone=#{mPhone}, mImage=#{mImage}, mRetire=#{mRetire} WHERE mId=#{mId}")
	public boolean updateMember(Member memeber);

	/* 계정 비활성화*/
	@Update("UPDATE MEMBER SET mRetire = #{mRetire} WHERE mPass = #{mPass} and mEmail = #{mEmail}")
	public boolean deleteMember(@Param("mPass") String mPass, @Param("mEmail") String mEmail, @Param("mRetire")String mRetire);
	
	/* 계정 활성화 */
	@Update("UPDATE MEMBER SET mRetire = #{mRetire} WHERE mEmail=#{mEmail}")
	public boolean accountOn(@Param("mRetire")String mRetire, @Param("mEmail")String mEmail); 

	
	/* 아이디 중복체크 */
	@Select("SELECT count(*) cnt FROM MEMBER WHERE mId=#{mId}")
	public boolean existedMember(@Param("mId") String mId);
	
	/* 비밀번호 일치 여부 */
	@Select("SELECT count(*) cnt FROM MEMBER WHERE mPass=#{mPass}")
	public boolean existedPassword(@Param("mPass")String mPass);
	
	/* 아이디 찾기 */
	@Select("SELECT mId FROM MEMBER WHERE mEmail=#{mEmail} and mName=#{mName}")
	public Member findId(@Param("mEmail") String mEmail, @Param("mName") String mName);

	/* 비밀번호 찾기 */
	@Select("SELECT mPass FROM MEMBER WHERE mId=#{mId} and mEmail=#{mEmail}")
	// SELECT mPass FROM MEMBER WHERE mId = 'pkr' AND mName = '세미'
	public Member findPw(@Param("mId") String mId, @Param("mEmail") String mEmail);

	/* 임시비밀번호 발급 */
	@Update("UPDATE MEMBER SET mPass=#{mPass} WHERE mId=#{mId}")
	public Member getTempPw(@Param("mId") String mPass, @Param("mEmail") String mId);

	@Select("SELECT mid, mname, mimage FROM member WHERE rownum < 13 ORDER BY mid")
	public List<Member> memberList();

	@Select("SELECT A.* FROM(SELECT rownum, mid, mname, mimage FROM member WHERE mid > #{lastId} ORDER BY mid)A WHERE rownum < 13")
	public List<Member> addMemberList(@Param("lastId") String lastId);

	@Select("SELECT mid, mname, mimage FROM member where mid like '%${findId}%' ")
	public List<Member> findMemberList(@Param("findId") String findId);
}
