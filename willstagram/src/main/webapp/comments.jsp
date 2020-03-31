<%@page import="com.itwill.willsta.domain.Comments"%>
<%@page import="com.itwill.willsta.service.CommentsServiceImpl"%>
<%@page import="com.itwill.willsta.service.CommentsService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	CommentsService commentsService = new CommentsServiceImpl();
	Comments comments = new Comments();
	comments = commentsService.findComments(10);
	
%>
<div class="comment-section">
	<div class="comment-sec">
		<ul>
			<li>
				<div class="comment-list">
					<div class="bg-img">
						<img src="images/resources/bg-img1.png" alt="">
					</div>
					<div class="comment">
						<h3><%comments.getmId(); %></h3>
						<span><img src="images/clock.png" alt=""> 3 min ago</span>
						<p><%comments.getcContents(); %></p>
						<a href="#" title="" class="active"><i class="fa fa-reply-all"></i>Reply</a>
					</div>
				</div> <!--comment-list end-->
				<ul>
					<li>
						<div class="comment-list">
							<div class="bg-img">
								<img src="images/resources/bg-img2.png" alt="">
							</div>
							<div class="comment">
								<h3>John Doe</h3>
								<span><img src="images/clock.png" alt=""> 3 min ago</span>
								<p>Hi John</p>
								<a href="#" title=""><i class="fa fa-reply-all"></i>Reply</a>
							</div>
						</div> <!--comment-list end-->
					</li>
				</ul>
			</li>
			<li>
				<div class="comment-list">
					<div class="bg-img">
						<img src="images/resources/bg-img3.png" alt="">
					</div>
					<div class="comment">
						<h3>John Doe</h3>
						<span><img src="images/clock.png" alt=""> 3 min ago</span>
						<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
							Aliquam luctus hendrerit metus, ut ullamcorper quam finibus at.</p>
						<a href="#" title=""><i class="fa fa-reply-all"></i>Reply</a>
					</div>
				</div> <!--comment-list end-->
			</li>
		</ul>
	</div>
	<!--comment-sec end-->
	<div class="post-comment">
		<div class="cm_img">
			<img src="images/resources/bg-img4.png" alt="">
		</div>
		<div class="comment_box">
			<form>
				<input type="text" placeholder="Post a comment">
				<button type="submit">Send</button>
			</form>
		</div>
	</div>
	<!--post-comment end-->
</div>
<!--comment-section end-->