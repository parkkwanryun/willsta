package com.itwill.willsta.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwill.willsta.domain.Comments;
import com.itwill.willsta.repository.CommentsDao;

@Service
public class CommentsServiceImpl implements CommentsService {
	@Autowired
	private CommentsDao commentsDao;
	
	//댓글 작성
	@Override
	public int createComment(Comments comments) throws Exception {
		return commentsDao.createComments(comments);
	}
	
	//댓글 수정
	@Override
	public int updateComments(Comments comments) throws Exception {
		return commentsDao.updateComments(comments);
	}
	
	//댓글 삭제
	@Override
	public int removeComments(int cNo) throws Exception {
		return commentsDao.removeComments(cNo);
	}
	
	//댓글 조회
	@Override
	public Comments findComments(int cNo) throws Exception {
		return commentsDao.findComments(cNo);
	}
	
	//댓글 전체 조회
	@Override
	public List<Comments> findCommentsList() throws Exception {
		List<Comments> findCommentsList = commentsDao.findCommentsList();
		return findCommentsList;
	}
	
	//한 맴버의 댓글 전체 조회
	@Override
	public List<Comments> findCommentsListBymId(String mId) throws Exception {
		List<Comments> findCommentsListBymId = commentsDao.findCommentsListBymId(mId);
		return findCommentsListBymId;
	}
	
	//하나의 포스트에 따른 한 맴버의 댓글 수
	@Override
	public int postCommentsCountBymId(int pNo, String mId) throws Exception {
		return commentsDao.postCommentsCountBymId(pNo, mId);
	}
	
	//한 맴버가 작성한 총 댓글 수
	@Override
	public int totalCommentsCountBymId(String mId) throws Exception {
		return commentsDao.totalCommentsCountBymId(mId);
	}
	
	//하나의 포스트에 달린 총 댓글 수
	@Override
	public int postCommentsCount(int pNo) throws Exception {
		return commentsDao.postCommentsCount(pNo);
	}
}
