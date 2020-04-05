package com.itwill.willsta.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.willsta.domain.Comments;
import com.itwill.willsta.mapper.CommentsMapper;

@Repository(value = "commentsDao")
public class CommentsDaoImpl implements CommentsDao {
	@Autowired
	private CommentsMapper commentsMapper;
	
	//댓글 작성
	@Override
	public int createComments(Comments comments) throws Exception {
		return commentsMapper.createComments(comments);
	}
	
	//댓글 수정
	@Override
	public int updateComments(Comments comments) throws Exception {
		return commentsMapper.updateComments(comments);
	}
	
	//댓글 삭제
	@Override
	public int removeComments(int cNo) throws Exception {
		return commentsMapper.removeComments(cNo);
	}
	
	//댓글 조회
	@Override
	public Comments findComments(int cNo) throws Exception {
		return commentsMapper.findComments(cNo);
	}
	
	//댓글 전체 조회
	@Override
	public List<Comments> findCommentsList() throws Exception {
		return commentsMapper.findCommentsList();
	}
	
	//한 맴버의 댓글 전체 조회
	@Override
	public List<Comments> findCommentsListBymId(String mId) throws Exception {
		return commentsMapper.findCommentsListBymId(mId);
	}

	//하나의 포스트에 따른 한 맴버의 댓글 수
	@Override
	public int postCommentsCountBymId(int pNo, String mId) throws Exception {
		return commentsMapper.postCommentsCountBymId(pNo, mId);
	}

	//한 맴버가 작성한 총 댓글 수
	@Override
	public int totalCommentsCountBymId(String mId) throws Exception {
		return commentsMapper.totalCommentsCountBymId(mId);
	}

	////하나의 포스트에 달린 총 댓글 수
	@Override
	public int postCommentsCount(int pNo) throws Exception {
		return commentsMapper.postCommentsCount(pNo);
	}

	//하나의 포스트에 달린 댓글 전체 조회
	@Override
	public List<Comments> postCommentsList(int pNo) throws Exception {
		return commentsMapper.postCommentsList(pNo);
	}
	
}
