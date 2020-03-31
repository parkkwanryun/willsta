package com.itwill.willsta.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/*
①HandlerInterceptor 인터페이스
②HandlerInterceptorAdapter 추상클래스
	- public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object handler)
     	Controller 요청 전 실행
	- public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object handler, ModelAndVeiw modelAndVeiw)
     	Controller 처리가 끝나고 화면에 띄어주는 처리 직전에 수행
	- afterCompletion() : 모든 처리가 끝난 후 호출
 */

public class MemberAuthLoginAnnotationInterceptor extends HandlerInterceptorAdapter {
	public MemberAuthLoginAnnotationInterceptor() {
		System.out.println("### MemberAuthLoginAnnotationInterceptor()생성자");
	}

	// preHandle() : 컨트롤러보다 먼저 수행되는 메서드
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("### MemberAuthLoginAnnotationInterceptor.preHandle()메써드");
		// 1. handler 종류 확인
		// 우리가 관심 있는 것은 Controller에 있는 메서드이므로 HandlerMethod 타입인지 체크
		if (handler instanceof HandlerMethod == false) {
			// return true이면 Controller에 있는 메서드가 아니므로, 그대로 컨트롤러로 진행
			return true;
		}
		// 2.형 변환
		HandlerMethod handlerMethod = (HandlerMethod) handler;
		// 3. @MemberLoginCheck 받아오기
		MemberLoginCheck loginCheck = handlerMethod.getMethodAnnotation(MemberLoginCheck.class);

		// 4. method에 @MemberLoginCheck가 없는 경우, 즉 인증이 필요 없는 요청
		if (loginCheck == null) {
			System.out.println("### AuthLoginAnnotationInterceptor.preHandle() @MemberLoginCheck 없는 경우");
			return true;
		}
		// 5. @MemberLoginCheck가 있는 경우이므로, 세션이 있는지 체크
		System.out.println("### AuthLoginAnnotationInterceptor.preHandle() @MemberLoginCheck 있는 경우");
		
		// session 객체를 가져옴
		HttpSession session = request.getSession();
		// login처리를 담당하는 사용자 정보를 담고 있는 객체를 가져옴
		String sUserId = (String) session.getAttribute("sMemberId");

		if (sUserId == null) {
			// 로그인이 안되어 있는 상태임으로 로그인 폼으로 다시 돌려보냄(redirect)
			response.sendRedirect("willsta_main");
			return false; // 더이상 컨트롤러 요청으로 가지 않도록 false로 반환함
		}

		// preHandle의 return은 컨트롤러 요청 uri로 가도 되냐 안되냐를 허가하는 의미임
		// 따라서 true로하면 컨트롤러 uri로 가게 됨.
		return true;
	}

	// 컨트롤러가 수행되고 화면이 보여지기 직전에 수행되는 메서드
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		super.afterCompletion(request, response, handler, ex);
	}
}