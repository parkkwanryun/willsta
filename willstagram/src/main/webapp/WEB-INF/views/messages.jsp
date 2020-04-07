<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
	<meta charset="UTF-8">
	<title>WorkWise Html Template</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="" />
	<meta name="keywords" content="" />
	<link rel="stylesheet" type="text/css" href="css/animate.css">
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="css/line-awesome.css">
	<link rel="stylesheet" type="text/css" href="css/line-awesome-font-awesome.min.css">
	<link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
	<link rel="stylesheet" type="text/css" href="css/font-awesome.min.css">
	<link rel="stylesheet" type="text/css" href="css/jquery.mCustomScrollbar.min.css">
	<link rel="stylesheet" type="text/css" href="lib/slick/slick.css">
	<link rel="stylesheet" type="text/css" href="lib/slick/slick-theme.css">
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<link rel="stylesheet" type="text/css" href="css/responsive.css">
</head>
<body>
	<style>
div.messages-list>ul>li:hover {
	background-color: mistyrose;
}
</style>
	<body>	
	<div class="wrapper">	
	<!-- common_top_menu start -->
		<header>
			<!-- Menubar Starts -->
			<jsp:include page="../common_top_menu.jsp"/>
			<!-- Menubar End -->
		</header>
<!-- common_top_menu end -->
		<section class="messages-page">
			<div class="container">
				<div class="messages-sec">
					<div class="row">
						<div class="col-lg-4 col-md-12 no-pdd">
							<div class="msgs-list">
								<div class="msg-title">
									<h3>Messages</h3>
									<ul>
										<li><a href="#" title=""><i class="fa fa-cog"></i></a></li>
										<li><a href="#" title=""><i class="fa fa-ellipsis-v"></i></a></li>
									</ul>
								</div><!--msg-title end-->
								<div class="messages-list">
									<ul>
									<!---------------------------채팅 리스트 시작------------------------------->
										<c:forEach var="dm" items="${dmList}">
											<!-- 유저 리스트 li가 하나의 박스 -->
											<li>
												<div class="usr-msg-details">
													<div class="usr-ms-img">
														<img src="contents/member_image/${dm.mImage}" alt="">
														<span class="msg-status"></span>
													</div>
													<div class="usr-mg-info">
														<h4 style='display: none'>${dm.mId}</h4>
														<h3>${dm.mIdYou}</h3>
													</div>
													<!--usr-mg-info end-->
													<span class="posted_time">${dm.dmDate}</span> <span
														class="msg-notifc" style='display: none' id='dmNo'>${dm.dmNo}</span>
												</div>
												<!--usr-msg-details end-->
											</li>
										</c:forEach>
										<!---------------------------채팅 리스트 끝------------------------------->
									</ul>
								</div><!--messages-list end-->
							</div><!--msgs-list end-->
						</div>
						<!---------------------------메시지창 시작------------------------------->
						<div class="col-lg-8 col-md-12 pd-right-none pd-left-none">
							<div class="main-conversation-box">
								<div class="messages-line">
								<!-- 메세지 컨텐츠 들어갈자리 -->
								</div><!--messages-line end-->
								<div class="message-send-area">
									<form>
										<div class="mf-field">
											<input type="text" id="msg" placeholder="Type a message here">
											<button type="submit" id="btnSend">Send</button>
										</div>
										<ul>
											<li><a href="#" title=""><i class="fa fa-smile-o"></i></a></li>
											<li><a href="#" title=""><i class="fa fa-camera"></i></a></li>
											<li><a href="#" title=""><i class="fa fa-paperclip"></i></a></li>
										</ul>
									</form>
								</div><!--message-send-area end-->
							</div><!--main-conversation-box end-->
						</div>
						<!---------------------------메시지창 끝------------------------------->
					</div>
				</div><!--messages-sec end-->
			</div>
		</section><!--messages-page end-->
	</div><!--theme-layout end-->

	<!--theme-layout end-->
	<jsp:include page="/WEB-INF/commons/include_footer_js.jsp" />
</body>
</html>