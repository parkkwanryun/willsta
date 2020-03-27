package com.itwill.willsta.service;

import java.util.List;

import org.springframework.ui.Model;

import com.itwill.willsta.domain.Post;

public interface PostService {
	
	public int createBoard(Model model);
	
	public int modifyBoard(Post post);
	
	public int removeBoard(Integer bNo);
	
	public List<Post> selectMyList(String userId);

	
}
