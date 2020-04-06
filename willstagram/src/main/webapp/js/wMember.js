// 로그인 form 처리 

	/*
	 <<로그인>>
	  	1.id 와 password value 값 => 로그인 정보를 컨트롤러로 html 형태로 전송 (완료)
	    2.자바 단에서 요청받은 컨트롤러에서의 세션 유무 체크(Interceptor)(완료)
	 	3.session 유지 시간 세팅 (web.xml --> session 유효시간 = 1day ms) (완료)
	    3.로그인 시, id와 password 유효성 체크(validate) (글자 수 제한) (완료)
	    4.id/ password 틀릴 시 안내문구 띄워주기(jsp단에서 div msg 삽입)  

	 <<회원가입>>
	 	1.회원가입 시, id와 password, email, name, phone 유효성 체크(validate)
	 	2.회원가입 이미지 업로드 / 중복된 아이디는 컨트롤러 필요?
	 	3.insert (이미지 업로드 / mRetire 체크 ON-> F 로 바꿀 것)
	  
	 <<회원정보수정&탈퇴>>  
	    1.DELETE / UPDATE 
	    (Profile-Account-Setting)
	 */ 



	/*
	 2)로그인 함수
	*/
	function member_login_action_function(e){
		 var mlaf = $('#member_login_action').serialize();
			$.ajax({
				url:'sign_in_action',
				method:'POST',
				data:mlaf,
				dataType:'text',
				success : function(textData) {
					if (textData.trim() == "true") {
						console.log('text!!');
						alert(member_login_action.mId.value+'님 환영합니다.');
						location.href = '/willstagram/index';
					} else if (textData.trim() == "false") {
						$('#msg1').html('아이디를 확인하십시오.').css('color','red')
						$('#msg2').html('비밀번호를 확인하십시오.').css('color','red')
					}
				}
			})
			e.preventDefault();
	}
/*
1)DOM Tree 로딩 후 이벤트 처리
*/
$(function() {
	  //로그인 유효성 검증 (validate function)
	$('#member_login_action').validate({
		rules:{
			mId:{
				required:true,
				minlength: 3,
				maxlength:10,
			},
			mPass:{
				required:true,
				minlength: 1,
				maxlength: 10
			},
		},
			messages:{
				mId:{//{0} is a duplicate ID : 컨트롤러 작성필요?
					required: "Please check your Id",
					minlength: "Please write Id more than {0} characters",
					maxlength: "Please write Id less than {0} characters",
					remote:	"{0} 는 중복된 아이디입니다."
				},
				mPass:{
					required: "Please check your password",
					minlength: "Please write Password more than {0} characters",
					maxlength: "Please write Password more than {0} characters"
				}
			},
			//유효성 통과 후 호출
			submitHandler:function(){
				member_login_action_function();
			},
			errorClass:"error",
			validClass:"valid"
	});
})	
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
						/*
						if (jsonObject.trim() == "true") {
							alert(member_login_action.mId.value+'님 환영합니다.');
							location.href = '/willstagram/sign_in';
						} else if (jsonObject.trim() == "false") {
						}
						*/
						location.href = 'willstagram/index';
					} 
			});
				e.preventDefault();
	})



		
