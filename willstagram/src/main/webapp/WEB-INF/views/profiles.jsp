<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>	
<jsp:include page="/WEB-INF/commons/include_header_css.jsp"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<body>
	<div class="wrapper">
		
		<header>
			<!-- Menubar Starts -->
			<jsp:include page="../common_top_menu.jsp"/>
			<!-- Menubar End -->
		</header>	



		<section class="companies-info">
			<div class="container">
				<div class="company-title">
					<h3>All Profiles</h3>
				</div><!--company-title end-->
				<div class="companies-list">
					<div class="row">
					<!-- loop start -->
					<c:forEach var="member" items="${memberList}" varStatus="status">
						<c:if test="${status.index!=0}">
							</div>
						</c:if>
						<div class="col-lg-3 col-md-4 col-sm-6 col-12">
							<div class="company_profile_info">
								<div class="company-up-info">
									<c:choose>
										<c:when test="${member.mImage==null}">
											<img src="contents/member_image/default.png" alt="">
										</c:when>	
										<c:otherwise >
											<img src="contents/member_image/${member.mImage}" alt="">
										</c:otherwise>
									</c:choose>
									<h3>${member.mId}</h3>
									<h4>${member.mName}</h4>
									<ul>
									<c:forEach var="check" items="${followCheck}">
										<c:choose>
											<c:when test="${check.mIdYou==member.mId}">
												<li><a href="#" title="" class="unfollow">UnFollow</a></li><!-- follow중인 상태 -->
											</c:when>
											<c:otherwise>
												<li><a href="#" title="" class="follow">Follow</a></li>
											</c:otherwise>
										</c:choose>
									</c:forEach>
										<li><a href="#" title="" class="message-us"><i class="fa fa-envelope"></i></a></li>
									</ul>
				 					
								</div>
								<a href="user-profile.html" title="" class="view-more-pro">View Profile</a>
							</div><!--company_profile_info end-->
							</c:forEach>
							<!-- loop end -->
						</div>
					</div>
				</div><!--companies-list end-->
				
				<div class="process-comm">
					<div class="spinner">
						<div class="bounce1"></div>
						<div class="bounce2"></div>
						<div class="bounce3"></div>
					</div>
				</div><!--process-comm end-->
			</div>
		</section><!--companies-info end-->
		<footer>
			<div class="footy-sec mn no-margin">
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
					<p><img src="images/copy-icon2.png" alt="">Copyright 2019</p>
					<img class="fl-rgt" src="images/logo2.png" alt="">
				</div>
			</div>
		</footer>

	</div><!--theme-layout end-->



<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/popper.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/flatpickr.min.js"></script>
<script type="text/javascript" src="lib/slick/slick.min.js"></script>
<script type="text/javascript" src="js/script.js"></script>
<script type="text/javascript" src="js/wSearch.js"></script>
</body>
</html>