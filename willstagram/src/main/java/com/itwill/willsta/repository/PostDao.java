package com.itwill.willsta.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import com.itwill.willsta.domain.Likes;
import com.itwill.willsta.domain.Post;
import com.itwill.willsta.domain.PostImage;

public interface PostDao {
	
	public int insert(Post post);
	
	public int insertImg(PostImage pi);
	
	public int update(Post post);
	
	public int status_update(Integer pNo, String status);
	
	public int delete(Integer pNo);
	
	public List<Post> selectMyList(Integer lastpNo, String userId);
	
	public Post selectPost(Integer pNo, String mId);
	
	public List<PostImage> selectContents(Integer pNo);
	
	public String maxContentNo(Integer pNo);
	
	public int insert_like(Likes lk);

	public int delete_like(Likes lk);

	public int select_like_count(Likes lk);
	
	public int up_viewcount(Integer pNo);
	
	public int delete_img(Integer pNo);
	
	public List<Map> selectPostRanking();
	
}
