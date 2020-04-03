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
				var html = "";
				$.each(jsonArray, function(i, jsonObject){
					jsonObject = jsonArray[i];
					var cNo = jsonObject.cNo;
					var pNo = jsonObject.pNo;
					var mId = jsonObject.mId;
					var cContents = jsonObject.cContents;
					var cTime = jsonObject.cTime;
					html += "<ul>" +
							"	<li>" +
							"		<div class='comment-list'>" +
							"			<div class='comment'>" +
							"				<h3>"+mId+"</h3>" +
							"				<span><img src='images/clock.png' alt=''>"+cTime+"</span>" +
							"				<p>"+cContents+"</p>" +
							"				<a href='#' title='' class='active'><i class='fa fa-reply-all'></i>Reply</a>" +
							"			</div>" +
							"		</div>]" +
							"	</li>" +
							"</ul>";
				}); 
				
			}
		})
	
	})
	
});
