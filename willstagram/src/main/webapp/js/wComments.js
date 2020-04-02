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
				$("div.comment-section").append(resultText);
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
				/*
				var html = "";
				$.each(jsonArray, function(i, jsonObject){
					jsonObject = jsonArray[i];
					var guest_no = jsonObject.guest_no;
					var guest_title = jsonObject.guest_title;
					html += "<div class='guest_item'>"+
							"	<h3 class='guest_title'  guest_no='"+guest_no+"'><a href=''>"+guest_title+"[JSON]</a></h3>"+
							"</div>";
				}); 
				$("#guest_list").html(html);
					*/
			}
		})
	
	})
	
});
