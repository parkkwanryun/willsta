package com.itwill.willsta.service;

import java.util.List;

import com.itwill.willsta.domain.Post;

public interface PostService {

	int createPost(Post post);

	int modifyPost(Post post);

	int removePost(Integer pNo);

	List<Post> selectMyList(String userId);

}