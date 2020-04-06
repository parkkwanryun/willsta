// 포스트-댓글 전체 보이기 ajax요청
function postCommentsListFunction($postComments){
	var params = "pNo="+$postComments.attr("post_no");
	console.log(params);
	if($postComments.children().length > 1){
		$postComments.children().fadeToggle(300);
	}else {
		$.ajax({
			url : "postCommentsList",
			data : params,
			method : "POST",
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
				$postComments.append(html);
				$postComments.children().fadeToggle(300);
			}
		});
	}
};


//댓글 작성 ajax 요청
function commentsInsertActionFunction($comments){
	var params = "pNo="+$comments.attr("post_no");
	
	$.ajax({
		url : "commentsInsert",
		data : params,
		method : "POST",
		dataType : "text",
		success : function(result) {
			if(result.trim() == "true"){
				
			}else if(result.trim() == "false"){
				
			}
		}
	});
}

//document ready
$(function() {
	// 포스트-댓글 전체 보이기
	$(document).on("click", "a.comment_list_click", function(e){
		console.log(e.target);
		var $postComments = $(".post-bar-"+$(e.target).attr("post_no")).find(".comment-section");
		console.log($postComments);
		postCommentsListFunction($postComments);
		e.preventDefault();
	});
	
	// 댓글 쓰기
	$(document).on("click", ".comments_insert_button", function(e) {
		console.log(e.target);
		console.log($(e.target).parent(".comments_insert_form").attr("post_no"));
		var $comments = $(e.target).parent(".comments_insert_form").attr("post_no");
		
		commentsInsertActionFunction($comments);
		e.preventDefault();
	});
});