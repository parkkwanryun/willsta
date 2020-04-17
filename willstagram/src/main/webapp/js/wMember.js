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

 <<회원가입>> 
 (~4/14)
 1.회원가입 시, id와 password, email, name, phone 유효성 체크(validate) 
 - 유효성 체크 중, 아이디 중복 검사 (완료) : Talend ApI check 이용
 2.회원가입 이미지 업로드 (4/14)

 <<회원정보수정&탈퇴>> 
 (~4/14)
 1.UPDATE 
 - 회원 정보 수정 시 유효성 체크(validate) (완료)
 - 비밀번호 찾기 (Forgot Password?)
 2.DELETE 
 회원 탈퇴


(회원 탈퇴/비밀번호 찾기/이미지 업로드) 


 <<추가 사항>>
 <<네이버 아이디 로그인>>
 <<관리자모드, 공지사항 게시판>>
 <<국제화>>
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
 - enctype: multipart로 지정해주지 않으면 controller로 파일을 보낼 수 없음
 - contentType : false 로 선언 시 content-type 헤더가 multipart/form-data로 전송되게 함
 - processData : false로 선언 시 formData를 string으로 변환하지 않음
 - formData : 해당 폼의 모든 값들(file포함)을 해당 객체에 한번에 담아 보내기 위해 사용
 */
function member_register_action_function() {
	alert('회원가입');
	/*
	var mrafArray = $('#member_register_action').serializeArray();
	var formData = new FormData(mrafArray);
	
	for(var i = 0; i < mrafArray.length; i++){
		formData.append(mrafArray[i].name, mrafArray[i].value); // key value 형태
	}
	 */

	var formData = new FormData();
	formData.append('mId',$('#mId').val());
	formData.append('mPass',$('#mPass').val());
	formData.append('mName',$('#mName').val());
	formData.append('mEmail',$('#mEmail').val());
	formData.append('mPhone',$('#mPhone').val());
	formData.append('mRetire',$('#mRetire').val());

	/*
	alert(mrafArray[0].name,mrafArray[0].value);
	alert(mrafArray[1].name,mrafArray[1].value);
	alert(mrafArray[2].name,mrafArray[2].value);
	alert(mrafArray[3].name,mrafArray[3].value);
	alert(mrafArray[4].name,mrafArray[4].value);
	alert(mrafArray[5].name,mrafArray[5].value);
	alert(mrafArray[6].name,mrafArray[6].value); 
	*/
	// mImage 제외 모든 value 값들 받음 체크.
	
	var inputFile = $("input[name='mImage']");
	var files = inputFile[0].files;
	for(var i = 0; i < files.length; i++){
		formData.append("mUploadImg",mImage[i]);
	}
	console.log(formData);
	
	$.ajax({
		url : 'sign_up_action',
		processData: false,
        contentType: false,
        data : formData,
        cache: false,
        method: 'POST',
		dataType : 'json',
		success : function(jsonData) {
			alert("complete");
			//console.log(jsonData);

			if (jsonData.trim() == "true") {
				member_register_action.mId.value = jsonData.mId;
				member_register_action.mPass.value = jsonData.mPass;
				member_register_action.mName.value = jsonData.mName;
				member_register_action.mEmail.value = jsonData.mEmail;
				member_register_action.mPhone.value = jsonData.mPhone;
				member_register_action.mUploadImg.value = jsonData.mUploadImg;
				member_register_action.mRetire.value = jsonData.mRetire;

				location.href = '/willstagram/sign_in';

			} else if (jsonData.trim() == "false") {
			}

		},
		error : function(e){
			console.log("ERROR :", e);
			$('#submit').prop("disabled",false);
			alert('fail');
		}
	});

}
/*
 * 4) 회원정보 수정 함수
 * 
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
				member_modify_action.mImage.value = textData.mImage;
				
				location.href = '/willstagram/main_post';
			} else {
				alert('회원수정 실패2');
			}
		}
	});
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
			mUploadImg : {
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
			mUploadImg : {
				required : "프로필 이미지를 업로드해주세요",
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

	// 회원 정보 수정 시 유효성 검증
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
})
