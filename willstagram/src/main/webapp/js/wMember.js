// 로그인 form 처리 

	/*
	 1. 로그인 정보를 컨트롤러로 Json 형태로 전송? 
	 아니면 넣어준 id 와 password value 값만 ? 
	 컨트롤러로 요청
	 2. id, password 유효성체크
	 */ 

$(function(){
	$('#member_login_action').click(function(e){
		alert("회원가입");
	});
	
		var parameterArray = $('#member_login_action').serializeArray;
		var parameterArraytoString = $.param(parameterArray);

});


/*
  3. 회원가입 
*/