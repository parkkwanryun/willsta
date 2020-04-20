<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<jsp:include page="/WEB-INF/commons/include_header_css.jsp" />

<style type="text/css">
input.error, textarea.error {
	border: 1px solid red;
	text-size: 1px;
}

label.error {
	margin-left: 1px;
	font-size: 10pt;
	color: red;
}
</style>
<body>
	<div class="wrapper">
		<header>
			<!-- Menubar Starts -->
			<jsp:include page="../common_top_menu.jsp" />
			<!-- Menubar End -->
		</header>

		<section class="profile-account-setting">
			<div class="container">
				<div class="account-tabs-setting">
					<div class="row">
						<div class="col-lg-3">
							<div class="acc-leftbar">
								<div class="nav nav-tabs" id="nav-tab" role="tablist">
									<a class="nav-item nav-link" id="nav-password-tab"
										data-toggle="tab" href="#nav-password" role="tab"
										aria-controls="nav-password" aria-selected="false"><i
										class="fa fa-lock"></i>
									<s:message code="modify.title" /></a> <a class="nav-item nav-link"
										id="nav-deactivate-tab" data-toggle="tab"
										href="#nav-deactivate" role="tab"
										aria-controls="nav-deactivate" aria-selected="false"><i
										class="fa fa-random"></i>
									<s:message code="deactivate.title" /></a>
								</div>
							</div>
							<!--acc-leftbar end-->
						</div>
						<div class="col-lg-9">
							<div class="tab-content" id="nav-tabContent">
								<!--  회원정보 변경 (mPass, mName, mEmail, mPhone, mImage 등 -->
								<div class="tab-pane fade" id="nav-password" role="tabpanel"
									aria-labelledby="nav-password-tab">
									<div class="acc-setting">
										<h3>
											<s:message code="modify.title" />
										</h3>
										<form id="member_modify_action" method="POST">

											<!-- 아이디 변경 불가(Hidden) 기존 값 전송 -->
											<div class="cp-field">
												<h5>
													<s:message code="sign.id" />
												</h5>
												<div class="cpp-fiel">
													<input type="text" name="mId" value="${sMemberId.mId}"
														readonly placeholder="Id can't be changed"> <i
														class="la la-user"></i>
												</div>
											</div>

											<!-- 이름 변경 불가(Hidden) 기존 값 전송 -->
											<div class="cp-field">
												<h5>
													<s:message code="join.name" />
												</h5>
												<div class="cpp-fiel">
													<input type="text" name="mName" value="${sMemberId.mName}"
														readonly placeholder="Id can't be changed"> <i
														class="la la-user"></i>
												</div>
											</div>

											<!-- 비밀번호 변경 -->
											<div class="cp-field">
												<h5>
													<s:message code="modify.password" />
												</h5>
												<div class="cpp-fiel">
													<input type="password" name="mPass" class="required"
														placeholder="<s:message code="modify.password"/>">
													<i class="la la-lock"></i>
												</div>
											</div>

											<!-- 이메일 변경 -->
											<div class="cp-field">
												<h5>
													<s:message code="modify.email" />
												</h5>
												<div class="cpp-fiel">
													<input type="text" name="mEmail" class="required"
														placeholder="<s:message code="modify.email"/>"> <i
														class="la la-user"></i>
												</div>
											</div>

											<!-- 전화번호 변경 -->
											<div class="cp-field">
												<h5>
													<s:message code="modify.phone" />
												</h5>
												<div class="cpp-fiel">
													<input type="text" name="mPhone" class="required"
														placeholder="<s:message code="modify.phone"/>"> <i
														class="la la-user"></i>
												</div>
											</div>

											<div class="save-stngs pd2">
												<ul>
													<li><button type="submit" value="submit">
															<s:message code="modify.save" />
														</button></li>
												</ul>
											</div>
										</form>



										<form id="member_img_modify_action" method="POST"
											enctype="multipart/form-data">
											<!-- Id 확인 -->
											<div class="cp-field">
												<h5>
													<s:message code="sign.id" />
												</h5>
												<div class="cpp-fiel">
													<input type="text" name="mId" value="${sMemberId.mId}"
														readonly placeholder="Id can't be changed"> <i
														class="la la-user"></i>
												</div>
											</div>
											<!-- 프로필 이미지 변경(이미지 업로드) -->
											<div class="cp-field">
												<h5>
													<s:message code="modify.image" />
												</h5>
												<div class="cpp-fiel">
													<input type="file" name="uploadImg" class="required"
														placeholder="New Image"> <i class="la la-user"></i>
												</div>
											</div>
											<div class="save-stngs pd2">
												<ul>
													<li><button type="submit" value="submit">
															<s:message code="modify.save" />
														</button></li>
												</ul>
											</div>
											<!--save-stngs end-->
										</form>


									</div>
									<!--acc-setting end-->
								</div>

								<div class="tab-pane fade" id="nav-deactivate" role="tabpanel"
									aria-labelledby="nav-deactivate-tab">
									<div class="acc-setting">
										<h3>
											<s:message code="deactivate.title" />
										</h3>
										<form id = "member_retire_action">
											<div class="cp-field">
												<h5>
													<s:message code="deactivate.email" />
												</h5>
												<div class="cpp-fiel">
													<input type="text" name="mEmail" value="${sMemberId.mEmail}"
														readonly placeholder="<s:message code="join.email"/>">
													<i class="fa fa-envelope"></i>
												</div>
											</div>
											<div class="cp-field">
												<h5>
													<s:message code="sign.password" />
												</h5>
												<div class="cpp-fiel">
													<input type="password" name="mPass"
														placeholder="<s:message code="sign.password"/>"> <i
														class="fa fa-lock"></i>
												</div>
											</div>
											<!-- 비활성화 이유
											<div class="cp-field">
												<h5><s:message code="deactivate.explain"/></h5>
												<textarea></textarea>
											</div>
											 -->
											<div class="save-stngs pd3">
												<ul>
													<li><button type="submit">
															<s:message code="deactivate.save" />
														</button></li>
													<li><button type="submit" value="submit">
															<s:message code="deactivate.restore" />
														</button></li>
												</ul>
											</div>
											<!--save-stngs end-->
										</form>
									</div>
									<!--acc-setting end-->
								</div>
							</div>
						</div>
					</div>
				</div>
				<!--account-tabs-setting end-->
			</div>
		</section>
	</div>
	<!--theme-layout end-->

	<jsp:include page="/WEB-INF/commons/include_footer_js.jsp" />
	<script type="text/javascript" src="js/jquery.validate.min.js"></script>
	<script type="text/javascript" src="js/wMember.js"></script>
</body>
</html>