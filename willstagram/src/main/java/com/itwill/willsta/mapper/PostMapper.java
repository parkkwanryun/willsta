package com.itwill.willsta.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import com.itwill.willsta.domain.Likes;
import com.itwill.willsta.domain.Post;
import com.itwill.willsta.domain.PostImage;

@Mapper
public interface PostMapper {
	@Insert("INSERT INTO POST VALUES (#{pNo}, #{mId}, #{pTitle}, #{pContents}, #{hasTag}, 0, sysdate, 'A')")
	@SelectKey(statement ="select post_number_seq.NEXTVAL from dual", keyProperty = "pNo",  before = true, resultType = Integer.class)
	public int insert(Post post);

	//컨텐트이름들은 리스트맵으로 컨트롤
	@Insert("INSERT INTO POST_IMAGE VALUES(#{pNo}, #{fileName})")
	public int insertImg(PostImage pi);
	
	@Update({"<script> ", 
			"	UPDATE POST ", 
			"	<set> ", 
			"    	<if test='pTitle != null'>pTitle = #{pTitle}, </if>", 
			"    	<if test='pContents != null'>pContents = #{pContents},</if> ", 
			"    	<if test='hasTag != null'>hasTag = #{hasTag}, </if>", 
			"    	pdate = sysdate", 
			"	</set> ",  
			"	WHERE pNo = #{pNo} ",
			"</script>"})
	public int update(Post post);
	
	@Update("UPDATE POST "+
		"	set status = #{status} " +
		"	WHERE pNo = #{pNo} ")
	public int status_update(@Param("pNo") Integer pNo, @Param("status") String status);
	
	
	@Update("UPDATE POST SET PVIEWCOUNT = PVIEWCOUNT + 1 WHERE PNO = #{pNo}")
	public int up_viewcount(Integer pNo);
	
	@Delete("DELETE FROM POST WHERE pNo = #{pNo}")
	public int delete(Integer pNo);
	
	@Delete("DELETE FROM POST_IMAGE WHERE pNo = #{pNo}")
	public int delete_img(Integer pNo);

	//로그인 후 리스트 자신과 자신의 팔로잉 멤버의 글을 리스트를 작성일이 최신인 것 순으로 정렬
	//tag사이에는 lt를 쓸 수 있는데 그외 sql에서는 <![CDATA[  ]]>사이에 sql을 넣어야 한다.
	//queryGbn = 1인경우만 다른사람 글을 볼 수 있음 mypage에 자기 글만 보여주기 위해 사용
	@Select({"<script>",
		" SELECT A.* ",
		" FROM (SELECT P.PNO, P.PTITLE, P.PCONTENTS, P.HASTAG, P.PDATE, P.MID, M.MNAME, M.MIMAGE, PVIEWCOUNT, ",
		"         (SELECT COUNT(*) FROM LIKES X WHERE X.PNO = P.PNO) AS likeCount, ",
		"         (SELECT COUNT(*) FROM LIKES X WHERE X.PNO = P.PNO AND MIDYOU = #{mId}) AS myLike, ",
		"         (SELECT MIN(X.FILENAME) AS FILENAME FROM POST_IMAGE X WHERE X.PNO = P.PNO) AS FILENAME, ",
		"   CASE WHEN ROUND((SYSDATE - P.PDATE)) > 0 ",
		"        THEN ROUND((SYSDATE - P.PDATE)) || '일 전' ",
	    "        ELSE CASE WHEN ROUND((SYSDATE - P.PDATE)*24) > 0  ",
	    "                  THEN ROUND((SYSDATE - P.PDATE)*24) || '시간 전' ",
	    "                  ELSE ROUND((SYSDATE - P.PDATE)*24*60) || '분 전' ",
	    "             END ",
	    "   END AS AGO, P.STATUS ",
		" FROM POST P INNER JOIN MEMBER M ON P.MID = M.MID ",
		" WHERE (P.MID = #{mId} ",
		"      <if test='queryGbn eq 1'>  OR (P.MID IN (SELECT mIdYou FROM FOLLOW WHERE MID = #{mId}) "
		+ "				   AND P.STATUS='A')</if>) ",
		"  <if test='lastpNo gt 0'><![CDATA[AND P.PNO < #{lastpNo} ]]></if>",
		" ORDER BY P.PNO DESC) A ",
		"  <![CDATA[WHERE ROWNUM < 6]]>",
			"</script>"})
	public List<Post> selectMyList(@Param("lastpNo")Integer lastpNo, @Param("mId")String mId, @Param("queryGbn")Integer queryGbn);
	  
	//POST 한개 가져오기
		@Select(" SELECT P.PNO, P.PTITLE, P.PCONTENTS, P.HASTAG, P.PDATE, P.MID, M.MNAME, M.MIMAGE, PVIEWCOUNT,"
				+"         (SELECT COUNT(*) FROM LIKES X WHERE X.PNO = P.PNO) AS likeCount, "
				+"         (SELECT COUNT(*) FROM LIKES X WHERE X.PNO = P.PNO AND MIDYOU = #{mId}) AS myLike, "
				+"         (SELECT MIN(X.FILENAME) AS FILENAME FROM POST_IMAGE X WHERE X.PNO = P.PNO) AS FILENAME, "
				+"   CASE WHEN ROUND((SYSDATE - P.PDATE)) > 0 "
				+"        THEN ROUND((SYSDATE - P.PDATE)) || '일 전' "
			    +"        ELSE CASE WHEN ROUND((SYSDATE - P.PDATE)*24)>0  "
			    +"                  THEN ROUND((SYSDATE - P.PDATE)*24) || '시간 전' "
			    +"                  ELSE ROUND((SYSDATE - P.PDATE)*24*60) || '분 전' "
			    +"             END "
			    +"   END AS AGO , P.STATUS"
				+" FROM POST P INNER JOIN MEMBER M ON P.MID = M.MID "
				+" WHERE pNo = #{pNo}")
		public Post selectOne(@Param("pNo")Integer pNo, @Param("mId")String mId);
	
		//공개글 중 조회수가 가장 많은 5건 - 메인화면 우측 리스트에 사용
		@Select(" SELECT * FROM ( "
				+" SELECT P.PNO, P.MID, M.MNAME, P.PTITLE, P.PVIEWCOUNT "
			    +" FROM POST P INNER JOIN MEMBER M ON P.MID = M.MID "
			    +" WHERE STATUS = 'A' "
			    +" ORDER BY PVIEWCOUNT DESC) "
			    +" WHERE ROWNUM < 6 ")
		public List<Map> selectPostRanking();

		//POST 한개의 전체 콘텐츠 불러들임
		@Select(" select pno, filename from post_image "
				+" WHERE pNo = #{pNo}")
		public List<PostImage> selectContents(Integer pNo);
	
		//마지막컨텐츠번호+1
		@Select(" select to_char(nvl(max(substr(filename, instr(filename,'_', 5)+1, 2)),0) + 1, '00') as contentNo from post_image "
				+" WHERE pNo = #{pNo}")
		public String maxContentNo(Integer pNo);
	
		//좋아유insert
		@Insert("INSERT INTO LIKES VALUES(#{pNo}, #{mIdYou})")
		public int insert_like(Likes lk);
		//좋아유delete
		@Delete("DELETE LIKES WHERE PNO = #{pNo} AND MIDYOU =  #{mIdYou}")
		public int delete_like(Likes lk);
		//좋아유 insert전 기존 좋아유가 있는지 체크용
		@Select("SELECT COUNT(*) FROM LIKES WHERE PNO = #{pNo} AND MIDYOU =  #{mIdYou}")
		public int select_like_count(Likes lk);
	
}