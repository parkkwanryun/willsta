<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:forEach var="comments" items="${postCommentsList}">
<div class="comment-sec" style="display:none" comments_no="${comments.cNo}">
	<ul>
		<li>
			<div class="comment-list">
			<c:if test="${comments.RecNo > 0}">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			</c:if>
				<div class="comment">
					<h3>${comments.mId }</h3>
					<span><img src="images/clock.png" alt="">${comments.cTime}</span>
					<p>${comments.cContents}</p>
					<a href="#" title="" class="active acrive-reply" comments_no="${comments.cNo}">
						<i class="fa fa-reply-all"> Reply</i></a>
				</div>
			</div>
		</li>
	</ul>
</div>
</c:forEach>