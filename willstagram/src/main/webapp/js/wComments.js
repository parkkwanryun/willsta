//document ready
$(function() {
	// 댓글 쓰기
	$("#comment-insert-button").click(function(e) {
		var contentValue = $("#comment-cContent").val();
		var paramStr = $("#comment-insert-form").serialize();
		$.ajax({
			url : "commentsInsertAction",
			data : paramStr,
			method : "POST",
			dataType : "text",
			success : function(textData) {
				if (textData.trim() == "true") {
					alert("contentValue: "+contentValue);
				} else if (textData.trim() == "false") {
					alert("쓰기 실패");
					$("#comment-insert-form #comment-cContent").select();
				}
			}
		});
	});
	
	
	
	
});
