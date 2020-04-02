//document ready
$(function() {
	// 댓글 쓰기
	$(document).on("submit", "#comment-insert-form", function(e){
		var formData = new FormData();
		
		var paramArray = $(this).serializeArray();
		
		for (var i = 0; i < paramArray.length; i++) {
			formData.append(paramArray[i].name)
		}
		
		
	});
		
});


