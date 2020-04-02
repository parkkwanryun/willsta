package com.itwill.willsta.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DmController {
	
	
	@RequestMapping(value = "/messages")
	public String messageForm() {
		return "messages";
	}
}
