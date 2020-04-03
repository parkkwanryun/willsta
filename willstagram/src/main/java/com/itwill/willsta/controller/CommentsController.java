package com.itwill.willsta.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.itwill.willsta.domain.Comments;
import com.itwill.willsta.service.CommentsService;

@RestController
public class CommentsController {
	@Autowired
	private CommentsService commentsService;
	
	@MemberLoginCheck
	@PostMapping(value = "/commentsInsertAction", produces = "text/plain;charset=UTF-8")
	public ModelAndView commentsInsertAction(@RequestParam(value = "pNo", defaultValue = "15") int pNo,
									   		 @RequestParam String cContents,
									   		 HttpSession session) throws Exception {
		ModelAndView mv = new ModelAndView();
		Comments comments = new Comments();
		String mId = (String)session.getAttribute("mId");
		comments.setpNo(pNo);
		comments.setmId(mId);
		comments.setcContents(cContents);
		int createResult = commentsService.createComment(comments);
		if(createResult == 1) {
			mv.addObject("comments", comments);
			mv.setViewName("comments");
		}
		return mv;
	}
	
	@RequestMapping(value = "/postCommentsList", produces = "application/json;charset=UTF-8")
	public List<Comments> postCommentsList(@RequestParam(value = "pNo") int pNo) throws Exception {
		List<Comments> postCommentsList = commentsService.postCommentsList(pNo);
		return postCommentsList;
	}
}
