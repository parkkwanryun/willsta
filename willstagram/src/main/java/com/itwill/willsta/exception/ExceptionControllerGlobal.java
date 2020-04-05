package com.itwill.willsta.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionControllerGlobal {
	
	@ExceptionHandler(Exception.class)
	public ModelAndView exception(Exception e) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("msg", e.getMessage());
		modelAndView.setViewName("error");
		return modelAndView;
	}
}
