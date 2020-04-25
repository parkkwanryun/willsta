package com.itwill.willsta.controller;

import java.util.List;

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
	
	@MemberLoginCheck
	@PostMapping(value = "/commentsInsert", produces = "text/plain;charset=UTF-8")
	public String commentsInsert(@RequestParam(value = "pNo") int pNo,
								 @RequestParam String cContents,
								 HttpSession session) throws Exception {
		String result = "";
		Comments comments = new Comments();
		String mId = (String)session.getAttribute("mId");
		comments.setpNo(pNo);
		comments.setmId(mId);
		comments.setcContents(cContents);
		int createResult = commentsService.createComments(comments);
		if(createResult == 1) {
			result = "true";
		} else {
			result = "false";
		}
		return result;
	}
	
	@MemberLoginCheck
	@PostMapping(value = "/postCommentsList", produces = "application/json;charset=UTF-8")
	public List<Comments> postCommentsList(@RequestParam(value = "pNo") int pNo) throws Exception {
		List<Comments> postCommentsList = commentsService.postCommentsList(pNo);
		commentsService.postUpViewCount(pNo);
		return postCommentsList;
	}
	
	@MemberLoginCheck
	@PostMapping(value = "/postCommentsList2", produces = "application/json;charset=UTF-8")
	public List<Comments> postCommentsList2(@RequestParam(value = "pNo") int pNo) throws Exception {
		List<Comments> postCommentsList2 = commentsService.postCommentsList(pNo);
		return postCommentsList2;
	}
	
	@MemberLoginCheck
	@PostMapping(value = "/reCommentsInsert", produces = "text/plain;charset=UTF-8")
	public String reCommentsInsert(@RequestParam(value = "cNo") int recNo,
								   @RequestParam(value = "pNo") int pNo,
								   @RequestParam(value = "recContents") String cContents,
								   HttpSession session) throws Exception {
		String result = "";
		Comments comments = new Comments();
		String mId = (String)session.getAttribute("mId");
		comments.setRecNo(recNo);
		comments.setpNo(pNo);
		comments.setmId(mId);
		comments.setcContents(cContents);
		int createResult = commentsService.createReComments(comments);
		if(createResult == 1) {
			result = "true";
			
		} else {
			result = "false";
		}
		return result;
	}
	
	@MemberLoginCheck
	@PostMapping(value = "/postCommentsCount", produces = "text/plain;charset=UTF-8")
	public String postCommentsCount(@RequestParam(value = "pNo") int pNo) throws Exception {
		int postCommentsCount = commentsService.postCommentsCount(pNo);
		return ""+postCommentsCount;
	}
	
	@MemberLoginCheck
	@PostMapping(value = "/commentsUpdate",  produces = "text/plain;charset=UTF-8")
	public String commentsUpdate(Comments comments) throws Exception {
		String result = "";
		int updateResult = commentsService.updateComments(comments);
		if(updateResult == 1) {
			result = "true";
		}else {
			result = "false";
		}
		return result;
	}
	
	@MemberLoginCheck
	@PostMapping(value = "/removeComments", produces = "text/plain;charset=UTF-8")
	public String removeComments(@RequestParam(value = "cNo") int cNo) throws Exception {
		String result = "";
		int removeResultCheck = commentsService.removeCommentsCountCheck(cNo);
		if(removeResultCheck == 1) {
			int removeResult = commentsService.removeComments(cNo);
			if(removeResult == 1) {
				result = "success";
			}else {
				result = "fail";
			}
		} else if(removeResultCheck > 1) {
			result = "multiResult";
		}
		return result;
	}
}
