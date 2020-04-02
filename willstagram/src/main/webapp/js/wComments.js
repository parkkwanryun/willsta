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
			success : function(html) {
			}
		});
	});
	
	
	
	
});
