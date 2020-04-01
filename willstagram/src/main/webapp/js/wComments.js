//document ready
$(function() {
	// 댓글 쓰기
	$("#comment-insert-button").click(function(e) {
		var paramStr = $("#comment-insert-form").serialize();
		$.ajax({
			url : "commentsInsertAction",
			data : paramStr,
			method : "POST",
			dataType : "text",
			success : function(textData) {
				if (textData.trim() == "true") {
					alert("쓰기 성공");
				} else if (textData.trim() == "false") {
					alert("쓰기 실패");
					$("#comment-insert-form #comment-content").select();
				}
			}
		});
		e.preventDefault();
	});
	
	
	
	//댓글 내역 보기
	$("div.comment-section").on("click", "a.com", function(e){
		var $comment = $(e.target).parents("div.comment-sec");
		var params = "cNo="+$comment.attr()
		
		
		
		
	});
});


