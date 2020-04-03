//document ready
$(function() {
	// 댓글 쓰기
	$(document).on("click", "#comment-insert-button", function(e) {
		var paramStr = $("#comment-insert-form").serialize();
		$.ajax({
			url : "commentsInsertAction",
			data : paramStr,
			method : "POST",
			dataType : "html",
			success : function(resultText) {
				$("div.comment-sec").append(resultText);
			}
		});
		e.preventDefault();
	});
	
	//포스트-댓글 전체 보이기
	$(document).on("click", "#comment_list_click", function(e){
		//alert("나와라");
		$.ajax({
			url : "postCommentsList",
			method : "GET",
			dataType : "json",
			success : function(jsonArray) {
				console.log(jsonArray);
			}
		})
		e.preventDefault();
	})
	
});
