//document ready
$(function() {
	// 댓글 쓰기
	/*
	$(document).on("click", ".comments_insert_button", function(e) {
		var $comments = $(e.target).parents("div.post-comment");
		var paramPNo = "pNo="+$comments.attr("post_no");
		
		var params = $(".comments_insert_form").serialize();
		$.ajax({
			url : "commentsInsertAction",
			data : params,
			method : "POST",
			dataType : "html",
			success : function(resultText) {
				$("div.comment-sec").append(resultText);
				$("[input='text']").attr("value");
			}
		});
		e.preventDefault();
	});
	*/
	
	// 포스트-댓글 전체 보이기
	$(document).on("click", "a.comment_list_click", function(e){
		console.log(e.target);
		var $comments = $('.post-bar-'+$(e.target).attr('post_no')).find('.comment-section');
		console.log($comments);
		postCommentsListFunction($comments);
		e.preventDefault();
	});
});


// 포스트-댓글 전체 보이기 ajax요청
function postCommentsListFunction($comments){
	var params = "pNo="+$comments.attr("post_no");
	console.log(params);
	console.log($comments.children().is(":visible"));
	if($comments.children().length > 1){
		$comments.children().fadeToggle(300);
	}else {
		$.ajax({
			url : "postCommentsList",
			data : params,
			method : "GET",
			dataType : "json",
			success : function(jsonArray){
				console.log(jsonArray);
				var html = "";
				$.each(jsonArray, function(i, jsonObject){
					jsonObject = jsonArray[i];
					var cNo = jsonObject.cNo;
					var pNo = jsonObject.pNo;
					var mId = jsonObject.mId;
					var cTime = jsonObject.cTime;
					var cContents = jsonObject.cContents;
					html += "<div class='comment-sec' style='display:none'>" +
							"<ul>" +
							"	<li>" +
							"		<div class='comment-list'>"	+	
							"			<div class='comment' comments_no='"+cNo+"'>" +
							"				<h3>"+mId+"</h3>" +
							"				<span><img src='images/clock.png' alt=''>"+cTime+"</span>" +
							"				<p>"+cContents+"</p>" +
							"				<a href='#' title='' class='active'><i class='fa fa-reply-all'></i>Reply</a>" +
							"			</div>" +
							" 		</div>" +	
							"	</li>" +
							"</ul>" +
							"</div>";
				});
				$comments.append(html);
				$comments.children().fadeToggle(300);
			}
		});
	}
};
