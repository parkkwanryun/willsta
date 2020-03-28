package com.itwill.willsta.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwill.willsta.domain.Comments;
import com.itwill.willsta.repository.CommentsDao;

@Service
public class CommentsService {
	@Autowired
	private CommentsDao commentsDao;
	
	//댓글 작성
	public int createComment(Comments comments) throws Exception {
		return commentsDao.createComments(comments);
	}
	
	//댓글 수정
	public int updateComments(Comments comments) throws Exception {
		
		return 0;
	}
	
	//댓글 삭제
	public int removeComments(int cNo) throws Exception {
		
		return 0;
	}
	
	//댓글 조회
	public Comments findComments(int cNo) throws Exception {
		return commentsDao.findComments(cNo);
	}
	
	//댓글 전체 조회
	public List<Comments> findCommentsList() throws Exception {
		
		return null;
	}
}
