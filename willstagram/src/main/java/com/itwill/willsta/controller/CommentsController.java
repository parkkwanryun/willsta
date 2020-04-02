package com.itwill.willsta.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.itwill.willsta.domain.Comments;
import com.itwill.willsta.service.CommentsService;

@RestController
public class CommentsController {
	@Autowired
	private CommentsService commentsService;
	
	@PostMapping(value = "/commentsInsertAction", produces = "text/plain;charset=UTF-8")
	public ModelAndView commentsInsertAction(@RequestParam(value = "pNo", defaultValue = "15") int pNo,
									   @RequestParam(value = "mId") String mId,
									   @RequestParam String cContents,
									   HttpSession session) throws Exception {
		ModelAndView mv = new ModelAndView();
		Comments comments = new Comments();
		String getmId = (String)session.getAttribute(mId);
		System.out.println(getmId);
		comments.setmId(getmId);
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
	
	//@RequestMapping(value = "/postCommentList")
	//public List<Comments> commentsList(@RequestParam(value = "pNo", defaultValue = "15") int pNo) throws Exception {
		
		
	//}
}
