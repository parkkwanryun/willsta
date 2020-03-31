package com.itwill.willsta.repository;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.willsta.domain.Post;
import com.itwill.willsta.domain.PostImage;
import com.itwill.willsta.mapper.PostMapper;

@Repository
public class PostDaoImpl implements PostDao {
	@Autowired
	PostMapper postMapper;
	
	@Override
	public int insert(Post post) {
		return postMapper.insert(post);
	}

	@Override
	public int insertImg(PostImage pi) {
		return postMapper.insertImg(pi);
	}

	@Override
	public int update(Post post) {
		return postMapper.update(post);
	}

	@Override
	public int delete(Integer pNo) {
		return postMapper.delete(pNo);
	}

	@Override
	public List<Post> selectMyList(String userId) {
		 return postMapper.selectMyList(userId);
	}

	@Override
	public Post selectPost(Integer pNo) {
		 return postMapper.selectOne(pNo);
	}

	@Override
	public List<PostImage> selectContents(Integer pNo) {
		return postMapper.selectContents(pNo);
	}

	@Override
	public String maxContentNo(Integer pNo) {
		return postMapper.maxContentNo(pNo);
	}



}
