<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<div class="post-bar" post_no="${post.pNo}">
	<div class="post_topbar">
		<div class="usy-dt">
			<img src="images/resources/us-pic.png" alt="">
			<div class="usy-name">
				<h3>${post.mName}</h3>
				<span><img src="images/clock.png" alt="">3 min ago</span>
			</div>
		</div>
		<div class="ed-opts">
			<a href="#" title="" class="ed-opts-open"><i
				class="la la-ellipsis-v"></i></a>
			<ul class="ed-options">
				<li><a class="updatePost" href="#" title="">Edit Post</a></li>
				<li><a class="deletePost" href="#" title="">Unsaved</a></li>
				<li><a class="hiddenPost" href="#" title="">Hide</a></li>
			</ul>
		</div>
	</div>
	<!-- 여기에 사진(컨텐츠)들어옴 -->
	<c:if test="${fn:startsWith(post.fileName, 'img')}">
		<div class="image">
			<a href="#"><img class="center-block" style="margin: 10px 0px;"
				src="contents/post_contents/${post.fileName}" alt="여기에이미지들어옴"
				width="500" height="300"></a>
		</div>
	</c:if>
	<c:if test="${fn:startsWith(post.fileName, 'mov')}">
		<div class="embed-responsive embed-responsive-4by3"
			style="margin-bottom: 10px;">
			<iframe class="embed-responsive-item" style="padding-top: 10px;"
				src="contents/post_contents/${post.fileName}"></iframe>
		</div>
	</c:if>
	<div class="job_descp">
		<h3>${post.pTitle}</h3>
		<p>${post.pContents}<a href="#" title="">view more</a>
		</p>
		<ul class="skill-tags">
			<c:forEach var='tag' items="${post.tagArray}">
				<li><a href="#" title="">${tag}</a></li>
			</c:forEach>

		</ul>
	</div>
	<div class="job-status-bar">
		<ul class="like-com">
			<li><a href="#"><i class="fas fa-heart"></i> Like</a> <img
				src="images/liked-img.png" alt=""> <span>${post.likeCount}</span>
			</li>
			<li id="comment-insert"><a href="#" class="com"><i
					class="fas fa-comment-alt"></i> Comment 15</a></li>
		</ul>
		<a href="#"><i class="fas fa-eye"></i>Views ${post.pViewCount}</a>
	</div>
	<!-- post-comment -->
	<div class="post-comment">
		<div class="cm_img">
			<img src="images/resources/bg-img4.png" alt="">
		</div>
		<div class="comment_box">
			<form id="comment-insert-form">
				<input type="text" placeholder="Post a comment" id="comment-content">
				<!-- 댓글 내용 쓰는 곳 -->
				<button type="submit">Send</button>
			</form>
		</div>
	</div>
	<!--post-comment end-->
</div>
<!--post-bar end-->