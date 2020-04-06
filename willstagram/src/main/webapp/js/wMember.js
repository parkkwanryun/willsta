// 로그인 form 처리 

	/*
	 1. 로그인
	  	id 와 password value 값 => 로그인 정보를 컨트롤러로 html 형태로 전송 (완료)
	 
	 2. id, password 유효성 체크(validate)
	  자바 단에서 요청받은 컨트롤러에서의 세션 유무 체크(Interceptor)  => id/ password 틀릴 시 안내문구 띄워주기(jsp)
	  
	 3. session 유지 시간 세팅 (web.xml --> session 유효시간 = 1day ms) (완료)
	 
	 4. 회원가입 (이미지 업로드 남음)
	 	insert (이미지 업로드 / mRetire 체크 ON-> F 로 바꿀 것)
	 
	 5. 회원정보 탈퇴&수정
	    DELETE / UPDATE 
	    (Profile-Account-Setting)
	 */ 



	
$(function() {
	/*
	 로그인
	*/
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
	/*
	  회원가입 
	*/

	$(document).on(
			'submit',
			'#member_register_action',
			function(e) {
				var params = "mId=" + member_register_action.mId.value
						+ "&mPass=" + member_register_action.mPass.value
						+ "&mName=" + member_register_action.mName.value
						+ "&mEmail=" + member_register_action.mEmail.value
						+ "&mPhone=" + member_register_action.mPhone.value
						+ "&mImage=" + member_register_action.mImage.value
						+ "&mRetire="+ member_register_action.mRetire.value;
				$.ajax({
					url : 'sign_up_action',
					data : params,
					method : 'POST',
					dataType : 'json',
					success : function(jsonObject) {
						member_register_action.mId.value = jsonObject.mId;
						member_register_action.mPass.value = jsonObject.mPass;
						member_register_action.mName.value = jsonObject.mName;
						member_register_action.mEmail.value = jsonObject.mEmail;
						member_register_action.mPhone.value = jsonObject.mPhone;
						member_register_action.mImage.value = jsonObject.mImage;
						member_register_action.mRetire.value = jsonObject.mRetire;
						if (jsonObject.trim() == "true") {
							alert(member_login_action.mId.value+'님 환영합니다.');
							location.href = '/willstagram/sign_in';
						} else if (jsonObject.trim() == "false") {
						}
						location.href = 'willstagram/index';
					} 
			});
				e.preventDefault();
	})

});

		
