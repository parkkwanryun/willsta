package com.itwill.willsta.repository;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.willstar.domain.Post;
import com.itwill.willstar.mapper.PostMapper;

@Repository
public class PostDaoImpl implements PostDao {
	@Autowired
	PostMapper postMapper;
	
	@Override
	public int insert(Post post) {
		return postMapper.insert(post);
	}

	@Override
	public int insertImg(List<Map> listMap) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Post post) {
		return postMapper.update(post);
	}

	@Override
	public int delete(Integer bNo) {
		return postMapper.delete(bNo);
	}

	@Override
	public List<Post> selectMyList(String userId) {
		 return postMapper.selectMyList(userId);
	}

}
