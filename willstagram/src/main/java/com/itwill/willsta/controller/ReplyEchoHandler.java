package com.itwill.willsta.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.ConstructorArgs;
import org.springframework.util.StringUtils;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.itwill.willsta.domain.Member;
import com.itwill.willsta.repository.DmContentsDao;
import com.itwill.willsta.service.DmService;

public class ReplyEchoHandler extends TextWebSocketHandler {
	List<WebSocketSession> sessions = new ArrayList<>();
	Map<String, WebSocketSession> userSessions = new HashMap<String, WebSocketSession>();
	
	
	// 세션 커넥션 연결 되었을 때(클라이언트가 서버에 접속 성공시)
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		System.out.println("afterConnectionEstablished :" + session);
		sessions.add(session);
		String senderId = getId(session);
		userSessions.put(senderId, session);
	}

	// 소켓에 메시지 전송시
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		System.out.println(message.getPayload());
		String senderId = getId(session);
		System.out.println(senderId);
		// protocol: 내용, 메세지 샌더, 메세지 리시버, (reply, sender, receiver)
		String msg = message.getPayload();
		
		if(!StringUtils.isEmpty(msg)) {
			String[] strs = msg.split(","); 
			if(strs != null && strs.length == 3) {
				String contents = strs[0];
				String msgSender = strs[1];
				String msgReceiver = strs[2];
				
				WebSocketSession msgReceiverSession = userSessions.get(msgReceiver);
				if(msgReceiverSession != null) {
					TextMessage tmpMsg = new TextMessage(msgSender + "님이 메시지를 송신 하셨습니다.");
					msgReceiverSession.sendMessage(tmpMsg);
				}
			}
			
		}
		
	}

	// 세션 커넥션 종료시 데이터
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		System.out.println("afterConnectionClosed :" + session + "by~");
	}

	private String getId(WebSocketSession session) {
		Map<String, Object> httpSession = session.getAttributes();
		String loginId = (String) httpSession.get("mId");
		if (loginId == null) 
			return session.getId();
		 else 
			return loginId;
	}
}
