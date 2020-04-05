// 로그인 form 처리 

	/*
	 1. id 와 password value 값 => 로그인 정보를 컨트롤러로 html 형태로 전송 (완료)
	 
	 2. id, password 유효성 체크
	  자바 단에서 요청받은 컨트롤러에서의 세션 유무 체크(Interceptor)  => id/ password 틀릴 시 안내문구 띄워주기(jsp)
	  
	 3. session 유지 시간 세팅 
	 
	 4. 회원가입
	 */ 

	/*
	  회원가입 
	*/

	
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
							alert(member_login_action.mId.value+'님 환영합니다.');
							location.href = '/willstagram/index';
						} else if (textData.trim() == "false") {

						}
					}
				})
				e.preventDefault();
			}
			
	)

		
	$(document).on(
			'submit',
			'#member_register_action',
			function(e) {
				var parameter = "mId=" + member_register_action.mId.value
						+ "&mPass=" + member_register_action.mPass.value
						+ "&mName=" + member_register_action.mName.value
						+ "&mEmail=" + member_register_action.mEmail.value
						+ "&mPhone=" + member_register_action.mPhone.value
						+ "&mImage=" + member_register_action.mImage.value;
				$.ajax({
					url : 'sign_up_action',
					data : parameter,
					method : 'POST',
					dataType : 'text',
					success : function(textData) {
						if (textData.trim() == "true") {
							alert(member_register_action.mId.value
									+ '님 회원가입을 축하드립니다.');
							location.href = 'willstagram/index';
						} else if (textData.trim() == "false") {
							location.href = 'willstagram/sign_in';
						}
					}
				});
				e.preventDefault();
			})
});

		
