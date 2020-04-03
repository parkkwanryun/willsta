/**
 * 
 */

$(document).ready(function(){
	connectWS();
});
var socket = null;
	function connectWS() {
		var ws = new WebSocket("ws://localhost:8080/willstagram/replyEcho");
		socket = ws;
		ws.onopen = function() { // connection이 open 되었을때 실행
			console.log('Info : connection opened.');
		};
		ws.onmessage = function(event) { // socket.send() 후 ReplyEchoHandler가 handleTextMessage메소드로부터 메시지를 받아옴											// 실행
			console.log(event.data + '\n');
		};
		ws.onclose = function(event) { // connection 이 close 되었을때 실행
			console.log('Info: connection closed.');
			setTimeout(function() {
				connect();
			}, 1000);
		};
		ws.onerror = function(event) { // connection 이 error가 나왔을때
			console.log('Info: connection closed.');
		};
	}