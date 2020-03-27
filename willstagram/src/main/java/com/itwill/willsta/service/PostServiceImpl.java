package com.itwill.willsta.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.itwill.willstar.domain.Post;
import com.itwill.willstar.repository.PostDao;
@Service
public class PostServiceImpl implements PostService {
	@Autowired
	PostDao postDao;
	
	@Override
	public int createBoard(Model model) {
		Post post;
		//postDao.insert(post);
		return 0;
	}

	@Override
	public int modifyBoard(Post post) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int removeBoard(Integer bNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Post> selectMyList(String userId) {
		return postDao.selectMyList(userId);
	}

}
