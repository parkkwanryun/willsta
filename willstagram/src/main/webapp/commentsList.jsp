<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- comments -->
<div class="comment-sec">
	<ul>
		<li>
			<div class="comment-list">
				<div class="bg-img">
					<img src="images/resources/bg-img1.png" alt="">
				</div>
				<div class="comment">
					<h3>${comments.mId}......JohnDoe</h3>
					<span><img src="images/clock.png" alt="">${commtents.cTime}
						3 min ago</span>
					<p>${comments.cContents}contents</p>
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
			<input type="text" placeholder="Post a comment" id="cContents" name="cContents">
			<button type="submit" id="comment-insert-button">Send</button>
		</form>
	</div>
</div>
<!--post-comment end-->
