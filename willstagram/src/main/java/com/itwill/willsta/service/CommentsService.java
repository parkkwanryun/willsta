package com.itwill.willsta.service;

import java.util.List;

import com.itwill.willsta.domain.Comments;

public interface CommentsService {

	//댓글 작성
	int createComment(Comments comments) throws Exception;

	//댓글 수정
	int updateComments(Comments comments) throws Exception;

	//댓글 삭제
	int removeComments(int cNo) throws Exception;

	//댓글 조회
	Comments findComments(int cNo) throws Exception;

	//댓글 전체 조회
	List<Comments> findCommentsList() throws Exception;

	//한 맴버의 댓글 전체 조회
	List<Comments> findCommentsListBymId(String mId) throws Exception;

	//하나의 포스트에 따른 한 맴버의 댓글 수
	int postCommentsCountBymId(int pNo, String mId) throws Exception;

	//한 맴버가 작성한 총 댓글 수
	int totalCommentsCountBymId(String mId) throws Exception;

	//하나의 포스트에 달린 총 댓글 수
	int postCommentsCount(int pNo) throws Exception;

}