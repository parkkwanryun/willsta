package com.itwill.willsta.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.itwill.willsta.domain.Comments;
import com.itwill.willsta.service.CommentsService;

@RestController
public class CommentsController {
	@Autowired
	private CommentsService commentsService;
	
	@PostMapping(value = "/commentsInsertAction")
	public String commentsInsertAction(@RequestParam int pNo,
									   @RequestParam String mId,
									   @RequestParam String cContents,
									   @RequestParam Date cTime,
									   HttpSession session) throws Exception {
		String result = "";
		Comments comments = new Comments();
		String getmId = (String)session.getAttribute(mId);
		comments.setpNo(pNo);
		comments.setmId(getmId);
		comments.setcContents(cContents);
		comments.setcTime(cTime);
		int insertSucess = commentsService.createComment(comments);
		if(insertSucess == 1) {
			result = "true";
		}else {
			result = "false";
		}
		return result;
	}
	
}
