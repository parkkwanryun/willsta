<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<jsp:include page="/WEB-INF/commons/include_header_css.jsp"/>
<style>
	.user-profile-main {
		float: left;
    	width: 100%;
    	padding: 200px 0;
	}
</style>
<body>
	<div class="wrapper">
		<header>
			<!-- Menubar Starts -->
			<jsp:include page="../common_top_menu.jsp"/>
			<!-- Menubar End -->
		</header>	
		<main class="user-profile-main">
			<div class="main-section">
				<div class="container">
					<div class="main-section-data">
						<div class="row">
							<div class="col-lg-3">
								<div class="main-left-sidebar">
									<div class="user_profile" mIdYou="${profile.mId}">
										<div class="user-pro-img">
										<c:choose>
											<c:when test="${profile.mImage==null}">
												<img src="contents/member_image/default.png" alt="">
											</c:when>	
											<c:otherwise >
												<img src="contents/member_image/${profile.mImage}" alt="">
											</c:otherwise>
										</c:choose>
										</div><!--user-pro-img end-->
										<div class="user_pro_status">
											<ul class="flw-hr">
												<li><a href="#" title="" class="follow">Follow</a></li>
												<li><a href="#" title="" class="unFollow">unFollow</a></li>
												<li><a href="#" title="" class="message-us"><i class="fa fa-envelope"></i>Message</a></li>
											</ul>
											<ul class="flw-status">
												<li>
													<span>Following</span>
													<b>34</b>
												</li>
												<li>
													<span>Followers</span>
													<b>155</b>
												</li>
											</ul>
										</div><!--user_pro_status end-->
									</div><!--user_profile end-->
									<div class="suggestions full-width">
										<div class="sd-title">
											<h3>친구추천</h3>
											<i class="la la-ellipsis-v"></i>
										</div><!--sd-title end-->
										<div class="suggestions-list">
											<c:forEach var="mList" items="${memberList}">
											
												<div class="suggestion-usd">
												<c:if test="${mList.mId!=sessionScope.mId }">
													<img src="contents/member_image/${mList.mImage}" alt="" width="40px">
													<div class="sgt-text">
														<h4>${mList.mName}</h4>
														<span>${mList.mEmail}</span>
													</div>
													<span><i mid='${mList.mId}' class="la la-plus sFollow" ></i></span> 
										
													</c:if>
					
												</div>
											
											</c:forEach>
											<div class="view-more">
												<!-- <a href="#" title="">View More</a> -->
											</div>
										</div><!--suggestions-list end-->
										
										
										
									</div><!--suggestions end-->
									<div class="tags-sec full-width">
										<div class="cp-sec">
											<p><s:eval expression="new java.util.Date().toLocaleString()"/></p>
											<img src="images/logo.png" alt="">
											<p><img src="images/cp.png" alt="">Copyright 2020</p>
										</div>
									</div><!--tags-sec end-->
								</div><!--main-left-sidebar end-->
							</div>
							<div class="col-lg-6">
								<div class="main-ws-sec">
									<div class="user-tab-sec">
										<h3>${profile.mName}</h3>
										<div class="star-descp">
											<span>${profile.mEmail}</span>
										</div><!--star-descp end-->
									</div><!--user-tab-sec end-->
									<div class="product-feed-tab current" id="feed-dd">
										<div class="posts-section">
											<div class="post-bar">
												<div class="post_topbar">
													<div class="usy-dt">
														<img src="images/resources/us-pic.png" alt="">
														<div class="usy-name">
															<h3>John Doe</h3>
															<span><img src="images/clock.png" alt="">3 min ago</span>
														</div>
													</div>
													<div class="ed-opts">
														<a href="#" title="" class="ed-opts-open"><i class="la la-ellipsis-v"></i></a>
														<ul class="ed-options">
															<li><a href="#" title="">Edit Post</a></li>
															<li><a href="#" title="">Unsaved</a></li>
															<li><a href="#" title="">Unbid</a></li>
															<li><a href="#" title="">Close</a></li>
															<li><a href="#" title="">Hide</a></li>
														</ul>
													</div>
												</div>
												<div class="epi-sec">
													<ul class="descp">
														<li><img src="images/icon8.png" alt=""><span>Epic Coder</span></li>
														<li><img src="images/icon9.png" alt=""><span>India</span></li>
													</ul>
													<ul class="bk-links">
														<li><a href="#" title=""><i class="la la-bookmark"></i></a></li>
														<li><a href="#" title=""><i class="la la-envelope"></i></a></li>
													</ul>
												</div>
												<div class="job_descp">
													<h3>Senior Wordpress Developer</h3>
													<ul class="job-dt">
														<li><a href="#" title="">Full Time</a></li>
														<li><span>$30 / hr</span></li>
													</ul>
													<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam luctus hendrerit metus, ut ullamcorper quam finibus at. Etiam id magna sit amet... <a href="#" title="">view more</a></p>
													<ul class="skill-tags">
														<li><a href="#" title="">HTML</a></li>
														<li><a href="#" title="">PHP</a></li>
														<li><a href="#" title="">CSS</a></li>
														<li><a href="#" title="">Javascript</a></li>
														<li><a href="#" title="">Wordpress</a></li> 	
													</ul>
												</div>
												<div class="job-status-bar">
													<ul class="like-com">
														<li>
															<a href="#"><i class="fas fa-heart"></i> Like</a>
															<img src="images/liked-img.png" alt="">
															<span>25</span>
														</li>
														<li><a href="#" class="com"><i class="fas fa-comment-alt"></i> Comments 15</a></li>
													</ul>
													<a href="#"><i class="fas fa-eye"></i>Views 50</a>
												</div>
											</div><!--post-bar end-->
											<div class="process-comm">
												<div class="spinner">
													<div class="bounce1"></div>
													<div class="bounce2"></div>
													<div class="bounce3"></div>
												</div>
											</div><!--process-comm end-->
										</div><!--posts-section end-->
									</div><!--product-feed-tab end-->
									<div class="product-feed-tab" id="info-dd">
										<div class="user-profile-ov">
											<h3>Overview</h3>
											<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque tempor aliquam felis, nec condimentum ipsum commodo id. Vivamus sit amet augue nec urna efficitur tincidunt. Vivamus consectetur aliquam lectus commodo viverra. Nunc eu augue nec arcu efficitur faucibus. Aliquam accumsan ac magna convallis bibendum. Quisque laoreet augue eget augue fermentum scelerisque. Vivamus dignissim mollis est dictum blandit. Nam porta auctor neque sed congue. Nullam rutrum eget ex at maximus. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec eget vestibulum lorem.</p>
										</div><!--user-profile-ov end-->
										<div class="user-profile-ov st2">
											<h3>Experience</h3>
											<h4>Web designer</h4>
											<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque tempor aliquam felis, nec condimentum ipsum commodo id. Vivamus sit amet augue nec urna efficitur tincidunt. Vivamus consectetur aliquam lectus commodo viverra. </p>
											<h4>UI / UX Designer</h4>
											<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque tempor aliquam felis, nec condimentum ipsum commodo id.</p>
											<h4>PHP developer</h4>
											<p class="no-margin">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque tempor aliquam felis, nec condimentum ipsum commodo id. Vivamus sit amet augue nec urna efficitur tincidunt. Vivamus consectetur aliquam lectus commodo viverra. </p>
										</div><!--user-profile-ov end-->
										<div class="user-profile-ov">
											<h3>Education</h3>
											<h4>Master of Computer Science</h4>
											<span>2015 - 2018</span>
											<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque tempor aliquam felis, nec condimentum ipsum commodo id. Vivamus sit amet augue nec urna efficitur tincidunt. Vivamus consectetur aliquam lectus commodo viverra. </p>
										</div><!--user-profile-ov end-->
										<div class="user-profile-ov">
											<h3>Location</h3>
											<h4>India</h4>
											<p>151/4 BT Chownk, Delhi </p>
										</div><!--user-profile-ov end-->
										<div class="user-profile-ov">
											<h3>Skills</h3>
											<ul>
												<li><a href="#" title="">HTML</a></li>
												<li><a href="#" title="">PHP</a></li>
												<li><a href="#" title="">CSS</a></li>
												<li><a href="#" title="">Javascript</a></li>
												<li><a href="#" title="">Wordpress</a></li>
												<li><a href="#" title="">Photoshop</a></li>
												<li><a href="#" title="">Illustrator</a></li>
												<li><a href="#" title="">Corel Draw</a></li>
											</ul>
										</div><!--user-profile-ov end-->
									</div><!--product-feed-tab end-->
									<div class="product-feed-tab" id="portfolio-dd">
										<div class="portfolio-gallery-sec">
											<h3>Portfolio</h3>
											<div class="gallery_pf">
												<div class="row">
													<div class="col-lg-4 col-md-4 col-sm-6 col-6">
														<div class="gallery_pt">
															<img src="images/resources/pf-img1.jpg" alt="">
															<a href="#" title=""><img src="images/all-out.png" alt=""></a>
														</div><!--gallery_pt end-->
													</div>
													<div class="col-lg-4 col-md-4 col-sm-6 col-6">
														<div class="gallery_pt">
															<img src="images/resources/pf-img2.jpg" alt="">
															<a href="#" title=""><img src="images/all-out.png" alt=""></a>
														</div><!--gallery_pt end-->
													</div>
													<div class="col-lg-4 col-md-4 col-sm-6 col-6">
														<div class="gallery_pt">
															<img src="images/resources/pf-img3.jpg" alt="">
															<a href="#" title=""><img src="images/all-out.png" alt=""></a>
														</div><!--gallery_pt end-->
													</div>
													<div class="col-lg-4 col-md-4 col-sm-6 col-6">
														<div class="gallery_pt">
															<img src="images/resources/pf-img4.jpg" alt="">
															<a href="#" title=""><img src="images/all-out.png" alt=""></a>
														</div><!--gallery_pt end-->
													</div>
													<div class="col-lg-4 col-md-4 col-sm-6 col-6">
														<div class="gallery_pt">
															<img src="images/resources/pf-img5.jpg" alt="">
															<a href="#" title=""><img src="images/all-out.png" alt=""></a>
														</div><!--gallery_pt end-->
													</div>
													<div class="col-lg-4 col-md-4 col-sm-6 col-6">
														<div class="gallery_pt">
															<img src="images/resources/pf-img6.jpg" alt="">
															<a href="#" title=""><img src="images/all-out.png" alt=""></a>
														</div><!--gallery_pt end-->
													</div>
													<div class="col-lg-4 col-md-4 col-sm-6 col-6">
														<div class="gallery_pt">
															<img src="images/resources/pf-img7.jpg" alt="">
															<a href="#" title=""><img src="images/all-out.png" alt=""></a>
														</div><!--gallery_pt end-->
													</div>
													<div class="col-lg-4 col-md-4 col-sm-6 col-6">
														<div class="gallery_pt">
															<img src="images/resources/pf-img8.jpg" alt="">
															<a href="#" title=""><img src="images/all-out.png" alt=""></a>
														</div><!--gallery_pt end-->
													</div>
													<div class="col-lg-4 col-md-4 col-sm-6 col-6">
														<div class="gallery_pt">
															<img src="images/resources/pf-img9.jpg" alt="">
															<a href="#" title=""><img src="images/all-out.png" alt=""></a>
														</div><!--gallery_pt end-->
													</div>
													<div class="col-lg-4 col-md-4 col-sm-6 col-6">
														<div class="gallery_pt">
															<img src="images/resources/pf-img10.jpg" alt="">
															<a href="#" title=""><img src="images/all-out.png" alt=""></a>
														</div><!--gallery_pt end-->
													</div>
												</div>
											</div><!--gallery_pf end-->
										</div><!--portfolio-gallery-sec end-->
									</div><!--product-feed-tab end-->
								</div><!--main-ws-sec end-->
							</div>
							<div class="col-lg-3">
								<div class="right-sidebar">
									<div class="widget widget-about">
										<img src="images/wd-logo.png" alt="">
										<h3>WillStarGram</h3>
										<span>Itwill Class5 Team2 Project</span>
									</div><!--widget-about end-->
									<div class="widget widget-jobs">
										<div class="sd-title">
											<h3><s:message code="post.topView"/></h3>
											<i class="la la-ellipsis-v"></i>
										</div>
										<div class="jobs-list">
											<c:forEach var="postRank" items="${postRankList}">
												<div class="job-info" post_no="${postRank.PNO}">
													<div class="job-details">
														<h3>${postRank.MNAME}</h3>
														<p><a href="#" title="" class="top-views">${postRank.PTITLE}</a></p>
													</div>
													<div class="hr-rate">
														<span>${postRank.PVIEWCOUNT}</span>
													</div>
												</div><!--job-info end-->
											</c:forEach>
										</div><!--jobs-list end-->
									</div><!--widget-jobs end-->
									<div class="widget widget-ad">
										<div class="sign_link" style="padding:10px">
											<h3><a href="http://ec2-54-180-83-67.ap-northeast-2.compute.amazonaws.com:8080/myshop/product/list" title="">
												<img src="images/dapara.png" alt="">
												</a>
											</h3>
										</div>
									</div>
								</div><!--right-sidebar end-->
							</div>
						</div>
					</div><!-- main-section-data end-->
				</div> 
			</div>
		</main>


		 <jsp:include page="/WEB-INF/commons/include_footy_js.jsp"/>
		 <!--footer end-->


		<div class="overview-box" id="create-portfolio">
			<div class="overview-edit">
				<h3>Create Portfolio</h3>
				<form>
					<input type="text" name="pf-name" placeholder="Portfolio Name">
					<div class="file-submit">
						<input type="file" name="file">
					</div>
					<div class="pf-img">
						<img src="images/resources/np.png" alt="">
					</div>
					<input type="text" name="website-url" placeholder="htp://www.example.com">
					<button type="submit" class="save">Save</button>
					<button type="submit" class="cancel">Cancel</button>
				</form>
				<a href="#" title="" class="close-box"><i class="la la-close"></i></a>
			</div><!--overview-edit end-->
		</div><!--overview-box end-->



	</div><!--theme-layout end-->



 <jsp:include page="/WEB-INF/commons/include_footer_js.jsp"/>
 
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/popper.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/flatpickr.min.js"></script>
<script type="text/javascript" src="lib/slick/slick.min.js"></script>
<script type="text/javascript" src="js/script.js"></script>
<script type="text/javascript" src="js/wUser-profile.js"></script>
</body>
</html>