package com.itwill.willsta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.itwill.willsta.domain.Comments;
import com.itwill.willsta.service.CommentsService;

@Controller
public class CommentsController {
	@Autowired
	private CommentsService commentsService;
	
	@PostMapping(value = "/commentsInsertForm")
	public String commentsInsert() throws Exception {
		return "redirect:";
	}
	
	@PostMapping(value = "/commentsInsertAction")
	public String commentsInsertAction() throws Exception {
		
		return "";
	}
}
