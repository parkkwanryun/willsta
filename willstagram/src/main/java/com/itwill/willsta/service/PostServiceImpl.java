package com.itwill.willsta.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.itwill.willsta.domain.Post;
import com.itwill.willsta.repository.PostDao;
@Service
public class PostServiceImpl implements PostService {
	@Autowired
	PostDao postDao;
	
	@Override
	public int createPost(Post post) {
		return postDao.insert(post);
	}

	@Override
	public int modifyPost(Post post) {
		return postDao.update(post);
	}

	@Override
	public int removePost(Integer pNo) {
		return postDao.delete(pNo);
	}

	@Override
	public List<Post> selectMyList(String userId) {
		return postDao.selectMyList(userId);
	}

	@Override
	public Post selectPost(Integer pNo) {
		return postDao.selectPost(pNo);
	}

}
