<%@page import="com.itwill.willsta.domain.Comments"%>
<%@page import="com.itwill.willsta.service.CommentsService"%>
<%@page import="com.itwill.willsta.service.CommentsServiceImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String cNo = request.getParameter("cNo");
	if(cNo == null || cNo.equals("")) cNo = "10";
	CommentsService commentsService = new CommentsServiceImpl();
	Comments comments = new Comments();
	comments = commentsService.findComments(Integer.parseInt(cNo));
%>
[
{
"mId" : "<%=comments.getmId() %>",
"cContents" : "<%=comments.getcContents() %>"
}
]
