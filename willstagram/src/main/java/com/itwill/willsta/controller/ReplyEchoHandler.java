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
	Map<String, WebSocketSession> userSessions = new HashMap<>();
	
	
	// 세션 커넥션 연결 되었을 때(클라이언트가 서버에 접속 성공시)
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		System.out.println("afterConnectionEstablished :" + session);
		sessions.add(session);
		String mId = getId(session);
		userSessions.put(mId, session);
	}

	// 소켓에 메시지 전송시
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		System.out.println(message.getPayload());
		String msg = message.getPayload();
		if(!StringUtils.isEmpty(msg)) {
			String[] strs = msg.split(",");
			if(strs != null && strs.length == 4) {
				String mId = strs[0];
				String mIdYou = strs[1];
				String contents = strs[2];
				String msgDate = strs[3];
				
				WebSocketSession mIdYouSession = userSessions.get(mIdYou);
				if(mIdYouSession != null) {
					TextMessage tmpMsg = new TextMessage(mId+","+mIdYou+","+contents+","+msgDate);
					mIdYouSession.sendMessage(tmpMsg);
				}
			}
		}
		// protocol: mId, mIdYou, contents, 

		/*
		if(!StringUtils.isEmpty(msg)) {
			String[] strs = msg.split(","); 
			if(strs != null && strs.length == 3) {
				String mId = strs[0];
				String mIdYou = strs[1];
				String contents = strs[2];
			*/	
		
			}
	// 세션 커넥션 종료시 데이터
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		System.out.println("afterConnectionClosed :" + session + "by~");
	}

	private String getId(WebSocketSession session) {
		Map<String, Object> httpSession = session.getAttributes();
		String loginId = (String) httpSession.get("mId");
		return loginId;
	}
}
