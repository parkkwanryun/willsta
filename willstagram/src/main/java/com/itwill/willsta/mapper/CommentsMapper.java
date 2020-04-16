package com.itwill.willsta.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.itwill.willsta.domain.Comments;

@Mapper
public interface CommentsMapper {
	//댓글 작성
	@Insert("INSERT INTO comments(cNo, pNo, mId, cContents, recNo)"+
			"VALUES (comments_number_seq.NEXTVAL, #{pNo}, #{mId}, #{cContents}, 0)")
	public Integer createComments(Comments comments);
	
	//대댓글 작성
	@Insert("INSERT INTO comments(cNo, pNo, mId, cContents, recNo)"+
			"VALUES (comments_number_seq.NEXTVAL, #{pNo}, #{mId}, #{cContents}, #{recNo})")
	public Integer createReComments(Comments comments);
	
	//댓글 수정
	@Update("UPDATE comments SET cContents = #{cContents} WHERE cNo = #{cNo}")
	public Integer updateComments(Comments comments);
	
	//댓글 삭제 전 삭제될 결과의 수 확인
	@Select("SELECT	count(*) " +
			"FROM (SELECT  cno " +
			"	   FROM    comments " +
			"	   START WITH cNo = #{cNo} " +
			"	   CONNECT BY PRIOR cNo = recNo)")
	public Integer removeCommentsCountCheck(@Param("cNo") int cNo);
	
	//댓글 삭제
	@Delete("DELETE FROM comments WHERE cNo = #{cNo}")
	public Integer removeComments(@Param("cNo") int cNo);
	
	//댓글 조회
	@Select("SELECT cNo, pNo, mId, cContents, cTime " +
			"FROM	comments " +
			"WHERE  cNo = #{cNo}")
	public Comments findComments(@Param("cNo") int cNo);
	
	//댓글 전체 조회
	@Select("SELECT	cNo, pNo, mId, cContents, cTime " + 
			"FROM	comments")
	public List<Comments> findCommentsList();
	
	//하나의 포스트에 달린 총 댓글 수
	@Select("SELECT count(*) " + 
			"FROM comments " +
			"WHERE pNo = #{pNo}")
	public Integer postCommentsCount(@Param("pNo") int pNo);
	
	//하나의 포스트에 달린 댓글 전체 조회
	@Select("SELECT  mId, to_char(cTime + 9/24,'YYYY-MM-DD HH24:MI:SS') as cTime, cNo, recNo, cContents, pNo " + 
			"FROM    comments " + 
			"WHERE   pNo = #{pNo} " + 
			"START WITH  recNo = 0 " + 
			"CONNECT BY PRIOR cNo = recNo")
	public List<Comments> postCommentsList(@Param("pNo") int pNo);
}
