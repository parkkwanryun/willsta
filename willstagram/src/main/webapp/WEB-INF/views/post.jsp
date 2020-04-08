<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:forEach var="post" items="${postList}">
	<div class="post-bar" post_no="${post.pNo}">
		<div class="post_topbar">
			<div class="usy-dt">
				<img src="contents/member_image/${post.mImage}" width=40px height=40px>
				<div class="usy-name">
					<h3>${post.mName}</h3>
					<span><img src="images/clock.png" alt="">
						<c:if test="${post.aGo==null}">지금</c:if>
						<c:if test="${post.aGo!=null}">${post.aGo}</c:if>
					</span>
				</div>
			</div>
			<div class="ed-opts">
				<a href="#" title="" class="ed-opts-open"><i class="la la-ellipsis-v"></i></a>
				<ul class="ed-options">
					<li><a class="updatePost" href="#" title="">Edit Post</a></li>
					<li><a class="deletePost" href="#" title="">Delete Post</a></li>
					<li><a class="hiddenPost" href="#" title="">Hide</a></li>
				</ul>
			</div>
		</div>
		<!-- 여기에 사진(컨텐츠)들어옴 -->
		<c:if test="${fn:startsWith(post.fileName, 'img')}">
			<div class="image">
				<a href="#"><img class="center-block" style="margin:10px 0px;"
					src="contents/post_contents/${post.fileName}" alt="여기에이미지들어옴"
					width="500" height="300" ></a>
			</div>
		</c:if>
		<c:if test="${fn:startsWith(post.fileName, 'mov')}">
			<div class="embed-responsive embed-responsive-4by3" style="margin-bottom:10px;" >
			  <iframe class="embed-responsive-item" style="padding-top:10px;"
			  			src="contents/post_contents/${post.fileName}"></iframe>
			</div>
		</c:if>
		<div class="job_descp">
			<h3>${post.pTitle}</h3>
			<p>${post.pContents}<br><a href="#" title="">view more</a></p>
			<ul class="skill-tags">
				<c:forEach var='tag' items="${post.tagArray}">
					<li><a href="#" title="">${tag}</a></li>
				</c:forEach>
		
			</ul>
		</div>
		<div class="job-status-bar">
			<ul class="like-com">
				<li>
					<a class="like" href="#"><i class="fas fa-heart"></i> Like</a>
					<img src="images/liked-img.png" alt="">
					<span class="likeCount">${post.likeCount}</span>
				</li> 
				<li>
					<a href="#"  class="com comment_list_click" post_no="${post.pNo}">
				    <i class="fas fa-comment-alt"></i> Comments </a>
				</li>
			</ul>
			<a href="#"><i class="fas fa-eye"></i>Views ${post.pViewCount}</a>
		</div>
		
		<!-- comment-section -->
		<div class="comment-section" post_no="${post.pNo}">
			<!-- comment-sec -->
		
			<!--comment-sec end-->
													
												
			<!-- post-comment -->
			<div class="post-comment">
				<div class="comment_box">
					<form class="comments_insert_form">
						<!-- 댓글 내용 쓰는 곳 -->
						<input type="text" placeholder="Post a comment"
							name="cContents" class="cContents">
						<input type="hidden" name="pNo" value="${post.pNo}" >
						<button type="button" class="comments_insert_button">Send</button>
					</form>
				</div>
			</div>
			<!--post-comment end-->
		</div>
		<!--comment-section end-->
	</div>
	<!--post-bar end-->
</c:forEach>