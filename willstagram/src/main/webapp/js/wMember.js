// 로그인 form 처리 

/*
 <<로그인>>
 (4/1~4/8)
 1.id 와 password value 값 => 로그인 정보를 컨트롤러로 html 형태로 전송 (완료)
 2.자바 단에서 요청받은 컨트롤러에서의 세션 유무 체크(Interceptor)(완료)
 3.session 유지 시간 세팅 (web.xml --> session 유효시간 = 1day ms) (완료)
 3.로그인 시, id와 password 유효성 체크(validate) (글자 수 제한) (완료)
 4.id/ password(없는 아이디, 틀린비밀번호 시) 안내문구 띄워주기
 (jsp단에서 div msg 삽입 / javascript show, hide 이벤트처리) 
 (input text 삭제 시 warning 문구 삭제 처리)  (완료)
 5.아이디 / 비밀번호 공백 불가 조치 (완료)														
 6.Forgot Password 버튼 위치 조정 (그리드) (완료)
 7.비밀번호 찾기 (Forgot Password?)(완료) 
 8.비밀번호 틀렸을 시 validate 안뜸 (완료)	

 <<회원가입>> 
 (~4/14)
 1.회원가입 시, id와 password, email, name, phone 유효성 체크(validate) 
 - 유효성 체크 중, 아이디 중복 검사 (완료) : Talend ApI check 이용
 2.회원가입 이미지 업로드 (4/20)(완료)

 <<회원정보수정&탈퇴>> 
 (~4/14)
 1.UPDATE 
 - 회원 정보 수정 시 유효성 체크(validate) (완료)
 - 이미지만 별도 업로드 처리/ alert 안내문구 처리(완료)
 - 회원 정보 수정 시 이미지 초기화 문제 처리(완료)
 - 비밀번호 찾기 (Forgot Password?)(완료)
  
 (~4/20)
 2.DELETE& UPDATE(mRetire=>off / mRetire=>on) 
 계정 비활성화 (완료)
- 계정 비활성화 완료시키기(mRetire = off)(완료)
- 계정 비활성화 : mRetire 체크(delete 매퍼의 컬럼 추가) (완료)
- 활성화 창(view) 추가 (완료)
- 비활성화 계정으로 로그인 시 계정활성화 창 띄워주기 (완료) 
- 활성화 처리할 mapper, dao,서비스,컨트롤러 만들기(완료)
- 활성화 후 로그인 창으로 이동시키기.(완료)


 <<추가 사항 - 추후 구현>>
 <<네이버 아이디 로그인>>
 <<관리자모드, 공지사항 게시판>>

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
				location.href = '/willstagram/main_post';
			} else if (textData.trim() == "false1") {
				alert('아이디를 다시 확인해주세요');
				id_check();
			} else if (textData.trim() == "false2") {
				alert('비밀번호를 다시 확인해주세요');
				password_check();
			} else if (textData.trim() == "false3"){
				alert('비활성화된 계정입니다. 활성화 상태창으로 이동합니다.');
				location.href='/willstagram/account_on';
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
			$('#i').focus();
		}
	}
}
function password_check() {
	var mlafArray = $('#member_login_action').serializeArray();
	for (var i = 0; i < mlafArray.length; i++) {
		if (mlafArray[i].name != 'mPass' && mlafArray[i].name == 'mId') {
			$('#p-error').text('비밀번호가 틀렸습니다.').show();
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
			} else if (textData.trim() == "false") {

			}

		}
	});
	e.preventDefault();
}
/*
 * 4) 회원정보 수정 함수(이미지x)
 */
function account_setting() {
	var asArray = $('#member_modify_action').serializeArray();
	$.ajax({
		url : 'account-setting',
		method : 'POST',
		data : asArray,
		dataType : 'text',
		success : function(textData) {
			if (textData.trim() == "true") {

				member_modify_action.mId.value = textData.mId;
				member_modify_action.mName.value = textData.mName;
				member_modify_action.mPass.value = textData.mPass;
				member_modify_action.mEmail.value = textData.mEmail;
				member_modify_action.mPhone.value = textData.mPhone;

				location.href = '/willstagram/main_post';
			} else {

			}
		}
	});
}

/*
 * 5) 회원 이미지 수정 함수 - enctype: multipart로 지정해주지 않으면 controller로 파일을 보낼 수 없음 -
 * contentType : false 로 선언 시 content-type 헤더가 multipart/form-data로 전송되게 함 -
 * processData : false로 선언 시 formData를 string으로 변환하지 않음 - formData : 해당 폼의 모든
 * 값들(file포함)을 해당 객체에 한번에 담아 보내기 위해 사용
 */
function account_img_setting() {
	var formData = new FormData();

	var aisArray = $('#member_img_modify_action').serializeArray();
	for (var i = 0; i < aisArray.length; i++) {
		formData.append(aisArray[i].name, aisArray[i].value);
	}

	var inputFile = $("input[name='uploadImg']");
	var files = inputFile[0].files;
	for (var i = 0; i < files.length; i++) {
		formData.append("uploadImg", files[i]);
	}
	$.ajax({
		url : 'account_img_setting',
		method : 'POST',
		data : formData,
		processData : false,
		contentType : false,
		dataType : 'text',
		success : function(textData) {
			if (textData.trim() == "true") {
				alert('프로필 이미지 업로드 완료');
			}else {
				alert('이미지 삽입 실패');
			}
		}
	});
}
/*
 * 7) 회원 탈퇴
 */
function member_retire() {
	var mrArray = $('#member_retire_action').serializeArray();
	$.ajax({
		url : 'member_retire',
		method : 'POST',
		data : mrArray,
		dataType : 'text',
		success : function(textData) {
			if (textData.trim() == "true") {
				alert('계정을 비활성화 합니다. 활성화시키려면 다시 로그인 하세요');
				location.href = '/willstagram/sign_in';
			} else if (textData.trim() == "false") {
				alert('계정 비활성화 실패');
				location.href = '/willstagram/profile-account-setting';
			}
		}
	})
}
/*
 8) 계정 활성화
 */
function member_account_on_action(){
	var maArray = $('#member_account_on_action').serializeArray();
	$.ajax({
		url : 'member_account_on_action',
		method : 'POST',
		data : maArray,
		dataType : 'text',
		success : function(textData) {
			if (textData.trim() == "true") {
				alert('계정이 활성화 되었습니다. 로그인 하세요');
				location.href = '/willstagram/sign_in';
			} else if (textData.trim() == "false") {
				alert('계정 활성화 실패');
				location.href = '/willstagram/account_on';
			}
		}
	})
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
			mId : {
				required : "아이디를 입력해주세요",
				minlength : "아이디는 최소 {0}글자 이상입니다",
				maxlength : "아이디는 최대 {0}글자 이하입니다",
			},
			mPass : {
				required : "비밀번호를 입력해주세요",
				minlength : "비밀번호는 최소 {0}글자 이상입니다",
				maxlength : "비밀번호는 최대 {0}글자 이하입니다"
			}
		},
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
			mRetire :{
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
			mRetire : {
				required : "약관에 동의해주세요",
			}
		},
		submitHandler : function() {
			member_register_action_function();
		},
		errorClass : "error",
		validClass : "valid"
	});

	// 회원 정보 수정(이미지 제외) 유효성 검증
	$('#member_modify_action').validate({
		rules : {
			mPass : {
				required : true,
				rangelength : [ 1, 10 ],
				maxlength : 10
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
			}
		},
		messages : {
			mPass : {
				required : "비밀번호를 입력해주세요",
				rangelength : "비밀번호는 1글자 이상 10글자 이내 입니다"
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
			}
		},
		submitHandler : function() {
			account_setting();
		},
		errorClass : "error",
		validClass : "valid"
	});

	// 회원 이미지 수정 시 유효성 검증
	$('#member_img_modify_action').validate({
		rules : {
			mImage : {
				required : true
			}
		},
		messages : {
			mImage : {
				required : "프로필 이미지를 업로드해주세요",
			}
		},
		submitHandler : function() {
			account_img_setting();
		},
		errorClass : "error",
		validClass : "valid"
	});
	
	// 계정 비활성화 시 유효성 검증
	$('#member_retire_action').validate({
		rules : {
			mEmail : {
				required : true
			},
			mPass : {
				required : true,
				remote : {
					url : "pw_Check",
					method : "GET",
					type : "text",
					data : {
						mPass : function() {
							return $('#mPass').val();
						}
					}
				}
			},
			mRetire : {
				required : true
			}
		},
		messages : {
			mEmail : {
				required : "이메일을 입력해주세요"
			},
			mPass : {
				required : "비밀번호를 입력해주세요",
				remote : " 비밀번호가 일치하지 않습니다."
			},
			mRetire : {
				required : "계정 비활성화 약관에 동의하여 주십시오"
			}
		},
		submitHandler : function() {
			member_retire();
		},
		errorClass : "error",
		validClass : "valid"
	});
	
	// 계정 활성화 시 유효성 검증
	$('#member_account_on_action').validate({
		rules : {
			mEmail : {
				required : true
			},
			mRetire : {
				required : true
			}
		},
		messages : {
			mEmail : {
				required : "이메일을 입력해주세요"
			},
			mRetire : {
				required : "계정 활성화 약관에 동의하여 주십시오"
			}
		},
		submitHandler : function() {
			member_account_on_action();
		},
		errorClass : "error",
		validClass : "valid"
	});
})
