/*
 * 소켓 관련 함수 & 메세지 함수 자바스크립트
 */
// DOM TREE 생성 후 connetWS 실행
var socket = null;
var loginId = null;
var contextPath = getContextPath();
var jsonData = {
		mId : null,
		mIdYou : null,
		msg : null,
		msgDate : null,
		dmNo : null,
		dmContentsImage : null
};

function getContextPath(){
	var lastIndexCount = location.href.lastIndexOf('/');
	var ctx = location.href.substr(0,lastIndexCount).replace('http', 'ws');
	return ctx;
}
// 접속중인 본인 아이디 얻기
function getLoginId(){
	$.ajax({
		url:'sessionCheck',
		method:'POST',
		dataType: 'text',
		success:function(mId){
			loginId = mId; 
		}
	});
}
// 메시지 채팅창 출력 콜백함수
function message_send_form(target){
	mIdYou = target.find('h3').text();
	var htmlData = "";
	htmlData +="<div class='message-bar-head'>";
	htmlData +="	<div class='usr-msg-details'>";
	htmlData +=			"<div class='usr-ms-img'>";
	htmlData +=				"<img src='' alt=''>";
	htmlData +=			"</div>";
	htmlData +=		"<div class='usr-mg-info'>";
	htmlData +=			"<h3>"+mIdYou+"</h3>";
	htmlData +=			"<p>Online</p>";
	htmlData +=		"</div>";
	htmlData +=	"</div>";
	htmlData +=	"<a href='#' title=''><i class='fa fa-ellipsis-v'></i></a>";
	htmlData +=	"</div>";
	htmlData +=	"<div class='messages-line' id = 'messageContents' style='overflow:auto'>";
	htmlData +=	"</div>";
	htmlData +=	"<div class='message-send-area'>";
	htmlData +=		"<form>";
	htmlData +=			"<div class='mf-field'>";
	htmlData +=			"<input type='text' id='msg' placeholder='Type a message here'>";
	htmlData +=			"<button type='submit' id='btnSend'>Send</button>";
	htmlData +=			"</div>";
	htmlData +=			"<ul>";
	htmlData +=				"<li><a href='#' title=''><i class='fa fa-smile-o'></i></a></li>";
	htmlData +=				"<li><a href='#' title=''><i class='fa fa-camera'></i></a></li>";
	htmlData +=				"<li><a href='#' title=''><i class='fa fa-paperclip'></i></a></li>";
	htmlData +=			"</ul>";
	htmlData +=		"</form>";
	htmlData +=	"</div>";
	htmlData +=	"</div>";
	$('.main-conversation-box').append(htmlData);
}

// 메시지 송신시 채팅창에 출력하는 콜백함수
function message_leftInsert_html(jsonData){
	var htmlData ="";
	htmlData +=	"<div class='main-message-box st3'>";
	htmlData +=		"<div class='message-dt st3'>";
	htmlData +=			"<div class='message-inner-dt'>";
	htmlData +=				"<p>"+jsonData.msg+"</p>";
	htmlData +=			"</div>";
	htmlData +=			"<span>"+jsonData.msgDate+"분</span>";
	htmlData +=		"</div>";
	htmlData +=		"<div class='messg-usr-img'>";
	htmlData +=			"<img src='contents/member_image/"+jsonData.dmContentsImage+"' alt=''>"
	htmlData +=		"</div>";
	htmlData +=	"</div>";
	$('.messages-line').append(htmlData);
	$('#messageContents').scrollTop($('#messageContents').prop('scrollHeight'));
}
// 메시지 수신시 채팅창에 출력하는 콜백함수
function message_rightInsert_html(jsonData){
	var htmlData ="";
	htmlData +=	"<div class='main-message-box'>";
	htmlData +=      "<div class='ta-right'>";
	htmlData +=				"<div class='message-inner-dt'>";
	htmlData +=					"<p style='width:auto'>"+jsonData.msg+"</p>";
	htmlData +=				"</div>";
	htmlData +=					"<p style='float:right;'>"+jsonData.msgDate+"분</p>";
	htmlData +=				"</div>";
	htmlData +=		"<div class='messg-usr-img' >";
	htmlData +=			"<img src='contents/member_image/"+jsonData.dmContentsImage+"' alt=''>";
	htmlData +=		"</div>";
	htmlData +=	"</div>";
	$('.messages-line').append(htmlData);
	$('#messageContents').scrollTop($('#messageContents').prop('scrollHeight'));
}

// 메시지 전송 버튼 클릭 시 작동하는 콜백함수
function message_send_function(target){
	$('#btnSend').on('click', function(event) {
		event.preventDefault();
		var d = new Date();
		//jsonData 만들어지는 시점
		jsonData.mId = loginId;												//보낸사람
		jsonData.mIdYou = $(target).find('.usr-mg-info h3').text();			//받는사람
		jsonData.msg = $('#msg').val();										//내용
		jsonData.msgDate = d.getHours() + "시" + d.getMinutes();			//보낸시간
		jsonData.dmNo = $(target).attr('dmno');								//방번호 
		console.log(jsonData);
		
		if(jsonData.msg != null && jsonData.msg != "" && jsonData.msg != '&nbsp'){
				socket.send(jsonData.mId+","+jsonData.mIdYou+","+jsonData.msg+","+jsonData.msgDate+","+jsonData.dmNo+","+jsonData.dmContentsImage);
				$("#msg").val("");
				message_leftInsert_html(jsonData);
				message_send_insert_function(jsonData);
		}
	});
}

// 메시지 전송 버튼 클릭 후 메시지를 저장하는 콜백함수
function message_send_insert_function(jsonData){
	var messages = jsonData.mId+","+jsonData.mIdYou+","+jsonData.msg+","+jsonData.msgDate+","+jsonData.dmNo+","+jsonData.dmContentsImage;
	var params = "messages="+messages;
	$.ajax({
		url : 'messages_insert',
		method : 'POST',
		data : params,
		dataType : 'text',
		success : function(rowCount) {
			console.log(rowCount);
		}
	});
}

//메세지 유저 클릭 시 작동하는 콜백함수
function message_detail_function(target){
	console.log(target);
	var dmNo = $(target).attr('dmno');
	var params = "dmNo=" + dmNo;
	
	$.ajax({
		url : 'messageRoom_detail',
		method : 'GET',
		data : params,
		dataType : 'json',
		success : function(jsonArrayData) {
			message_list_function(jsonArrayData);
		}
	});
}

//유저 채팅리스트 출력 콜백함수
function message_list_function(jsonArrayData){
	console.log(jsonArrayData);
	for (var i = 0; i < jsonArrayData.length; i++) {
		jsonData.msg = jsonArrayData[i].dmContentsMessage;
		jsonData.msgDate = jsonArrayData[i].dmContentsDate;
		jsonData.dmContentsImage = jsonArrayData[i].dmContentsImage;
		var dmSenderId = jsonArrayData[i].dmSenderId;
		
		if(loginId == dmSenderId){
			message_leftInsert_html(jsonData);
			console.log("왼쪽");
		} else {
			message_rightInsert_html(jsonData);
			console.log("오른쪽");
		}
	}
		/* jsonData.msg, jsonData.msgDate, dmSenderId */
}

	

//  채팅방 생성 콜백함수
function message_profile_create_function(e){
	var mIdYou = $(e.target).parents('.company-up-info').attr('mIdYou');
	console.log("mIdYou : "+mIdYou);
	console.log("loginId : "+loginId);
 		if(loginId != null && mIdYou != null){
 			var params="mId="+loginId+"&"+"mIdYou="+mIdYou;
 				$.ajax({
 					url:'messages_room_create',
 					method:'GET',
 					data : params,
 					dataType:'text',
 					success:function(isSuccess){
 						location.href = contextPath.replace('ws','http')+'/messages';
 					}
 			});
 		}
}
	
// 채팅 수신 시 작동되는 콜백함수
function message_receive(event){
	var d = new Date();
	var msgArray = (event.data).split(",");
	jsonData.mIdYou = msgArray[0];	// 보낸사람 (너)
	jsonData.mId = msgArray[1];		// 받는사람 (나)
	jsonData.msg = msgArray[2];	// 내용
	jsonData.msgDate = d.getHours() + "시" + d.getMinutes(); // 시간
	console.log(jsonData);
	if(jsonData.msg != null || jsonData.msg != ""){
		message_rightInsert_html(jsonData);
		}
	}
function message_receive_noty(event){
	var msgArray = (event.data).split(",");
	var d = new Date();
	jsonData.mIdYou = msgArray[0];	// 보낸사람 (너)
	jsonData.mId = msgArray[1];		// 받는사람 (나)
	jsonData.msg = msgArray[2];	// 내용
	jsonData.msgDate = d.getHours() + "시" + d.getMinutes(); // 시간
	jsonData.dmContentsImage = msgArray[5];
	var htmlData = "";
	htmlData +="<div class='notfication-details'>";
	htmlData +=		"<div class='noty-user-img'>";
	htmlData +=			"<img src='contents/member_image/"+jsonData.dmContentsImage+"' alt=''>";
	htmlData +=		"</div>";
	htmlData +=		"<div class='notification-info'>";
	htmlData +=			"<h3><a href='messages' title=''>"+jsonData.mId+"</a> </h3>";
	htmlData +=			"<p>"+jsonData.msg+"</p>";
	htmlData +=			"<span>"+jsonData.msgDate+"</span>";
	htmlData +=		"</div>";
	htmlData +="</div>";
	$('.nott-list').append(htmlData);
}
$(document).ready(function(){
		connectWS();
		getLoginId();
	
		//채팅방 오픈
		$(document).find('div.messages-list > ul > li').on('click', function(e) {
			//console.log();
			var nodeName = e.target.nodeName;
			var target=null;
			if(nodeName=='H3'){
				console.log("H3");
				target = $(e.target).parents('.usr-msg-details');
			}else if(nodeName=='SPAN'){
				console.log("SPAN");
				target = $(e.target).parents('.usr-msg-details');
		    }else if(nodeName=='LI'){
		    	console.log("LI");
		    	target = $(e.target).find('.usr-msg-details');
		    }else if(nodeName=='DIV'){
		    	console.log("DIV");
		    	target = $(e.target);
		    } else if(nodeName =='IMG'){
		    	console.log('image');
		    	target = $(e.target).parents('.usr-msg-details');
		    }
			$('.main-conversation-box').html("");
			message_send_form(target);
			message_detail_function(target);
			message_send_function(target);
		});
		//profile 탭에서 유저의 메세지 버튼 클릭시 방 생성
		$(document).find('.message-us').on('click',function(e){
			e.preventDefault();
			message_profile_create_function(e);
		});
});	

function connectWS() {
	var ws = new WebSocket(contextPath+"/replyEcho");
	socket = ws;
	ws.onopen = function() { // connection이 open 되었을때 실행
		console.log('Info : connection opened.');
		// connection 이 close 되었을때 실행
		ws.onclose = function(event) { 
			console.log('Info: connection closed.');
		setTimeout(function() {
					connectWS();
			}, 1000);
		};
		// connection 이 error가 나왔을때
	ws.onerror = function(event) { 
				console.log('Info: connection closed.');
		};
		ws.onmessage = function(event) { // socket.send() 후 ReplyEchoHandler가 handleTextMessage메소드로부터 메시지를 받아옴											
			message_receive(event);
			message_receive_noty(event);
			let socketAlert = $('a#socketAlert');
			socketAlert.text(jsonData.mIdYou+"님이 메세지를 보냈습니다.");
			socketAlert.css('display', 'block');
			setTimeout( function() {
				socketAlert.css('display', 'none');
			},3000);
		};
	};	
}