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
	@Insert("INSERT INTO comments(cNo, pNo, mId, cContents)"+
			"VALUES (comments_number_seq.NEXTVAL, #{pNo}, #{mId}, #{cContents})")
	public Integer createComments(Comments comments);
	
	//댓글 수정
	@Update("UPDATE comments SET cContents = #{cContents} WHERE cNo = #{cNo}")
	public Integer updateComments(Comments comments);
	
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
	
	//한 맴버의 댓글 전체 조회
	@Select("SELECT	cNo, pNo, mId, cContents, cTime " + 
			"FROM	comments " +
			"WHERE	mId = #{mId}")
	public List<Comments> findCommentsListBymId(@Param("mId") String mId);
	
	//하나의 포스트에 따른 한 맴버의 댓글 수
	@Select("SELECT count(*) " +
			"FROM 	comments " + 
			"WHERE 	pNo = #{pNo} " +
			"AND 	mId = #{mId}")
	public Integer postCommentsCountBymId(@Param("pNo") int pNo, @Param("mId") String mId);
	
	//한 맴버가 작성한 총 댓글 수
	@Select("SELECT count(*) " +
			"FROM 	comments " + 
			"WHERE 	mId = #{mId}")
	public Integer totalCommentsCountBymId(@Param("mId") String mId);
	
	//하나의 포스트에 달린 총 댓글 수
	@Select("SELECT count(*) " + 
			"FROM comments " +
			"WHERE pNo = #{pNo}")
	public Integer postCommentsCount(@Param("pNo") int pNo);
	
	//하나의 포스트에 달린 댓글 전체 조회
	@Select("SELECT cNo, pNo, mId, cContents, cTime " + 
			"FROM comments " +
			"WHERE pNo = #{pNo}")
	public List<Comments> postCommentsList(@Param("pNo") int pNo);
}
