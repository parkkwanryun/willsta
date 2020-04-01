$(function(){
	//댓글 쓰기
	
	
	
	
	//댓글 보기
	//$(document).on("click", "div.job-status-bar a" );

});


/*********방명록 쓰기폼로드 ajax요청*****************/
function guest_insert_form_load_function() {
	$('#guest_list').load('guest_insert_form.html');
	/*
	$.ajax({
		url:'guest_insert_form.html',
		dataType:'html',
		mathod:'GET',
		success:function(htmlData){
			$('#guest_list').html(htmlData);
		}
	});
	*/
}



/*********방명록 쓰기*****************/
function guest_insert_action_function() {
	var paramStr = $("#guest_write_form").serialize();
	$.ajax({
		url: "guest/guest_insert_action.jsp",
		method: "POST",
		data: paramStr,
		dataType: "text",
		success: function(textData){
			if(textData.trim() == "true"){
				location.href = "guest.html";
			}else if(textData.trim() == "false"){
				alert("쓰기 실패");
				$("#guest_write_form #guest_name").select();
			}
		}
	});
}



/**방명록쓰기폼이벤트처리******/
$('#menu-d a').click(function(e) {
	guest_insert_form_load_function();
});