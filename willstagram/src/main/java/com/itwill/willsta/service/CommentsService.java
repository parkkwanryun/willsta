package com.itwill.willsta.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwill.willsta.repository.CommentsDao;

@Service
public class CommentsService {
	@Autowired
	private CommentsDao commentsDao;
	
	

}
