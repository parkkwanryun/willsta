<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/socketConnect.js"></script>
			<div class="container">
				<div class="header-data">
					<div class="logo">
						<a href="main_post" title=""><img src="images/logo.png" alt=""></a>
					</div><!--logo end-->
					<div class="search-bar">
						<form class="userSearch">
							<input type="text" name="search" placeholder="<s:message code="menu.search"/>">
							<button type="submit"><i class="la la-search"></i></button>
						</form>
					</div><!--search-bar end-->
					<nav>
						<ul>
							<li>
								<a id="socketAlert" href="messages"  title="" ></a>
							</li>
							<li>
								<a href="main_post" title="">
									<span><img src="images/icon1.png" alt=""></span>
									<s:message code="menu.home"/>
								</a>
							</li>
							<li>
								<a href="https://www.itwill.co.kr" title="">
									<span><img src="images/icon2.png" alt=""></span>
									<s:message code="menu.company"/>
								</a>
							</li>
							<li>
								<a href="profiles" title="">
									<span><img src="images/icon3.png" alt=""></span>
									<s:message code="menu.profiles"/>
								</a>
							</li>
							<li>
								<a href=personal_info title="">
									<span><img src="images/icon4.png" alt=""></span>
									<s:message code="menu.mypage"/>
								</a>
							</li>
							<li>
								<a href="#" title="" class="not-box-openm">
									<span><img src="images/icon6.png" alt=""></span>
									<s:message code="menu.message"/>
								</a>
								<div class="notification-box msg" id="message">
									<div class="nt-title">
										<h4><s:message code="menu.setting"/></h4>
										<a href="#" title=""><s:message code="menu.clear"/></a>
									</div>
									<div class="nott-list">
									<!-- 
										<div class="notfication-details">
							  				<div class="noty-user-img">
							  					<img src="images/resources/ny-img1.png" alt="">
							  				</div>
							  				<div class="notification-info">
							  					<h3><a href="messages" title="">Jassica William</a> </h3>
							  					<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do.</p>
							  					<span>2 min ago</span>
							  				</div>
						  				</div>
						  			-->
						  				<div class="view-all-nots">
						  					<a href="messages" title=""><s:message code="menu.allMessage"/></a>
						  				</div>
									</div><!--nott-list end-->
								</div><!--notification-box end-->
							</li>
						</ul>
					</nav><!--nav end-->
					<div class="menu-btn">
						<a href="#" title=""><i class="fa fa-bars"></i></a>
					</div><!--menu-btn end-->
					<div class="user-account">
						<div class="user-info">
							<img src="contents/member_image/${member.mImage}" width="35px" height="35px">
							<a href="#" title="">${member.mName}</a>
						</div>
						<div class="user-account-settingss" id="users">
							
							<h3><s:message code="menu.setting"/></h3>
							<ul class="us-links">
								<li><a href="profile-account-setting" title=""><s:message code="menu.accountSetting"/></a></li>
								<li><a href="#" title="">Privacy</a></li>
								<li><a href="#" title="">Faqs</a></li>
								<li><a href="#" title="">Terms & Conditions</a></li>
							</ul>
							<c:if test="${!empty(sMemberId)}">
							<h3 class="tc" id="inner_sign_out">
							<a href="sign_in" title=""><s:message code="menu.logout"/></a></h3>
							</c:if>
							<c:if test="${empty(sMemberId)}">
							<h3 class="tc" id="inner_sign_in" >
							<a href="sign_in" title="">Login</a></h3>
							</c:if>
						</div><!--user-account-settingss end-->
					</div>
				</div><!--header-data end-->
			</div>			