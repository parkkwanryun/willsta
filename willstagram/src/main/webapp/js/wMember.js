// 로그인 form 처리 

	/*
	 1. 로그인 정보를 컨트롤러로 Json 형태로 전송? 
	   OR  넣어준 id 와 password value 값만 전송? 
	 컨트롤러로 요청
	 2. id, password 유효성체크
	  자바 단에서 요청받은 컨트롤러에서의 세션 유무 체크(Interceptor) 
	 3. logout 시, login으로 버튼 바꿔주는 이벤트처리(show, hide)
	 */ 


function main_sign_out_function(){
		$.ajax({
			url:"sign_out_action",
			method:'POST',
			success: function(){
					$('#inner_sign_out a').show();
					$('#inner_sign_in a').hide();
			}
		});
}

$(function() {
	$(document).on(
			'submit',
			'#member_login_action',
			function(e) {
				/*
				 * var parameter = $(this).serialize();
				 */
				var parameter = "mId=" + member_login_action.mId.value	
						+ "&mPass=" + member_login_action.mPass.value;
				$.ajax({
					url : "sign_in_action",
					data : parameter,
					method : "POST",
					dataType : "text",
					success : function(textData) {
						if (textData.trim() == "true") {
							location.href = '/willstagram/index';
						} else if (textData.trim() == "false") {
							
						}
					}
				})
				e.preventDefault();
			});
	
	
	$('#inner_sign_out').on('click',function(e){ 
		main_sign_out_function();
		e.preventDefault();
	});
	
	
	
});
		
/*
  3. 회원가입 
*/