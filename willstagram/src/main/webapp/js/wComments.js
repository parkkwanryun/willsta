// 포스트-댓글 전체 보이기 ajax요청
function postCommentsListFunction(e){
	var $postComments = $(e.target).parents(".post-bar").find(".comment-section");
	console.log($postComments);
	var params = "pNo="+$postComments.attr("post_no");
	console.log(params);
	if($postComments.children().length > 1){
		$postComments.children().fadeToggle(500);
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
					html += "<div class='comment-sec' style='display:none' comments_no='"+cNo+"'>" +
							"<ul>" +
							"	<li>" +
							"		<div class='comment-list'>"	+	
							"			<div class='comment' >" +
							"				<h3>"+mId+"</h3>" +
							"				<span><img src='images/clock.png' alt=''>"+cTime+"</span>" +
							"				<p>"+cContents+"</p>" +
							"				<a href='#' class='active' comments_no='"+cNo+"' data-toggle='collapse'><i class='fa fa-reply-all'></i>Reply</a>" +
							"			</div>" +
							" 		</div>" +	
							"	</li>" +
							"</ul>" +
							"</div>";
				});
				$postComments.append(html);
				$postComments.children().fadeToggle(500);
			}
		});
	}
};


//댓글 작성 ajax 요청
function commentsInsertActionFunction($comments, pNo){
	var params = $comments.serialize();
	console.log(params);
	$.ajax({
		url : "commentsInsert",
		data : params,
		method : "POST",
		dataType : "text",
		success : function(result) {
			if(result.trim() == "true"){
				alert("댓글 쓰기 성공");
				$comments[0].reset();
				$("a[post_no="+pNo+"]").trigger('click');
				
			}else if(result.trim() == "false"){
				alert("댓글 쓰기 실패");
				$comments.select();
			}
		}
	});
}


//대댓글 작성 form 보여주기
function reCommentsInsertFormShowFunction($reCommentsForm, cNo){
	var html = "";
	html += "<div class='post-comment'>" +
			"	<div class='comment_box'>" +
			"		<form class='comments_insert_form' comments_no='"+cNo+"'>" +
			"			<input type='text' placeholder='Post a comment'" +
			"				name='cContents' class='cContents'>" +
			"			<input type='hidden' name='cNo' value='"+cNo+"' >" +
			"			<button type='button' class='comments_insert_button' comments_no='"+cNo+"'>Send</button>" +
			"		</form>" +
			"	</div>" +
			"</div>";
	$reCommentsForm.append(html);
}





//document ready
$(function() {
	// 포스트-댓글 전체 보이기
	$(document).on("click", ".comment_list_click", function(e){
		console.log(e.target);
		postCommentsListFunction(e);
		e.preventDefault();
	});
	
	// 댓글 쓰기
	$(document).on("click", ".comments_insert_button", function(e){
		console.log(e.target);
		var $comments = $(".post-bar-"+$(e.target).attr("post_no")).find(".comments_insert_form");
		console.log($comments);
		commentsInsertActionFunction($comments, $(e.target).attr("post_no"));
		e.preventDefault();
	});
	
	//대댓글 쓰기 폼 보이기
	/*$(document).on("click", ".active", function(e){
		console.log(e.target);
		var $reCommentsForm = $(".comment-sec-"+$(e.target).attr("comments_no"));
		console.log($reCommentsForm);
		reCommentsInsertFormShowFunction($reCommentsForm, +$(e.target).attr("comments_no"));
		e.preventDefault();
	});*/
});