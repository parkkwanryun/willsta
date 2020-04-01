package com.itwill.willsta.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;
public class ReplyEchoHandler extends TextWebSocketHandler{
	List<WebSocketSession> sessions = new ArrayList<>();
	
	// 세션 커넥션 연결 되었을 때(클라이언트가 서버에 접속 성공시)
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		System.out.println("afterConnectionEstablished :"+session);
		sessions.add(session);
	}
	// 소켓에 메시지 전송시
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		System.out.println(message.getPayload());
		String senderId = session.getId();
		for (WebSocketSession sess : sessions) {
			sess.sendMessage(new TextMessage(senderId+ ":" + message.getPayload()));
		}
	}
	
	//세션 커넥션 종료시
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		System.out.println("afterConnectionClosed :"+session+"by~");
	}
}
