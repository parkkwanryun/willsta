<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<jsp:include page="/WEB-INF/commons/include_header_css.jsp" />

<style type="text/css">
#msg1 {
	font-size: 12px;
	color: red;
}

#msg2 {
	font-size: 12px;
	color: red;
}

input.error, textarea.error {
	border: 1px solid red;
	text-size: 1px;
}

label.error {
	margin-left: 1px;
	font-size: 10pt;
	color: red;
}

.valid {
	border: 1px solid green;
}
</style>

<body class="sign-in">
	<div class="wrapper">

		<div class="sign-in-page">
			<div class="signin-popup">
				<div class="signin-pop">
					<div class="row">
						<div class="col-lg-6">
							<div class="cmp-info">
								<div class="cm-logo">
									<img src="images/helloMain.PNG" alt="">
									<!--  <img src="images/cm-logo.png" alt=""> -->
									<p><s:message code="sign.introduction"/></p>
								</div>
								<!--cm-logo end-->
								<img src="images/gangsanim.PNG" alt="">
							</div>
							<!--cmp-info end-->
						</div>

						<div class="col-lg-6">
							<div class="login-sec">
								<ul class="sign-control">
									<li data-tab="tab-1" class="current"><a href="#" title=""><s:message code="sign.title"/></a></li>
									<li data-tab="tab-2"><a href="#" title=""><s:message code="sign.join"/></a></li>
								</ul>
								<div class="sign_in_sec current" id="tab-1">
									<h3><s:message code="sign.title"/></h3>

									<form id="member_login_action" method="POST">
										<div class="row">
											<div class="col-lg-12 no-pdd">
												<div class="sn-field">
													<input type="text" id="i" class="required" name="mId"
														placeholder="<s:message code='sign.id'/>">
													<div id="msg1"></div>
													<span id="msg"></span> <i class="la la-user"></i>
												</div>
												<!--sn-field end-->
											</div>
											<div class="col-lg-12 no-pdd">
												<div class="sn-field">
													<input type="password" id="p" class="required" name="mPass"
														placeholder="<s:message code='sign.password'/>">
													<div id="msg2"></div>
													<span id="msg"></span> <i class="la la-lock"></i>
												</div>
											</div>
											<div class="col-lg-12 no-pdd">
												<div class="row">
													<div class="col-lg-9 checky-sec">
														<!--  로그인 시, 아이디 저장 체크 박스 
														<div class="fgt-sec">
															<input type="checkbox" name="cc" id="c1" onkeyup="check_box_function();">
															<label for="c1">
																<span></span>
															</label>
															<small>Remember me</small>
														</div>
													 -->
														<!--fgt-sec end-->
														<a href="#" title=""><s:message code="sign.forgotPassword"/></a>
													</div>
												</div>
											</div>
											<div class="col-lg-12 no-pdd">
												<button type="submit" value="submit"><s:message code="sign.title"/></button>
											</div>
										</div>
									</form>

									<div class="login-resources">
										<h4><s:message code="sign.social"/></h4>
										<ul>
											<li><a href="#" title="" class="fb"><i
													class="fa fa-facebook"></i><s:message code="sign.naver"/></a></li>
										</ul>
									</div>
									<!--login-resources end-->
								</div>




								<!--sign_in_sec end-->
								<div class="sign_in_sec" id="tab-2">
									<!--signup-tab end (회원가입 탭)-->

									<div class="dff-tab current" id="tab-3">

										<form id="member_register_action" method="POST">

											<div class="row">
												<div class="col-lg-12 no-pdd">
													<div class="sn-field">
														<input type="text" id="mId" name="mId" class="required"
															placeholder="<s:message code='sign.id'/>"> <i class="la la-user"></i>
													</div>
												</div>
												<div class="col-lg-12 no-pdd">
													<div class="sn-field">
														<input type="password" id="mPass" name="mPass"
															class="required" placeholder="<s:message code='sign.password'/>"> <i
															class="la la-lock"></i>
													</div>
												</div>
												<div class="col-lg-12 no-pdd">
													<div class="sn-field">
														<input type="text" id="mName" name="mName"
															class="required" placeholder="<s:message code='join.name'/>"> <i
															class="la la-user"></i>
													</div>
												</div>
												<div class="col-lg-12 no-pdd">
													<div class="sn-field">
														<input type="text" id="mEmail" name="mEmail"
															class="required" placeholder="<s:message code='join.email'/>">
														<i class="la la-user"></i>
													</div>
												</div>
												<div class="col-lg-12 no-pdd">
													<div class="sn-field">
														<input type="text" id="mPhone" name="mPhone"
															class="required" placeholder="<s:message code='join.phoneNumber'/>"> <i
															class="la la-user"></i>
													</div>
												</div>
												<div class="col-lg-12 no-pdd">
													<div class="sn-field">
														<input type="text" id="mImage" name="mImage"
															class="required" placeholder="<s:message code='join.image'/>">
														<i class="la la-user"></i>
													</div>
												</div>
												<div class="col-lg-12 no-pdd">
													<div class="checky-sec st2">
														<div class="fgt-sec">
															<input type="checkbox" name="mRetire" id="c2"> <label
																for="c2"> <span></span>
															</label> <small><s:message code="join.agree"/></small>
														</div>
														<!--fgt-sec end-->
													</div>
												</div>
												<div class="col-lg-12 no-pdd">
													<button type="submit" value="submit"><s:message code="join.signUp"/></button>
												</div>
											</div>
										</form>


									</div>
									<!--dff-tab end-->
									<div class="dff-tab" id="tab-4">
										<form>
											<div class="row">
												<div class="col-lg-12 no-pdd">
													<div class="sn-field"></div>
												</div>
												<div class="col-lg-12 no-pdd">
													<div class="sn-field"></div>
												</div>
												<div class="col-lg-12 no-pdd">
													<div class="sn-field"></div>
												</div>
												<div class="col-lg-12 no-pdd">
													<div class="sn-field"></div>
												</div>
												<div class="col-lg-12 no-pdd">
													<div class="checky-sec st2">
														<div class="fgt-sec">
															<input type="checkbox" name="cc" id="c3"> <label
																for="c3"> <span></span>
															</label> <small>Yes, I understand and agree to the
																workwise Terms & Conditions.</small>
														</div>
														<!--fgt-sec end-->
													</div>
												</div>
												<div class="col-lg-12 no-pdd">
													<button type="submit" value="submit">Get Started</button>
												</div>
											</div>
										</form>
									</div>
									<!--dff-tab end-->
								</div>
							</div>
							<!--login-sec end-->
						</div>
					</div>
				</div>
				<!--signin-pop end-->
			</div>
			<!--signin-popup end-->
			<div class="footy-sec">
				<div class="container">
					<ul>
						<li><a href="help-center.html" title="">Help Center</a></li>
						<li><a href="about.html" title="">About</a></li>
						<li><a href="#" title="">Privacy Policy</a></li>
						<li><a href="#" title="">Community Guidelines</a></li>
						<li><a href="#" title="">Cookies Policy</a></li>
						<li><a href="#" title="">Career</a></li>
						<li><a href="forum.html" title="">Forum</a></li>
						<li><a href="#" title="">Language</a></li>
						<li><a href="#" title="">Copyright Policy</a></li>
					</ul>
					<p>
						<img src="images/copy-icon.png" alt="">Copyright 2019
					</p>
				</div>
			</div>
			<!--footy-sec end-->
		</div>
		<!--sign-in-page end-->


	</div>
	<!--theme-layout end-->

	<jsp:include page="/WEB-INF/commons/include_footer_js.jsp" />
	<script type="text/javascript" src="js/wMember.js"></script>
	<script src="js/jquery.validate.min.js"></script>

</body>
</html>