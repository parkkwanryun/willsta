<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<c:forEach var="post" items="${postList}">
	<div class="post-bar" post_no="${post.pNo}">
		<div class="post_topbar">
			<div class="usy-dt">
				<c:choose>
					<c:when test="${post.mImage==null}">
						<img src="contents/member_image/default.png" width=40px height=40px>
					</c:when>
					<c:otherwise>
						<img src="contents/member_image/${post.mImage}" width=40px height=40px>
					</c:otherwise>
				</c:choose>
				<div class="usy-name">
					<c:choose>
						<c:when test="${post.mId==sessionScope.mId}">
							<h3><a href="personal_info">${post.mName}</a></h3>
						</c:when>
						<c:otherwise>
							<h3><a href="user-profile?youId=${post.mId}">${post.mName}</a></h3>
						</c:otherwise>
					</c:choose>
					<span><img src="images/clock.png" alt="">
						<c:if test="${post.aGo==null}"><s:message code="post.now"/></c:if>
						<c:if test="${post.aGo!=null}">${post.aGo}</c:if>
					</span>
				</div>
			</div>
			<div class="ed-opts">
				<a href="#" title="" class="ed-opts-open"><i class="la la-ellipsis-v"></i></a>
				<ul class="ed-options">
					<li><a class="updatePost" href="#" title=""><s:message code="post.edit"/></a></li>
					<li><a class="deletePost" href="#" title=""><s:message code="post.delete"/></a></li>
					<li><a class="hiddenPost" href="#" title=""><s:message code="post.hide"/></a></li>
				</ul>
			</div>
		</div>
		<!-- 여기에 사진(컨텐츠)들어옴 -->
		<c:if test="${fn:startsWith(post.fileName, 'img')}">
			<div class="image">
				<a href="#"><img class="center-block" style="margin:10px 0px;"
					src="contents/post_image/${post.fileName}" alt="<s:message code='post.image'/>"
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
			<br>
			<h3>${post.pTitle}</h3>
			<p>${post.pContents}<br><a href="#" title=""><s:message code="post.view"/></a></p>
			<ul class="skill-tags">
				<c:forEach var='tag' items="${post.tagArray}">
					<li><a href="#" title="">${tag}</a></li>
				</c:forEach>
		
			</ul>
		</div>
		<div class="job-status-bar">
			<ul class="like-com">
				<li>
					<a class="like" href="#"><i class="fas fa-heart"></i> <s:message code="post.like"/></a>
					<img src="images/liked-img.png" alt="">
					<span class="likeCount">${post.likeCount}</span>
				</li> 
				<li>
					<a href="#"  class="com comment_list_click" >
				    <i class="fas fa-comment-alt"></i> <s:message code="post.comment"/> </a>
				</li>
			</ul>
			<a href="#"><i class="fas fa-eye"></i><s:message code="post.views"/> ${post.pViewCount}</a>
		</div>
		
		<!-- comment-section -->
		<div class="comment-section">
			<!-- comment-sec -->
		
			<!-- post-comment -->
			<div class="post-comment">
				<div class="comment_box">
					<form class="comments_insert_form">
						<!-- 댓글 내용 쓰는 곳 -->
						<input type="text" placeholder="<s:message code='post.postComment'/>"
							name="cContents" class="cContents">
						<input type="hidden" name="pNo" value="${post.pNo}" >
						<button type="button" class="comments_insert_button"><s:message code="post.commentSend"/></button>
					</form>
				</div>
			</div>
			<!--post-comment end-->
			<!--comment-sec end-->
		</div>
		<!--comment-section end-->
	</div>
	<!--post-bar end-->
</c:forEach>