package com.itwill.willsta.service;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.itwill.willsta.domain.Post;
import com.itwill.willsta.domain.PostImage;

public interface PostService {
	@Transactional(propagation=Propagation.REQUIRED,
			isolation=Isolation.READ_COMMITTED)
	Post createPost(Post post,  MultipartFile[] uploadFile);
	
	public int insertImg(PostImage pi);

	int modifyPost(Post post);

	int removePost(Integer pNo);

	List<Post> selectMyList(String userId);
	
	Post selectPost(Integer pNo);
 
	List<PostImage> selectContents(Integer pNo);
	
	public String maxContentNo(Integer pNo);

}