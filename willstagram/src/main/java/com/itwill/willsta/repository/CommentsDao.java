package com.itwill.willsta.repository;

import java.util.List;

import com.itwill.willsta.domain.Comments;

public interface CommentsDao {

	//댓글 작성
	public int createComments(Comments comments) throws Exception;

	//댓글 수정
	public int updateComments(Comments comments) throws Exception;

	//댓글 삭제
	public int removeComments(int cNo) throws Exception;

	//댓글 조회
	public Comments findComments(int cNo) throws Exception;

	//댓글 전체 조회
	public List<Comments> findCommentsList() throws Exception;
	
	//하나의 포스트에 따른 한 맴버의 댓글 수
	public int postCommentsCountBymId(int pNo, String mId) throws Exception;
	
	//한 맴버가 작성한 총 댓글 수
	public int totalCommentsCountBymId(String mid) throws Exception;
	
	//하나의 포스트에 달린 총 댓글 수
	public int postCommentsCount(int pNo) throws Exception;
}