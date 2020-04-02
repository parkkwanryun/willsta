// 로그인 form 처리 

	/*
	 1. 로그인 정보를 컨트롤러로 text 형태( id / password value) 전달
	 */ 

$(function(){
	$(document).on('click','#member_login_action',function(e){
		/*
		var parameter = $(this).serialize();
		 */
		var parameter = "mId="+member_login_action.mId.value+"&mPass="+member_login_action.mPass.value;
		
		$.ajax({
			url: "sign_in_action",
			data:parameter,
			method:"POST",
			dataType:"text",
			async:false,
			success :function(textData){
				if(textData.trim()=="true"){
					alert('성공');
				}else if(textData.trim()=="false"){
					alert('실패');
				}
			}
		})
	});
	
	/*
	 2. id, password 유효성체크
	 */
	
	
	
	/*
	 	 
	 3. 자바 단에서 요청받은 컨트롤러에서의 세션 유무 체크 
	 */
	
});


/*
  3. 회원가입 
*/