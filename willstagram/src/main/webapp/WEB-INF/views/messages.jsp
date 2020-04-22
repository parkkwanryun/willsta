<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>	
<jsp:include page="/WEB-INF/commons/include_header_css.jsp"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<body>	
	<div class="wrapper">		

		<header>
			<jsp:include page="../common_top_menu.jsp"/>
		</header><!--header end-->	
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
								<div class="messages-list"  style="overflow:auto; height:650px;">
									<ul>
										<!---------------------------채팅 리스트 시작------------------------------->
										<c:forEach var="dm" items="${dmList}">
											<!-- 유저 리스트 li가 하나의 박스 -->
											<li>
												<div class="usr-msg-details"  dmNo='${dm.dmNo}'>
													<div class="usr-ms-img">
														<img src="contents/member_image/${dm.mImage}" alt="" width="40px" height="40px">
														<span class="msg-status"></span>
													</div>
													<div class="usr-mg-info">
														<h3>${dm.mId}</h3>
														<span class = 'msg-counts'>${dm.dmChatReadCount}</span>
													</div>
													<!--usr-mg-info end-->
													<span class="posted_time">${dm.dmDate}</span> 
												</div>
												<!--usr-msg-details end-->
											</li>
										</c:forEach>
										<!---------------------------채팅 리스트 끝------------------------------->
									</ul>
								</div><!--messages-list end-->
							</div><!--msgs-list end-->
						</div>
						<div class="col-lg-8 col-md-12 pd-right-none pd-left-none">
							<div class="main-conversation-box">
							</div>
						</div>
					</div>
				</div><!--messages-sec end-->
			</div>
		</section><!--messages-page end-->


	</div><!--theme-layout end-->



<script type="text/javascript" src="js/popper.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/jquery.mCustomScrollbar.js"></script>
<script type="text/javascript" src="lib/slick/slick.min.js"></script>
<script type="text/javascript" src="js/scrollbar.js"></script>
<script type="text/javascript" src="js/script.js"></script>

</body>
</html>