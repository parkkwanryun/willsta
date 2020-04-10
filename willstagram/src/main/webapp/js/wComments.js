//포스트-댓글 전체 보이기 ajax요청
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
			dataType : "html",
			success : function(htmlData){
				console.log(htmlData);
				$postComments.append(htmlData);
				$postComments.children().fadeToggle(500);
			}
		});
	}
};


//댓글 작성 ajax 요청
function commentsInsertActionFunction(e){
	//console.log($(e.target).parents(".post-bar"));
	var $comments = $(e.target).parents(".post-bar").find(".comments_insert_form");
	//console.log($comments);
	var pNo = $(e.target).parents(".comment-section").attr("post_no");
	console.log(pNo);
	var params = $comments.serialize();
	//console.log(params);
	$.ajax({
		url : "commentsInsert",
		data : params,
		method : "POST",
		dataType : "text",
		success : function(result) {
			if(result.trim() == "true"){
				$comments[0].reset();
				//postCommentsListFunction(e);
				commentsInsertActionAfterListFunction(e);
			}else if(result.trim() == "false"){
				alert("댓글쓰기 실패");
				$comments.select();
			}
		}
	});
}

//댓글 작성 후 포스트 댓글 ajax 요청
function commentsInsertActionAfterListFunction(e){
	var $postComments = $(e.target).parents(".post-bar").find(".comment-section");
	console.log($postComments);
	var params = "pNo="+$postComments.attr("post_no");
	console.log(params);
		$.ajax({
			url : "postCommentsList",
			data : params,
			method : "POST",
			dataType : "html",
			success : function(htmlData){
				console.log(htmlData);
				$postComments.html(htmlData);
				$postComments.children().fadeToggle(500);
			}
		});
}

//대댓글 작성 form 보여주기
function reCommentsInsertFormShowFunction(e){
	//console.log($(e.target).parents(".comment-sec"));
	var $reCommentsForm =  $(e.target).parents(".comment-sec").find(".active-reply");
	//console.log($reCommentsForm);
	var cNo = $(e.target).parents(".comment-sec").attr("comments_no");
	var pNo = $(e.target).parents(".comment-section").attr("post_no");
	//console.log(cNo);
	var html = "";
	html += "<div class='post-comment' style='display:none'>" +
			"	<div class='comment_box_inner'>" +
			"		<form class='recomments_insert_form'>" +
			"			<input type='text' placeholder='Post a comment'" +
			"				name='cContents' class='cContents' >" +
			"			<input type='hidden' name='cNo' value='"+cNo+"' >" +
			"			<input type='hidden' name='pNo' value='"+pNo+"' >" +
			"			<button type='button' class='recomments_insert_button'>Send</button></div>" +
			"		</form>" +
			"	</div>" +
			"</div>";
	if($reCommentsForm.children().length == 1){
		$reCommentsForm.append(html);
		$reCommentsForm.children().fadeToggle(500);
	}
}


//대댓글 쓰기
/*
function reCommentsInsertActionFunction(e){
	//console.log($(e.target).parents(".comment-section"));
	console.log($(e.target).parents(".comment-section").find(".recomments_insert_form"));
	var $reComments = $(e.target).parents(".comment-section").find(".recomments_insert_form");
	var params = $reComments.serialize();
	console.log(params);
	$.ajax({
		url : "reCommentsInsert",
		data : params,
		method : "POST",
		dataType : "text",
		success : function(result){
			if(result.trim() == "true"){
				$reComments[0].reset();
				
			}
		} 
	});
	
}
*/



//document ready
$(function() {
	// 포스트-댓글 전체 보이기
	$(document).on("click", ".comment_list_click", function(e){
		//console.log(e.target);
		postCommentsListFunction(e);
		e.preventDefault();
	});
	
	// 댓글 쓰기
	$(document).on("click", ".comments_insert_button", function(e){
		//console.log(e.target);
		commentsInsertActionFunction(e);
	});
	
	//대댓글 쓰기 폼 보이기
	$(document).on("click", ".active-reply", function(e){
		console.log(e.target);
		reCommentsInsertFormShowFunction(e);
		e.preventDefault();
	});
	
	//대댓글 쓰기
	/*
	$(document).on("click", ".recomments_insert_button", function(e){
		console.log(e.target);
		reCommentsInsertActionFunction(e);
		e.preventDefault();
		e.stopPropagation();
	});
	*/
	
});