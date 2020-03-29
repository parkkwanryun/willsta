package com.itwill.willsta.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import com.itwill.willsta.domain.Post;

@Mapper
public interface PostMapper {
	@Insert("INSERT INTO POST VALUES (#{pNo}, #{mId}, #{pTitle}, #{pContents}, #{hasTag}, 0, sysdate)")
	@SelectKey(statement ="select post_number_seq.NEXTVAL from dual", keyProperty = "pNo",  before = true, resultType = Integer.class)
	public int insert(Post post);

	//컨텐트이름들은 리스트맵으로 컨트롤
	@Insert("INSERT INTO POST_IMAGE VALUES(#{fileName}, #{pNo}")
	public int insertImg(List<Map> listMap);
	
	@Update({"<script> ", 
			"	UPDATE POST ", 
			"	<set> ", 
			"    	pTitle = #{pTitle}, ", 
			"    	pContents = #{pContents}, ", 
			"    	hasTag = #{hasTag} ", 
			"	</set> ",  
			"	WHERE pNo = #{pNo} ",
			"</script>"})
	public int update(Post post);
	
	@Delete("DELETE FROM POST WHERE pNo = #{pNo}")
	public int delete(Integer pNo);
	
	
	//로그인 후 리스트 자신과 자신의 팔로잉 멤버의 글을 리스트를 작성일이 최신인 것 순으로 정렬
	@Select(" SELECT P.PNO, P.PTITLE, P.PCONTENTS, P.HASTAG, P.PDATE, P.MID, M.MNAME, "
			+"         (SELECT COUNT(*) FROM LIKES X WHERE X.PNO = P.PNO) AS LIKECNT, "
			+"         (SELECT MIN(X.FILENAME) AS FILENAME FROM POST_IMAGE X WHERE X.PNO = P.PNO) AS FILENAME "
			+" FROM POST P INNER JOIN MEMBER M ON P.MID = M.MID "
			+" WHERE (P.MID = #{mId} "
			+"       OR P.MID IN (SELECT mIdYou FROM FOLLOW WHERE MID = #{mId})) "
			+" ORDER BY P.PNO DESC")
	public List<Post> selectMyList(String mId);
	
	
	//POST 한개 가져오기
		@Select(" SELECT P.PNO, P.PTITLE, P.PCONTENTS, P.HASTAG, P.PDATE, P.MID, M.MNAME, "
				+"         (SELECT COUNT(*) FROM LIKES X WHERE X.PNO = P.PNO) AS LIKECNT, "
				+"         (SELECT MIN(X.FILENAME) AS FILENAME FROM POST_IMAGE X WHERE X.PNO = P.PNO) AS FILENAME "
				+" FROM POST P INNER JOIN MEMBER M ON P.MID = M.MID "
				+" WHERE pNo = #{pNo}")
		public Post selectOne(Integer pNo);
	
	
	
	
}