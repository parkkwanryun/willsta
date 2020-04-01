package com.itwill.willsta.controller;

import java.util.Date;

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
	
	@PostMapping(value = "/commentsInsertForm")
	public String commentsInsert() throws Exception {
		return "redirect:";
	}
	
	@PostMapping(value = "/commentsInsertAction")
	public String commentsInsertAction(@RequestParam int pNo,
									   @RequestParam String mId,
									   @RequestParam String cContents,
									   @RequestParam Date cTime) throws Exception {
		String result = "";
		Comments comments = new Comments();
		comments.setpNo(pNo);
		comments.setmId(mId);
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
