<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title><s:message code="menu.title"/></title>
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
	<style>
		.user-profile-main {
			float: left;
	    	width: 100%;
	    	padding: 200px 0;
		}
		.modal-content { 
		 	position : fixed; 
		 	top : 15%; 
		 	left : calc(50% - 220px); 
		 	width : 420px; 
		 	height : 190px; 
		 	padding : 20px 10px; 
		 	background : #fff; 
		 	border : 2px solid #666; 
		 }
		 #modal_cContents { 
		 	font-size : 15px; 
		 	font-family : '맑은 고딕', verdana; 
		 	padding : 10px; 
		 	width : 395px; 
		 	height : 90px; 
		 }
	</style>
</head>
<!--comment-update modal-->
<div class="modal fade" id="updateCommentsModal" tabindex="-1" role="dialog" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-body">
       	<textarea id="modal_cContents" class="modal_cContents"></textarea>
      </div>
      <div class="modal-footer">
        <button type="button" id="updateCommentsBtn" class="btn btn-default"><s:message code="comments.Edit"/></button>
        <button type="button" class="btn btn-default" data-dismiss="modal"><s:message code="comments.Close"/></button>
      </div>
    </div>
  </div>
</div>
<!--comment-update modal end-->
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
									<div class="user_profile" mIdYou="${memberYou.mId}">
										<div class="user-pro-img">
										<c:choose>
											<c:when test="${memberYou.mImage==null}">
												<img src="contents/member_image/default.png" alt="">
											</c:when>	
											<c:otherwise >
												<img src="contents/member_image/${memberYou.mImage}" alt="">
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
													<b class="followings">${memberYou.followingCount}</b>
												</li>
												<li>
													<span>Followers</span>
													<b class="followers">${memberYou.followerCount}</b>
												</li>
											</ul>
										</div><!--user_pro_status end-->
									</div><!--user_profile end-->
									<div class="suggestions full-width">
										<div class="sd-title">
											<h3>친구추천</h3>
										</div><!--sd-title end-->
										<div class="suggestions-list">
											<c:forEach var="mList" items="${memberList}">
											
												<c:if test="${mList.mId!=sessionScope.mId }">
													<div class="suggestion-usd">
														<img src="contents/member_image/${mList.mImage}" alt="" width="40px">
														<div class="sgt-text">
															<h4><a href="user-profile?youId=${mList.mId}">${mList.mName}</a></h4>
															<span>${mList.mEmail}</span>
														</div>
														<span><i mid='${mList.mId}' class="la la-plus sFollow" ></i></span> 
													</div>
												</c:if>
											
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
										<h3>${memberYou.mName}</h3>
										<div class="star-descp">
											<span>${memberYou.mEmail}</span>
										</div><!--star-descp end-->
									</div><!--user-tab-sec end-->
									<div class="product-feed-tab current" id="feed-dd">
										<div class="posts-section">
										<c:forEach var="post" items="${postList}">
								
										<div class="post-bar" post_no="${post.pNo}">
											<div class="post_topbar">
												<div class="usy-dt">
													<c:choose>
														<c:when test="${post.mImage==null}">
															<img src="contents/member_image/default.png" width=40px height=40px>
														</c:when>
														<c:otherwise>
															<img src="contents/member_image/${post.mImage}" width=40px height=40px>
														</c:otherwise>
													</c:choose>
													<div class="usy-name">
														<h3>${post.mName}</h3>
														<span><img src="images/clock.png" alt="">${post.aGo}</span>
													</div>
												</div>
												<div class="ed-opts">
													<a href="#" title="" class="ed-opts-open"></a>
													<!-- 이 포스트가 내꺼인 경우에만 보여주는 메뉴 -->
													<c:if test="${post.mId!=sessionScope.loginId}">
														<ul class="ed-options">
															<li><a class="updatePost" href="#" title=""><s:message code="post.edit"/></a></li>
															<li><a class="deletePost" href="#" title=""><s:message code="post.delete"/></a></li>
															<li><a class="hiddenPost" href="#" title="">
															<c:if test="${post.status=='A'}"><s:message code="post.hide"/></c:if>
															<c:if test="${post.status=='H'}">Show</c:if>
															</a></li>
														</ul>
													</c:if>
												</div>
											</div>
											<!-- 여기에 사진(컨텐츠)들어옴 -->
											<div class="contents">
												<c:if test="${fn:startsWith(post.fileName, 'img')}">
													<div class="image">
														<img class="center-block" style="margin:10px 0px;"
															src="contents/post_image/${post.fileName}" alt="여기에이미지들어옴"
															width="500" height="300" >
													</div>
												</c:if>
												<c:if test="${fn:startsWith(post.fileName, 'mov')}">
													<div class="embed-responsive embed-responsive-4by3" style="margin-bottom:10px;" >
													  		<iframe class="embed-responsive-item" style="padding-top:10px;"
													  			src="contents/post_image/${post.fileName}"></iframe>
													</div>
												</c:if>
											</div>
											<div class="job_descp">
												<h3>${post.pTitle}</h3>
												<p>${post.pContents}<br><a href="#" title=""><s:message code="post.view"/></a></p>
												<ul class="skill-tags">
													<c:forEach var='tag' items="${post.tagArray}">
														<li><a href="#" title="">${tag}</a></li>
													</c:forEach>
											
												</ul>
											</div>
											<div class="job-status-bar">
												<ul class="like-com">
													<li><a href="#" class="like"><i class="fas fa-heart"></i> <s:message code="post.like"/></a>
														<img src="images/liked-img.png" alt=""> <span class='likeCount'>${post.likeCount}</span>
													</li>
													<li>
														<a href="#"  class="com comment_list_click" >
															<i class="fas fa-comment-alt"></i> <s:message code="post.comment"/>
														</a>
													</li>
												</ul>
												<a href="#"><i class="fas fa-eye"></i><s:message code="post.views"/>
														${post.pViewCount}</a>
											</div>
											
											<!-- comment-section -->
											<div class="comment-section">
													<!-- comment-sec -->
		
													<!-- post-comment -->
													<div class="post-comment">
														<div class="comment_box">
															<form class="comments_insert_form">
																<!-- 댓글 내용 쓰는 곳 -->
																<input type="text" placeholder="<s:message code='post.postComment'/>"
																	name="cContents" class="cContents">
																<input type="hidden" name="pNo" value="${post.pNo}" >
																<button type="button" class="comments_insert_button"><s:message code="post.commentSend"/></button>
															</form>
														</div>
													</div>
													<!--post-comment end-->
													<!--comment-sec end-->
											</div>
											<!--comment-section end-->
										</div>
										<!--post-bar end-->
									</c:forEach>	
								</div>
								<!--posty end-->
											<div class="process-comm">
												<div class="spinner">
													<div class="bounce1"></div>
													<div class="bounce2"></div>
													<div class="bounce3"></div>
												</div>
											</div><!--process-comm end-->
										</div><!--posts-section end-->
									</div><!--product-feed-tab end-->
								</div><!--main-ws-sec end-->
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
											</div>
											<div class="jobs-list">
												<c:forEach var="postRank" items="${postRankList}">
													<div class="job-info" post_no="${postRank.PNO}">
														<div class="job-details">
															<h3><a href="user-profile?youId=${postRank.MID}">${postRank.MNAME}</a></h3>
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

		<!-- 상세보기Modal  id="myModal"  tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true"-->
			<div class="post-popup post_deatil" >
			  
			</div>
	
		</div><!--theme-layout end-->



<script type="text/javascript" src="js/popper.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/flatpickr.min.js"></script>
<script type="text/javascript" src="lib/slick/slick.min.js"></script>
<script type="text/javascript" src="js/script.js"></script>
<script type="text/javascript" src="js/wUser-profile.js"></script>
<script type="text/javascript" src="js/wComments.js"></script>
</body>
</html>