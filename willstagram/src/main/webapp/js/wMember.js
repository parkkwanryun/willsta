// 로그인 form 처리 

/*
 <<로그인>>(4/1~4/8)
 1.id 와 password value 값 => 로그인 정보를 컨트롤러로 html 형태로 전송 (완료)
 2.자바 단에서 요청받은 컨트롤러에서의 세션 유무 체크(Interceptor)(완료)
 3.session 유지 시간 세팅 (web.xml --> session 유효시간 = 1day ms) (완료)
 3.로그인 시, id와 password 유효성 체크(validate) (글자 수 제한) (완료)
 4.id/ password(없는 아이디, 틀린비밀번호 시) 안내문구 띄워주기
 (jsp단에서 div msg 삽입 / javascript show, hide 이벤트처리) 
 (input text 삭제 시 warning 문구 삭제 처리)  (완료)
 5.아이디 / 비밀번호 공백 불가 조치 (완료)														
 6.Forgot Password 버튼 위치 조정 (그리드) (완료)
 
 7.비밀번호 찾기 (Forgot Password?) or 임시비밀번호 안내 


 <<회원가입>> (~4/12)
 1.회원가입 시, id와 password, email, name, phone 유효성 체크(validate) 
 - 유효성 체크 중, 아이디 중복 검사 (완료) : Talend ApI check 이용
 
 2.회원가입 시 체크박스(mRetire 체크 ON-> F) 필수 체크 알림. 
 3.회원가입 이미지 업로드 (4/12)


 <<회원정보수정&탈퇴>> (~4/14)
 1.DELETE / UPDATE 
 (Profile-Account-Setting) 

 <<네이버 아이디 로그인>>
 */

/*
 1)로그인
 */
function member_login_action_function() {

	var mlafArray = $('#member_login_action').serializeArray();
	$.ajax({
		url : 'sign_in_action',
		method : 'POST',
		data : mlafArray,
		dataType : 'text',
		success : function(textData) {
			if (textData.trim() == "true") {
				location.href = '/willstagram/index';
			} else if (textData.trim() == "false1") {
				id_check();
			} else if (textData.trim() == "false2") {
				password_check();
			}
		}
	})
}
/*
 * 2) Id, Password 체크
 */
function id_check() {
	var mlafArray = $('#member_login_action').serializeArray();
	for (var i = 0; i < mlafArray.length; i++) {
		if (mlafArray[i].name != 'mId' && mlafArray[i].name == 'mPass') {
			$('#i-error').text('아이디를 다시 확인해주세요.').show();
			// validate 활용
			// $('#msg1').text('아이디를 다시 확인해주세요.')
			$('#i').focus();
		}
	}
}
function password_check() {
	var mlafArray = $('#member_login_action').serializeArray();
	for (var i = 0; i < mlafArray.length; i++) {
		if (mlafArray[i].name != 'mPass' && mlafArray[i].name == 'mId') {
			$('#p-error').text('비밀번호가 틀렸습니다.').show();
			// $('#msg2').text('비밀번호가 틀렸습니다.').show();
			$('#p').focus();
		}
	}
}
/*
 * 3) 회원가입
 */
function member_register_action_function() {
	var mrafArray = $('#member_register_action').serializeArray();
	$.ajax({
		url : 'sign_up_action',
		data : mrafArray,
		method : 'POST',
		dataType : 'text',
		success : function(textData) {
			if (textData.trim() == "true") {
				member_register_action.mId.value = textData.mId;
				member_register_action.mPass.value = textData.mPass;
				member_register_action.mName.value = textData.mName;
				member_register_action.mEmail.value = textData.mEmail;
				member_register_action.mPhone.value = textData.mPhone;
				member_register_action.mImage.value = textData.mImage;
				member_register_action.mRetire.value = textData.mRetire;

				location.href = '/willstagram/sign_in';

				// profile account setting으로 위 회원정보 데이터를 전송할 $.ajax({}); 만들기
			} else if (textData.trim() == "false") {
				alert('회원가입 실패');
			}
			/*
			 */
		}
	});
	e.preventDefault();
}
/*
 * 4) 회원가입 체크박스 체크
 */
/*
 * function check_box_function(){ var count =
 * $('input:checkbox[name=mRetire]:checked').length; if(count > 0){ return true;
 * }else{ alert('약관에 동의하여 주십시오'); return false; } }
 */


/*
   5) Account Setting 
 */
function account_setting(){
	var asArray = $('#member_register_action').serializeArray();
}






/*
 * &&DOM Tree 로딩 후 이벤트 처리&&
 */
$(function() {
	$('#msg1').hide();
	$('#msg2').hide();

	// 로그인 유효성 검증
	$('#member_login_action').validate({

		rules : {
			mId : {
				required : true,
				minlength : 3,
				maxlength : 10
			},
			mPass : {
				required : true,
				minlength : 1,
				maxlength : 10
			},
		},
		messages : {
			mId : {// {0} is a duplicate ID : 컨트롤러 작성필요?
				required : "아이디를 입력해주세요",
				minlength : "아이디는 최소 {0}글자 이상입니다",
				maxlength : "아이디는 최대 {0}글자 이하입니다",
			// remote: "{0} 는 중복된 아이디입니다."
			},
			mPass : {
				required : "비밀번호를 입력해주세요",
				minlength : "비밀번호는 최소 {0}글자 이상입니다",
				maxlength : "비밀번호는 최대 {0}글자 이하입니다"
			}
		},
		// 유효성 통과 후 호출
		submitHandler : function() {
			$('#msg1').text('');
			member_login_action_function();
		},
		errorClass : "error",
		validClass : "valid"
	});

	// 회원가입 유효성 검증
	$('#member_register_action').validate({
		rules : {
			mId : {
				required : true,
				rangelength : [ 3, 10 ],
				remote : {
					url : "duplicate_check",
					method : "GET",
					type : "text",
					data : {
						mId : function() {
							return $('#mId').val();
						}
					}
				}
			},
			mPass : {
				required : true,
				rangelength : [ 1, 10 ],
				maxlength : 10
			},
			mName : {
				required : true,
				rangelength : [ 2, 10 ]

			},
			mEmail : {
				required : true,
				email : true
			},
			mPhone : {
				required : true,
				minlength : 9,
				digits : true

			},
			mImage : {
				required : true
			},
			mRetire : {
				required : true
			}
		},
		messages : {
			mId : {
				required : "아이디를 입력해주세요",
				rangelength : "아이디는 3글자 이상 10글자 이내 입니다",

				remote : "{0}는 이미 존재하는 아이디입니다.",
			},
			mPass : {
				required : "비밀번호를 입력해주세요",
				rangelength : "비밀번호는 1글자 이상 10글자 이내 입니다"
			},
			mName : {
				required : "이름을 입력해주세요",
				rangelength : "이름은 최소 2글자 이상 10글자 이내 입니다",
			},
			mEmail : {
				required : "이메일을 입력해주세요",
				email : "올바른 형식이 아닙니다 - bluepk2034@naver.com"
			},
			mPhone : {
				required : "휴대폰 번호를 입력해주세요",
				digits : "-을 제외한 숫자만 입력해주세요",
				minlength : "전화번호는 최소 9자리 이상입니다."
			},
			mImage : {
				required : "프로필 이미지를 업로드해주세요",
			},
			mRetire : {
				required : "약관에 동의해주세요",
			}
		},
		submitHandler : function() {
			alert('다음은 회원가입 액션');
			member_register_action_function();
		},
		errorClass : "error",
		validClass : "valid"
	});
})
