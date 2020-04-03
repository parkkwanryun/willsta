//document ready
$(function() {
	// 댓글 쓰기
	$(document).on("click", "form > button", function(e) {
		alert("!!");
		/*
		var paramStr = $("#comment-insert-form").serialize();
		$.ajax({
			url : "commentsInsertAction",
			data : paramStr,
			method : "POST",
			dataType : "html",
			success : function(resultText) {
				$("div.comment-section").append(resultText);
			}
		});
		 */
	});
	
	// 포스트-댓글 전체 보이기
	$(document).on("click", "#comment_list_click", function(e){
		var $post = $(e.target).parents("div.comment-section");
		var params = "pNo="+$post.attr("post_no");
		$.ajax({
			url : "postCommentsList",
			method : "POST",
			data : params,
			dataType : "json",
			success : function(jsonArray){
				console.log(jsonArray);
				var html = "";
				$.each(jsonArray, function(i, jsonObject){
					jsonObject = jsonArray[i];
					var cNo = jsonObject.cNo;
					var mId = jsonObject.mId;
					var cTime = jsonObject.cTime;
					var cContents = jsonObject.cContents;
					html += "<ul>" +
							"	<li>" +
							"		<div class='comment' comments_no='"+cNo+"'>" +
							"			<h3>"+mId+"</h3>" +
							"			<span><img src='images/clock.png' alt=''>"+cTime+"</span>" +
							"			<p>"+cContents+"</p>" +
							"			<a href='#' title='' class='active'><i class='fa fa-reply-all'></i>Reply</a>" +
							"		</div>" +
							"	</li>" +
							"</ul>";
				});
				 $("div.comment-sec").html(html).slideToggle(500);										
			}
		});
	});
	
});
