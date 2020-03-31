package com.itwill.willsta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itwill.willsta.service.CommentsService;

@RestController
public class CommentsController {
	@Autowired
	private CommentsService commentsService;
	
	@RequestMapping(value = "comments_insert_form", produces = "text/plain;charset=UTF-8")
	public String comments_insert_form() throws Exception {
		
		return "";
	}
}
