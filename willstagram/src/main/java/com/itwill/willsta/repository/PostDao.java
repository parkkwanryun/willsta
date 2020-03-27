package com.itwill.willsta.repository;

import java.util.List;
import java.util.Map;


import com.itwill.willstar.domain.Post;

public interface PostDao {
	
	public int insert(Post post);
	
	public int insertImg(List<Map> listMap);
	
	public int update(Post post);
	
	public int delete(Integer bNo);
	
	public List<Post> selectMyList(String userId);
}
