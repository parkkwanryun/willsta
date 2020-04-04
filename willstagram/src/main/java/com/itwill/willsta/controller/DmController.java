package com.itwill.willsta.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itwill.willsta.domain.DM;
import com.itwill.willsta.domain.Member;
import com.itwill.willsta.service.DmService;
import com.itwill.willsta.service.MemberService;

@Controller
public class DmController {
	@Autowired
	private DmService dmService;
	
	@ResponseBody
	@RequestMapping(value = "/sessionCheck")
	public String returnSessionCheck(HttpSession httpSession) {
		String loginId = (String)httpSession.getAttribute("mId");
		/*
		if(sessionId != null && sessionId.equals("")) {
			textData = sessionId;
		} else {
			textData = "faild";
		}
		*/
		return loginId;
	}
	
	@ResponseBody
	@RequestMapping(value = "/messages_room_create")
	public String messageRoomInsert(HttpSession httpSession,
									@RequestParam("mId") String mId,
									@RequestParam("mIdYou") String mIdYou) {
		String isSuccess = "success";
		List<DM> dmList = dmService.dmSelectAll(mId);
		for (DM dm : dmList) {
			if(dm.getmIdYou().equalsIgnoreCase(mIdYou)) {
				isSuccess = "faild";
				break;
			}
		}
		if(isSuccess == "success") {
			dmService.dmInsert(new DM(-999, mId, mIdYou, "sysdate"));
		} 
		return isSuccess;
	}
	
	
	@RequestMapping(value = "/messages")
	public String messageForm(HttpServletRequest httpServletRequest) {
		String mId = (String)httpServletRequest.getSession().getAttribute("mId");
		List<DM> dmList = dmService.dmSelectAll(mId); 
		httpServletRequest.getSession().setAttribute("dmList", dmList);
		
		System.out.println("컨트롤러 호출 성공");
		
		httpServletRequest.getSession().setAttribute("mId", mId);
		
		return "messages";
	}
}
