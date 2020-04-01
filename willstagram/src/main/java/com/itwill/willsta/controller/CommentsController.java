package com.itwill.willsta.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.itwill.willsta.domain.Comments;
import com.itwill.willsta.service.CommentsService;

@RestController
public class CommentsController {
	@Autowired
	private CommentsService commentsService;
	
	@PostMapping(value = "/commentsInsertAction", produces = "text/plain;charset=UTF-8")
	public String commentsInsertAction(@RequestParam(value = "pNo", defaultValue = "15") int pNo,
									   @RequestParam(value = "mId", defaultValue = "hjs") String mId,
									   @RequestParam String cContents,
									   HttpSession session) throws Exception {
		String result = "";
		Comments comments = new Comments();
		//String getmId = (String)session.getAttribute(mId);
		//comments.setmId(getmId);
		comments.setpNo(pNo);
		comments.setmId(mId);
		comments.setcContents(cContents);
		int insertSucess = commentsService.createComment(comments);
		if(insertSucess == 1) {
			result = "true";
		}else {
			result = "false";
		}
		return result;
	}
	
	//@RequestMapping(value = "/postCommentList")
	//public List<Comments> commentsList(@RequestParam(value = "pNo", defaultValue = "15") int pNo) throws Exception {
	//	
		
	//}
}
