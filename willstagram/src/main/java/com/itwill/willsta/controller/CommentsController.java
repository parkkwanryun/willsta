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
	@PostMapping(value = "/postCommentsList", produces = "text/html;charset=UTF-8")
	public String postCommentsList(@RequestParam(value = "pNo") int pNo, HttpSession session) throws Exception {
		String sessionmId = (String)session.getAttribute("mId");
		StringBuffer sb = new StringBuffer();
		List<Comments> postCommentsList = commentsService.postCommentsList(pNo);
		
		for (int i = 0; i < postCommentsList.size(); i++) {
			Comments comments = postCommentsList.get(i);
			sb.append("<div class='comment-sec' style='display:none' comments_no='"+comments.getcNo()+"'>");
			sb.append("<ul>");
			sb.append("	<li>");
			sb.append("		<div class='comment-list'>");
			if(comments.getRecNo() > 0) {
				sb.append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
			}
			sb.append("			<div class='comment'>");
			sb.append("				<h3>"+comments.getmId()+"</h3>");
			sb.append("				<span><img src='images/clock.png' alt=''>"+comments.getcTime()+"</span>");
			sb.append("				<p>"+comments.getcContents()+"</p>");
			sb.append("				<a href='#' class='active active-reply' comments_no='"+comments.getcNo()+"'>");
			sb.append("					<i class='fa fa-reply-all'> Reply</i></a>");
			//내글인 경우 수정 및 삭제 가능
			if(comments.getmId().equals(sessionmId)) { 
				sb.append("				<a href='#' class='active active-edit' "); 
				sb.append("					data-toggle='modal' data-target='#updateCommentsModal' comments_no='"+comments.getcNo()+"'>");
				sb.append("					<i class='fa fa-cog'> Edit</i></a>");
				sb.append("				<a href='#' class='active active-delete' comments_no='"+comments.getcNo()+"'>");
				sb.append("					<i class='fa fa-remove'> Delete</i></a>");
			}
			sb.append("			</div>");
			sb.append(" 	</div>");	
			sb.append("	</li>");
			sb.append("</ul>");
			sb.append("</div>");
		}
		return sb.toString();
	}
	
	@MemberLoginCheck
	@PostMapping(value = "/reCommentsInsert", produces = "text/plain;charset=UTF-8")
	public String reCommentsInsert(@RequestParam(value = "cNo") int recNo,
								   @RequestParam(value = "pNo") int pNo,
								   @RequestParam String cContents,
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
		return "&nbsp;"+postCommentsCount;
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
