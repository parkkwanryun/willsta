//포스트-댓글 전체 보이기 ajax요청
function postCommentsListFunction(e){
	var $postComments = $(e.target).parents(".post-bar").find(".comment-section");
	//console.log($postComments);
	var params = "pNo="+$postComments.attr("post_no");
	//console.log(params);
	if($postComments.children().length > 1){
		$postComments.children().fadeToggle(500);
	}else {
		$.ajax({
			url : "postCommentsList",
			data : params,
			method : "POST",
			dataType : "text",
			success : function(htmlData){
				//console.log(htmlData);
				postCommentsCount(e);
				$postComments.append(htmlData);
				$postComments.children().fadeToggle(500);
			}
		});
	}
}


//포스트-댓글 수 ajax 요청
function postCommentsCount(e){
	var $postComments = $(e.target).parents(".post-bar").find(".comment-section");
	//console.log($postComments);
	var params = "pNo="+$postComments.attr("post_no");
	//console.log(params);
	$.ajax({
		url : "postCommentsCount",
		data : params,
		method : "POST",
		dataType : "text",
		success : function(count){
			//console.log(count);
			$(e).html("<i class='fas fa-comment-alt'></i> Comments &nbsp;"+count);
		}
	});
}


//DOM tree 생성 후 포스트-댓글 수 ajax 요청
function postCommentsCount2($aNodeList){
	for (var i = 0; i < $aNodeList.length; i++) {
		var $postComments = $($aNodeList.get(i)).parents(".post-bar").find(".comment-section");
		//console.log($postComments);
		var params = "pNo="+$postComments.attr("post_no");
		//console.log(params);
		$.ajax({
			async : false,
			url : "postCommentsCount",
			data : params,
			method : "POST",
			dataType : "text",
			success : function(count){
				console.log(count);
				$($aNodeList.get(i)).html("<i class='fas fa-comment-alt'></i> Comments &nbsp;"+count);
			}
		});
	}
}


//댓글 작성 ajax 요청
function commentsInsertActionFunction(e){
	//console.log($(e.target).parents(".post-bar"));
	var $comments = $(e.target).parents(".post-bar").find(".comments_insert_form");
	console.log($comments);
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
				setTimeout(function() {
					window.location.reload();
				}, 500);
			}else if(result.trim() == "false"){
				alert("댓글 쓰기를 실패했습니다.");
				$comments.find(".cContents").select();
			}
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
			"			<input type='text' placeholder='Comment a ReComment'" +
			"				name='cContents' class='cContents'>" +
			"			<input type='hidden' name='cNo' value='"+cNo+"' >" +
			"			<input type='hidden' name='pNo' value='"+pNo+"' >" +
			"			<button type='button' class='recomments_insert_button'>Send</button></div>" +
			"		</form>" +
			"	</div>" +
			"</div>";
	if($reCommentsForm.children().length == 1){
		$reCommentsForm.prepend(html);
		$reCommentsForm.children().fadeToggle(500);
	}
}


//대댓글 쓰기 ajax요청
function reCommentsInsertActionFunction(e){
	//console.log($(e.target).parents(".comment-section"));
	//console.log($(e.target).parents(".comment-section").find(".recomments_insert_form"));
	var $reComments = $(e.target).parents(".comment-section").find(".recomments_insert_form");
	var params = $reComments.serialize();
	//console.log(params);
	$.ajax({
		url : "reCommentsInsert",
		data : params,
		method : "POST",
		dataType : "text",
		success : function(result){
			if(result.trim() == "true"){
				setTimeout(function() {
					window.location.reload();
				}, 500);
			}else if(result.trim() == "false"){
				alert("대댓글 쓰기를 실패했습니다.");
				$reComments.find(".cContents").select();
			}
		} 
	});
}


//댓글 삭제 ajax 요청
function removeCommentsActionFunction(e){
	var cNo = $(e.target).parents(".comment-sec").attr("comments_no");
	var params = "cNo="+cNo;
	console.log(params);
	$.ajax({
		url : "removeComments",
		data : params,
		method : "POST",
		dataType : "text",
		success : function(result){
			if(result.trim() == "success"){
				setTimeout(function() {
					window.location.reload();
				}, 500);
			}else if(result.trim() == "fail"){
				alert("댓글 삭제를 실패했습니다.")
			}else if(result.trim() == "multiResult"){
				alert("대댓글이 있는 댓글은 삭제할 수 없습니다.");
			}
		}
	});
}


//댓글 수정 ajax 요청
function commentsUpdateActionFunction(e){
	var params = {
			cNo : $(e.target).attr("comments_no"),
			cContents : $("#modal_cContents").val()
		};
		console.log(params);
		$.ajax({
			url : "commentsUpdate",
			data : params,
			method : "POST",
			success : function(result){
				if(result.trim() == "true"){
					setTimeout(function() {
						window.location.reload();
					}, 500);
				}else if(result.trim() == "false"){
					alert("댓글 수정을 실패했습니다.")
				}
			} 
		});
}


//document ready
$(function() {
	//포스트-댓글 전체 보이기
	$(document).on("click", ".comment_list_click", function(e){
		//console.log(e.target);
		postCommentsListFunction(e);
		e.preventDefault();
	});
	
	//댓글 쓰기
	$(document).on("click", ".comments_insert_button", function(e){
		//console.log(e.target);
		commentsInsertActionFunction(e);
		e.preventDefault();
	});
	
	//대댓글 쓰기 form 보이기
	$(document).on("click", ".active-reply", function(e){
		//console.log(e.target);
		reCommentsInsertFormShowFunction(e);
		e.preventDefault();
	});
	
	//대댓글 쓰기
	$(document).on("click", ".recomments_insert_button", function(e){
		//console.log(e.target);
		reCommentsInsertActionFunction(e);
		e.preventDefault();
		e.stopPropagation();
	});
	
	//댓글 삭제
	$(document).on("click", ".active-delete", function(e){
		var text = window.confirm("댓글을 삭제하시겠습니까?");
		if(text == true){
			removeCommentsActionFunction(e);
			e.preventDefault();
		}else if(text == false){
			e.preventDefault();
		}
	});
	
	//댓글 수정 Modal 보이기
	$(document).on("click", ".active-edit", function(){
		var cNo = $(this).attr("comments_no");
		//console.log(cNo);
		var cContents = $(this).parent().children("p").text();
		//console.log(cContents);
		$("#modal_cContents").val(cContents);
		$("#updateCommentsBtn").attr("comments_no");
	})
	
	//댓글 수정
	$(document).on("click", "#updateCommentsBtn", function(e){
		commentsUpdateActionFunction(e);
		e.preventDefault();
	})
	
	
	//DOM tree 생성 후 포스트-댓글 수 나타내기
	postCommentsCount2($('.comment_list_click'));
});

