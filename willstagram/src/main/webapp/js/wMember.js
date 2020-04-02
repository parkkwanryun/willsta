// 로그인 form 처리 

	/*
	 1. 로그인 정보를 컨트롤러로 Json 형태로 전송? 
	   OR  넣어준 id 와 password value 값만 전송? 
	 컨트롤러로 요청
	 2. id, password 유효성체크
	 3. 자바 단에서 요청받은 컨트롤러에서의 세션 유무 체크 
	 */ 




	
$(function(){
	$(document).on('click','#member_login_action',function(e){
		/*
		var parameter = $(this).serialize();
		 */
		var parameter = "mId="+member_login_action.mId.value+"&mPass="+member_login_action.mPass.value;
		
		$.ajax({
			url: "sign_in_action",
			data: parameter,
			method: "POST",
			dataType:"text",
			success :function(textData){
				if(textData.trim()=="true"){
					
				}else if(textData.trim()=="false"){
					
				}
			}
		})
			
	});
});


/*
  3. 회원가입 
*/