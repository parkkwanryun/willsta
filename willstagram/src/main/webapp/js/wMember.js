// 로그인 form 처리 

	/*
	 <<로그인>>
	  	1.id 와 password value 값 => 로그인 정보를 컨트롤러로 html 형태로 전송 (완료)
	    2.자바 단에서 요청받은 컨트롤러에서의 세션 유무 체크(Interceptor)(완료)
	 	3.session 유지 시간 세팅 (web.xml --> session 유효시간 = 1day ms) (완료)
	    3.로그인 시, id와 password 유효성 체크(validate) (글자 수 제한) (완료)
	    4.id/ password(없는 아이디, 틀린비밀번호 시) 안내문구 띄워주기
	    (jsp단에서 div msg 삽입 / javascript show, hide 이벤트처리)  (완료)
	      				(input text 삭제 시 warning 문구 삭제 처리) 
	    5.아이디 / 비밀번호 공백 불가 alert 안내 (완료)														
		6.비밀번호 찾기 (Forgot Password?) or 임시비밀번호 안내
		
		

	 <<회원가입>>
	 	1.회원가입 시, id와 password, email, name, phone 유효성 체크(validate)
	 	2.회원가입 이미지 업로드 / 중복된 아이디는 컨트롤러 필요?
	 	3.insert (이미지 업로드 / mRetire 체크 ON-> F 로 바꿀 것)
	    4.회원가입 시 체크박스 필수 체크 알림.
	    
	 <<회원정보수정&탈퇴>>  
	    1.DELETE / UPDATE 
	    (Profile-Account-Setting)
	 */ 



	/*
	 1)로그인 함수
	*/
	function member_login_action_function(){

		 var mlafArray = $('#member_login_action').serializeArray();	 
			$.ajax({
				url:'sign_in_action',
				method:'POST',
				data:mlafArray,
				dataType:'text',
				success : function(textData) {
					if (textData.trim() == "true") {
						alert(member_login_action.mId.value+'님 환영합니다.');
						location.href = '/willstagram/index';
					}else if (textData.trim() == "false1") {
						id_check();
					}else if(textData.trim() == "false2"){
						password_check();
					}
				}
			})
	}
	
	/*
	 2) Id, Password 체크 
	 */
	function id_check(){
		var mlafArray = $('#member_login_action').serializeArray();
			for (var i = 0; i < mlafArray.length; i++) {
				if(mlafArray[i].name!='mId' && mlafArray[i].name=='mPass'){
					$('#i-error').text('아이디를 다시 확인해주세요.').show();
					//validate 활용
					//$('#msg1').text('아이디를 다시 확인해주세요.')
					$('#i').focus();
				}
			}
		}	
	function password_check(){
		var mlafArray = $('#member_login_action').serializeArray();
		for (var i = 0; i < mlafArray.length; i++) {
			if(mlafArray[i].name!='mPass' && mlafArray[i].name=='mId'){
				$('#p-error').text('비밀번호가 틀렸습니다.').show();
				//$('#msg2').text('비밀번호가 틀렸습니다.').show();
				$('#p').focus();
			}
		}	
	}
	/*
	 3) 아이디, 비밀번호 공백 체크(로그인, 회원가입)
	 */
	function noSpaceForm(obj) { // 공백 사용 금지
	    var str_space = /\s/;  // 공백 체크
	    if(str_space.exec(obj.value)) { //공백 체크
	        alert("해당 항목에는 공백을 사용할수 없습니다.");
	        obj.focus();
	        obj.value = obj.value.replace(' ',''); // 공백제거
	        return false; 
	    }
	}

	/*
	 4) 체크박스 체크 
	 */
	
	/*
	function check_box_function(){
		   var count = $('input:checkbox[name=mRetire]:checked').length;
		    if(count > 0){
		        return true;
		    }else{
		        alert('check box select');
		        return false;
		    }
	}
	*/
	
	
/*
1)DOM Tree 로딩 후 이벤트 처리
*/
$(function() {
	$('#msg1').hide();
	$('#msg2').hide();
	
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
					required: "아이디를 입력해주세요",
					minlength: "아이디는 최소 {0}글자 이상입니다",
					maxlength: "아이디는 최대 {0}글자 이하입니다",
					//remote:	"{0} 는 중복된 아이디입니다."
				},
				mPass:{
					required: "비밀번호를 입력해주세요",
					minlength: "비밀번호는 최소 {0}글자 이상입니다",
					maxlength: "비밀번호는 최대 {0}글자 이하입니다"
				}
			},
			//유효성 통과 후 호출
			submitHandler:function(){
				$('#msg1').text('');	
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
						location.href = '/willstagram/sign_in';
					} 
			});
				e.preventDefault();
	})



		
