<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- comment-sec -->
<div class="comment-sec" post_no="${post.pNo}">
	<ul>
		<li>
			<div class="comment-list">
				<div class="comment" comments_no="${comments.cNo}">
					<h3>${comments.mId}</h3>
					<span><img src="images/clock.png" alt="">
						${comments.cTime}</span>
					<p>${comments.cContents}</p>
					<a href="#" title="" class="active"><i class="fa fa-reply-all"></i>Reply</a>
				</div>
			</div>
		</li>
	</ul>
</div>
<!--comment-sec end-->

<!-- post-comment -->
<div class="post-comment">
	<div class="cm_img">
		<img src="images/resources/bg-img4.png" alt="">
	</div>
	<div class="comment_box">
		<form id="comment-insert-form">
			<!-- 댓글 내용 쓰는 곳 -->
			<input type="text" placeholder="Post a comment" id="cContents"
				name="cContents"> <input type="hidden" name="pNo"
				value="${post.pNo}">
			<button type="button" id="comment-insert-button">Send</button>
		</form>
	</div>
</div>
<!--post-comment end-->