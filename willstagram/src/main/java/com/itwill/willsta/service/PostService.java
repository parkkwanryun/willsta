package com.itwill.willsta.service;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.itwill.willsta.domain.Likes;
import com.itwill.willsta.domain.Post;
import com.itwill.willsta.domain.PostImage;
@Transactional(propagation=Propagation.REQUIRED,
				isolation=Isolation.READ_COMMITTED)
public interface PostService {
	
	Post createPost(Post post, MultipartFile[] uploadFile);

	Post modifyPost(Post post, MultipartFile[] uploadFile);

	int removePost(Integer pNo);
	
	List<Post> selectMyList(String userId);
	
	Post selectPost(Integer pNo, String mId);
 
	List<PostImage> selectContents(Integer pNo);
	
	String insert_like(Likes lk);

	int status_change(Integer pNo, String status);

	ModelAndView main_page(String mId);

	
}