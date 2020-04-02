<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:include page="/WEB-INF/commons/include_header_css.jsp"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Will-Stagram-My-Page</title>
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

<body>
	<div class="wrapper">
		<header>
			<div class="container">
				<div class="header-data">
					<div class="logo">
						<a href="index.html" title=""><img src="images/logo.png" alt=""></a>
					</div><!--logo end-->
					<div class="search-bar">
						<form>
							<input type="text" name="search" placeholder="Search...">
							<button type="submit"><i class="la la-search"></i></button>
						</form>
					</div><!--search-bar end-->
					<nav>
						<ul>
							<li>
								<a href="index.html" title="">
									<span><img src="images/icon1.png" alt=""></span>
									Home
								</a>
							</li>
							<li>
								<a href="companies.html" title="">
									<span><img src="images/icon2.png" alt=""></span>
									Companies
								</a>
								<ul>
									<li><a href="companies.html" title="">Companies</a></li>
									<li><a href="company-profile.html" title="">Company Profile</a></li>
								</ul>
							</li>
							<li>
								<a href="projects.html" title="">
									<span><img src="images/icon3.png" alt=""></span>
									Projects
								</a>
							</li>
							<li>
								<a href="profiles.html" title="">
									<span><img src="images/icon4.png" alt=""></span>
									Profiles
								</a>
								<ul>
								<!-- 	<li><a href="user-profile.html" title="">User Profile</a></li> -->
									<li><a href="my-profile-feed.html" title="">my-profile-feed</a></li>
								</ul>
							</li>
							<li>
								<a href="jobs.html" title="">
									<span><img src="images/icon5.png" alt=""></span>
									Jobs
								</a>
							</li>
							<li>
								<a href="#" title="" class="not-box-openm">
									<span><img src="images/icon6.png" alt=""></span>
									Messages
								</a>
								<div class="notification-box msg" id="message">
									<div class="nt-title">
										<h4>Setting</h4>
										<a href="#" title="">Clear all</a>
									</div>
									<div class="nott-list">
										<div class="notfication-details">
							  				<div class="noty-user-img">
							  					<img src="images/resources/ny-img1.png" alt="">
							  				</div>
							  				<div class="notification-info">
							  					<h3><a href="messages.html" title="">Jassica William</a> </h3>
							  					<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do.</p>
							  					<span>2 min ago</span>
							  				</div><!--notification-info -->
						  				</div>
						  				<div class="notfication-details">
							  				<div class="noty-user-img">
							  					<img src="images/resources/ny-img2.png" alt="">
							  				</div>
							  				<div class="notification-info">
							  					<h3><a href="messages.html" title="">Jassica William</a></h3>
							  					<p>Lorem ipsum dolor sit amet.</p>
							  					<span>2 min ago</span>
							  				</div><!--notification-info -->
						  				</div>
						  				<div class="notfication-details">
							  				<div class="noty-user-img">
							  					<img src="images/resources/ny-img3.png" alt="">
							  				</div>
							  				<div class="notification-info">
							  					<h3><a href="messages.html" title="">Jassica William</a></h3>
							  					<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempo incididunt ut labore et dolore magna aliqua.</p>
							  					<span>2 min ago</span>
							  				</div><!--notification-info -->
						  				</div>
						  				<div class="view-all-nots">
						  					<a href="messages.html" title="">View All Messsages</a>
						  				</div>
									</div><!--nott-list end-->
								</div><!--notification-box end-->
							</li>
							<li>
								<a href="#" title="" class="not-box-open">
									<span><img src="images/icon7.png" alt=""></span>
									Notification
								</a>
								<div class="notification-box noti" id="notification">
									<div class="nt-title">
										<h4>Setting</h4>
										<a href="#" title="">Clear all</a>
									</div>
									<div class="nott-list">
										<div class="notfication-details">
							  				<div class="noty-user-img">
							  					<img src="images/resources/ny-img1.png" alt="">
							  				</div>
							  				<div class="notification-info">
							  					<h3><a href="#" title="">Jassica William</a> Comment on your project.</h3>
							  					<span>2 min ago</span>
							  				</div><!--notification-info -->
						  				</div>
						  				<div class="notfication-details">
							  				<div class="noty-user-img">
							  					<img src="images/resources/ny-img2.png" alt="">
							  				</div>
							  				<div class="notification-info">
							  					<h3><a href="#" title="">Jassica William</a> Comment on your project.</h3>
							  					<span>2 min ago</span>
							  				</div><!--notification-info -->
						  				</div>
						  				<div class="notfication-details">
							  				<div class="noty-user-img">
							  					<img src="images/resources/ny-img3.png" alt="">
							  				</div>
							  				<div class="notification-info">
							  					<h3><a href="#" title="">Jassica William</a> Comment on your project.</h3>
							  					<span>2 min ago</span>
							  				</div><!--notification-info -->
						  				</div>
						  				<div class="notfication-details">
							  				<div class="noty-user-img">
							  					<img src="images/resources/ny-img2.png" alt="">
							  				</div>
							  				<div class="notification-info">
							  					<h3><a href="#" title="">Jassica William</a> Comment on your project.</h3>
							  					<span>2 min ago</span>
							  				</div><!--notification-info -->
						  				</div>
						  				<div class="view-all-nots">
						  					<a href="#" title="">View All Notification</a>
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
							<img src="images/resources/ginbeenmin.png" alt="">
							<a href="#" title="">John</a>
							<i class="la la-sort-down"></i>
						</div>
						<div class="user-account-settingss">
							<h3>Online Status</h3>
							<ul class="on-off-status">
								<li>
									<div class="fgt-sec">
										<input type="radio" name="cc" id="c5">
										<label for="c5">
											<span></span>
										</label>
										<small>Online</small>
									</div>
								</li>
								<li>
									<div class="fgt-sec">
										<input type="radio" name="cc" id="c6">
										<label for="c6">
											<span></span>
										</label>
										<small>Offline</small>
									</div>
								</li>
							</ul>
							<h3>Custom Status</h3>
							<div class="search_form">
								<form>
									<input type="text" name="search">
									<button type="submit">Ok</button>
								</form>
							</div><!--search_form end-->
							<h3>Setting</h3>
							<ul class="us-links">
								<li><a href="profile-account-setting.html" title="">Account Setting</a></li>
								<li><a href="#" title="">Privacy</a></li>
								<li><a href="#" title="">Faqs</a></li>
								<li><a href="#" title="">Terms & Conditions</a></li>
							</ul>
							<h3 class="tc"><a href="sign-in.html" title="">Logout</a></h3>
						</div><!--user-account-settingss end-->
					</div>
				</div><!--header-data end-->
			</div>
		</header><!--header end-->		


		<section class="cover-sec">
			<img src="images/resources/cover-img.jpg" alt="">
			<div class="add-pic-box">
				<div class="container">
					<div class="row no-gutters">
						<div class="col-lg-12 col-sm-12">					
							<input type="file" id="file">
							<label for="file">Change Image</label>				
						</div>
					</div>
				</div>
			</div>
		</section>


		<main>
			<div class="main-section">
				<div class="container">
					<div class="main-section-data">
						<div class="row">
							<div class="col-lg-3">
								<div class="main-left-sidebar">
									<div class="user_profile">
										<div class="user-pro-img">
											<img src="images/resources/user-pro-img.png" alt="">
											<div class="add-dp" id="OpenImgUpload">
												<input type="file" id="file">
												<label for="file"><i class="fas fa-camera"></i></label>												
											</div>
										</div><!--user-pro-img end-->
										<div class="user_pro_status">
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
										<!-- <ul class="social_links">
											<li><a href="#" title=""><i class="la la-globe"></i> www.example.com</a></li>
											<li><a href="#" title=""><i class="fa fa-facebook-square"></i> Http://www.facebook.com/john...</a></li>
											<li><a href="#" title=""><i class="fa fa-twitter"></i> Http://www.Twitter.com/john...</a></li>
											<li><a href="#" title=""><i class="fa fa-google-plus-square"></i> Http://www.googleplus.com/john...</a></li>
											<li><a href="#" title=""><i class="fa fa-behance-square"></i> Http://www.behance.com/john...</a></li>
											<li><a href="#" title=""><i class="fa fa-pinterest"></i> Http://www.pinterest.com/john...</a></li>
											<li><a href="#" title=""><i class="fa fa-instagram"></i> Http://www.instagram.com/john...</a></li>
											<li><a href="#" title=""><i class="fa fa-youtube"></i> Http://www.youtube.com/john...</a></li>
										</ul> -->
									</div><!--user_profile end-->
									<div class="suggestions full-width">
										<div class="sd-title">
											<h3>People Viewed Profile</h3>
											<i class="la la-ellipsis-v"></i>
										</div><!--sd-title end-->
										<div class="suggestions-list">
											<div class="suggestion-usd">
												<img src="images/resources/s1.png" alt="">
												<div class="sgt-text">
													<h4>Jessica William</h4>
													<span>Graphic Designer</span>
												</div>
												<span><i class="la la-plus"></i></span>
											</div>
											<div class="suggestion-usd">
												<img src="images/resources/s2.png" alt="">
												<div class="sgt-text">
													<h4>John Doe</h4>
													<span>PHP Developer</span>
												</div>
												<span><i class="la la-plus"></i></span>
											</div>
											<div class="suggestion-usd">
												<img src="images/resources/s3.png" alt="">
												<div class="sgt-text">
													<h4>Poonam</h4>
													<span>Wordpress Developer</span>
												</div>
												<span><i class="la la-plus"></i></span>
											</div>
											<div class="suggestion-usd">
												<img src="images/resources/s4.png" alt="">
												<div class="sgt-text">
													<h4>Bill Gates</h4>
													<span>C & C++ Developer</span>
												</div>
												<span><i class="la la-plus"></i></span>
											</div>
											<div class="suggestion-usd">
												<img src="images/resources/s5.png" alt="">
												<div class="sgt-text">
													<h4>Jessica William</h4>
													<span>Graphic Designer</span>
												</div>
												<span><i class="la la-plus"></i></span>
											</div>
											<div class="suggestion-usd">
												<img src="images/resources/s6.png" alt="">
												<div class="sgt-text">
													<h4>John Doe</h4>
													<span>PHP Developer</span>
												</div>
												<span><i class="la la-plus"></i></span>
											</div>
											<div class="view-more">
												<a href="#" title="">View More</a>
											</div>
										</div><!--suggestions-list end-->
									</div><!--suggestions end-->
								</div><!--main-left-sidebar end-->
							</div>
							<div class="col-lg-6">
								<div class="main-ws-sec">
									<div class="user-tab-sec rewivew">
										<h3>찐빵맨</h3>
										<div class="star-descp">
											<span>Graphic Designer at Self Employed</span>
											<ul>
												<li><i class="fa fa-star"></i></li>
												<li><i class="fa fa-star"></i></li>
												<li><i class="fa fa-star"></i></li>
												<li><i class="fa fa-star"></i></li>
												<li><i class="fa fa-star-half-o"></i></li>
											</ul>
											<a href="#" title="">Status</a>
										</div><!--star-descp end-->
                                            <div class="tab-feed st2 settingjb">
											<ul>
												<li data-tab="feed-dd" class="active">
													<a href="#" title="">
														<img src="images/ic1.png" alt="">
														<span>Feed</span>
													</a>
												</li>
												<li data-tab="info-dd">
													<a href="#" title="">
														<img src="images/ic2.png" alt="">
														<span>Info</span>
													</a>
								<!-- 				</li>
												<li data-tab="saved-jobs">
													<a href="#" title="">
														<img src="images/ic4.png" alt="">
														<span>Jobs</span>
													</a>
												</li>
												<li data-tab="my-bids">
													<a href="#" title="">
														<img src="images/ic5.png" alt="">
														<span>Bids</span>
													</a>
												</li>
												<li data-tab="portfolio-dd">
													<a href="#" title="">
														<img src="images/ic3.png" alt="">
														<span>Portfolio</span>
													</a>
												</li>
												<li data-tab="rewivewdata">
													<a href="#" title="">
														<img src="images/review.png" alt="">
														<span>Reviews</span>
													</a>
												</li>
												<li data-tab="payment-dd">
													<a href="#" title="">
														<img src="images/ic6.png" alt="">
														<span>Payment</span>
													</a>
												</li> -->
												
											</ul>
										</div><!-- tab-feed end-->
									</div><!--user-tab-sec end-->
									<div class="product-feed-tab" id="saved-jobs">
										<ul class="nav nav-tabs" id="myTab" role="tablist">
                                           <li class="nav-item">
                                             <a class="nav-link active" id="mange-tab" data-toggle="tab" href="#mange" role="tab" aria-controls="home" aria-selected="true">Manage Jobs</a>
                                           </li>
                                           <li class="nav-item">
                                             <a class="nav-link" id="saved-tab" data-toggle="tab" href="#saved" role="tab" aria-controls="profile" aria-selected="false">Saved Jobs</a>
                                           </li>
                                           <li class="nav-item">
                                             <a class="nav-link" id="contact-tab" data-toggle="tab" href="#applied" role="tab" aria-controls="applied" aria-selected="false">Applied Jobs</a>
                                           </li>
                                           <li class="nav-item">
                                             <a class="nav-link" id="cadidates-tab" data-toggle="tab" href="#cadidates" role="tab" aria-controls="contact" aria-selected="false">Applied cadidates</a>
                                           </li>
                                         </ul>
                                         <div class="tab-content" id="myTabContent">
                                         <div class="tab-pane fade show active" id="mange" role="tabpanel" aria-labelledby="mange-tab">
                                                <div class="posts-bar">
                                                    <div class="post-bar bgclr">
                                                        <div class="wordpressdevlp">
                                                            <h2>Senior Wordpress Developer</h2>
                                                           
                                                            <p><i class="la la-clock-o"></i>Posted on 30 August 2018</p>
                                                        </div>
                                                        <br>
                                                        <div class="row no-gutters">
                                                            <div class="col-md-6 col-sm-12">
                                                                <div class="cadidatesbtn">
                                                                    <button type="button" class="btn btn-primary">
                                                                        <span class="badge badge-light">3</span>Candidates
                                                                    </button>
                                                                    <a href="#">
																		<i class="far fa-edit"></i>
                                                                    </a>
                                                                    <a href="#">
                                                                        <i class="far fa-trash-alt"></i>
                                                                    </a>
                                                                </div>
                                                            </div>
                                                            <div class="col-md-6 col-sm-12">
                                                                <ul class="bk-links bklink">
                                                                    <li><a href="#" title=""><i class="la la-bookmark"></i></a></li>
                                                                    <li><a href="#" title=""><i class="la la-envelope"></i></a></li>
                                                                </ul>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="posts-bar">
                                                    <div class="post-bar bgclr">
                                                        <div class="wordpressdevlp">
                                                            <h2>Senior Php Developer</h2>
                                                            
                                                            <p><i class="la la-clock-o"></i> Posted on 29 August 2018</p>
                                                        </div>
                                                        <br>
                                                        <div class="row no-gutters">
                                                            <div class="col-md-6 col-sm-12">
                                                                <div class="cadidatesbtn">
                                                                    <button type="button" class="btn btn-primary">
                                                                        <span class="badge badge-light">3</span>Candidates
                                                                    </button>
																	<a href="#">
																		<i class="far fa-edit"></i>
                                                                    </a>
                                                                    <a href="#">
                                                                        <i class="far fa-trash-alt"></i>
                                                                    </a>
                                                                </div>
                                                            </div>
                                                            <div class="col-md-6 col-sm-12">
                                                                <ul class="bk-links bklink">
                                                                    <li><a href="#" title=""><i class="la la-bookmark"></i></a></li>
                                                                    <li><a href="#" title=""><i class="la la-envelope"></i></a></li>
                                                                </ul>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="posts-bar">
                                                    <div class="post-bar bgclr">
                                                        <div class="wordpressdevlp">
                                                            <h2>Senior UI UX Designer</h2>
                                                          
                                                            <div class="row no-gutters">
                                                                <div class="col-md-6 col-sm-12">
                                                                    <p class="posttext"><i class="la la-clock-o"></i>Posted on 5 June 2018</p>
                                                                </div>
                                                                <div class="col-md-6 col-sm-12">
                                                                    <p><i class="la la-clock-o"></i>Expiried on 5 October 2018</p>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <br>
                                                        <div class="row no-gutters">
                                                            <div class="col-md-6 col-sm-12">
                                                                <div class="cadidatesbtn">
                                                                    <button type="button" class="btn btn-primary">
                                                                        <span class="badge badge-light">3</span>Candidates
                                                                    </button>																	
                                                                    <a href="#">
                                                                        <i class="far fa-trash-alt"></i>
                                                                    </a>
                                                                </div>
                                                            </div>
                                                            <div class="col-md-6 col-sm-12">
                                                                <ul class="bk-links bklink">
                                                                    <li><a href="#" title=""><i class="la la-bookmark"></i></a></li>
                                                                    <li><a href="#" title=""><i class="la la-envelope"></i></a></li>
                                                                </ul>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="tab-pane fade" id="saved" role="tabpanel" aria-labelledby="saved-tab">
                                                <div class="post-bar">
                                                    <div class="p-all saved-post">
                                                        <div class="usy-dt">
                                                            <div class="wordpressdevlp">
                                                                <h2>Senior Wordpress Developer</h2>
                                                              
                                                                <p><i class="la la-clock-o"></i>Posted on 30 August 2018</p>
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
                                                    <ul class="savedjob-info saved-info">
                                                        <li>
                                                            <h3>Applicants</h3>
                                                            <p>10</p>
                                                        </li>
                                                        <li>
                                                            <h3>Job Type</h3>
                                                            <p>Full Time</p>
                                                        </li>
                                                        <li>
                                                            <h3>Salary</h3>
                                                            <p>$600 - Mannual</p>
                                                        </li>
                                                        <li>
                                                            <h3>Posted : 5 Days Ago</h3>
                                                            <p>Open</p>
                                                        </li>
                                                        <div class="devepbtn saved-btn">
                                                            <a class="clrbtn" href="#">Unsaved</a>
                                                            <a class="clrbtn" href="#">Message</a>
                                                        </div>
                                                    </ul>
                                                </div>
                                                <div class="post-bar">
                                                    <div class="p-all saved-post">
                                                        <div class="usy-dt">
                                                            <div class="wordpressdevlp">
                                                                <h2>Senior PHP Developer</h2>
                                                                
                                                                <p><i class="la la-clock-o"></i>Posted on 30 August 2018</p>
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
                                                    <ul class="savedjob-info saved-info">
                                                        <li>
                                                            <h3>Applicants</h3>
                                                            <p>10</p>
                                                        </li>
                                                        <li>
                                                            <h3>Job Type</h3>
                                                            <p>Full Time</p>
                                                        </li>
                                                        <li>
                                                            <h3>Salary</h3>
                                                            <p>$600 - Mannual</p>
                                                        </li>
                                                        <li>
                                                            <h3>Posted : 5 Days Ago</h3>
                                                            <p>Open</p>
                                                        </li>
                                                        <div class="devepbtn saved-btn">
                                                            <a class="clrbtn" href="#">Unsaved</a>
                                                            <a class="clrbtn" href="#">Message</a>
                                                        </div>
                                                    </ul>
                                                </div>
                                                <div class="post-bar">
                                                    <div class="p-all saved-post">
                                                        <div class="usy-dt">
                                                            <div class="wordpressdevlp">
                                                                <h2>UI UX Designer</h2>
                                                               
                                                                <p><i class="la la-clock-o"></i>Posted on 30 August 2018</p>
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
                                                    <ul class="savedjob-info saved-info">
                                                        <li>
                                                            <h3>Applicants</h3>
                                                            <p>10</p>
                                                        </li>
                                                        <li>
                                                            <h3>Job Type</h3>
                                                            <p>Full Time</p>
                                                        </li>
                                                        <li>
                                                            <h3>Salary</h3>
                                                            <p>$600 - Mannual</p>
                                                        </li>
                                                        <li>
                                                            <h3>Posted : 5 Days Ago</h3>
                                                            <p>Open</p>
                                                        </li>
                                                        <div class="devepbtn saved-btn">
                                                            <a class="clrbtn" href="#">Unsaved</a>
                                                            <a class="clrbtn" href="#">Message</a>
                                                        </div>
                                                    </ul>
                                                </div>
                                            </div>
                                            <div class="tab-pane fade" id="applied" role="tabpanel" aria-labelledby="applied-tab">
                                                <div class="post-bar">
                                                    <div class="p-all saved-post">
                                                        <div class="usy-dt">
                                                            <div class="wordpressdevlp">
                                                                <h2>Senior Wordpress Developer</h2>
                                                                
                                                                <p><i class="la la-clock-o"></i>Posted on 30 August 2018</p>
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
                                                    <ul class="savedjob-info saved-info">
                                                        <li>
                                                            <h3>Applicants</h3>
                                                            <p>10</p>
                                                        </li>
                                                        <li>
                                                            <h3>Job Type</h3>
                                                            <p>Full Time</p>
                                                        </li>
                                                        <li>
                                                            <h3>Salary</h3>
                                                            <p>$600 - Mannual</p>
                                                        </li>
                                                        <li>
                                                            <h3>Posted : 5 Days Ago</h3>
                                                            <p>Open</p>
                                                        </li>
                                                        <div class="devepbtn saved-btn">
                                                            <a class="clrbtn" href="#">Applied</a>
                                                            <a class="clrbtn" href="#">Message</a>
                                                            <a href="#">
                                                                <i class="far fa-trash-alt"></i>
                                                            </a>
                                                        </div>
                                                    </ul>
                                                </div>
                                                <div class="post-bar">
                                                    <div class="p-all saved-post">
                                                        <div class="usy-dt">
                                                            <div class="wordpressdevlp">
                                                                <h2>Senior PHP Developer</h2>
                                                                
                                                                <p><i class="la la-clock-o"></i>Posted on 30 August 2018</p>
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
                                                    <ul class="savedjob-info saved-info">
                                                        <li>
                                                            <h3>Applicants</h3>
                                                            <p>10</p>
                                                        </li>
                                                        <li>
                                                            <h3>Job Type</h3>
                                                            <p>Full Time</p>
                                                        </li>
                                                        <li>
                                                            <h3>Salary</h3>
                                                            <p>$600 - Mannual</p>
                                                        </li>
                                                        <li>
                                                            <h3>Posted : 5 Days Ago</h3>
                                                            <p>Open</p>
                                                        </li>
                                                        <div class="devepbtn saved-btn">
                                                            <a class="clrbtn" href="#">Applied</a>
                                                            <a class="clrbtn" href="#">Message</a>
                                                            <a href="#">
                                                                <i class="far fa-trash-alt"></i>
                                                            </a>
                                                        </div>
                                                    </ul>
                                                </div>
                                                <div class="post-bar">
                                                    <div class="p-all saved-post">
                                                        <div class="usy-dt">
                                                            <div class="wordpressdevlp">
                                                                <h2>UI UX Designer</h2>
                                                               
                                                                <p><i class="la la-clock-o"></i>Posted on 30 August 2018</p>
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
                                                    <ul class="savedjob-info saved-info">
                                                        <li>
                                                            <h3>Applicants</h3>
                                                            <p>10</p>
                                                        </li>
                                                        <li>
                                                            <h3>Job Type</h3>
                                                            <p>Full Time</p>
                                                        </li>
                                                        <li>
                                                            <h3>Salary</h3>
                                                            <p>$600 - Mannual</p>
                                                        </li>
                                                        <li>
                                                            <h3>Posted : 5 Days Ago</h3>
                                                            <p>Open</p>
                                                        </li>
                                                        <div class="devepbtn saved-btn">
                                                            <a class="clrbtn" href="#">Applied</a>
                                                            <a class="clrbtn" href="#">Message</a>
                                                            <a href="#">
                                                                <i class="far fa-trash-alt"></i>
                                                            </a>
                                                        </div>
                                                    </ul>
                                                </div>
                                            </div>
                                            <div class="tab-pane fade" id="cadidates" role="tabpanel" aria-labelledby="cadidates-tab">
                                                <div class="post-bar">
                                                    <div class="post_topbar applied-post">
                                                        <div class="usy-dt">
                                                            <img src="images/resources/us-pic.png" alt="">
                                                            <div class="usy-name">
                                                                <h3>John Doe</h3>
                                                                <div class="epi-sec epi2">
                                                                    <ul class="descp descptab bklink">
                                                                        <li><img src="images/icon8.png" alt=""><span>Epic Coder</span></li>
                                                                        <li><img src="images/icon9.png" alt=""><span>India</span></li>
                                                                    </ul>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="ed-opts">
                                                            <a href="#" title="" class="ed-opts-open"><i class="la la-ellipsis-v"></i></a>
                                                            <ul class="ed-options">
                                                                <li><a href="#" title="">Edit Post</a></li>
                                                                <li><a href="#" title="">Accept</a></li>
                                                                <li><a href="#" title="">Unbid</a></li>
                                                                <li><a href="#" title="">Close</a></li>
                                                                <li><a href="#" title="">Hide</a></li>
                                                            </ul>
                                                        </div>
                                                        <div class="job_descp noborder">
                                                            <div class="star-descp review profilecnd">
                                                                <ul class="bklik">
                                                                    <li><i class="fa fa-star"></i></li>
                                                                    <li><i class="fa fa-star"></i></li>
                                                                    <li><i class="fa fa-star"></i></li>
                                                                    <li><i class="fa fa-star"></i></li>
                                                                    <li><i class="fa fa-star-half-o"></i></li>
                                                                    <a href="#" title="">5.0 of 5 Reviews</a>
                                                                </ul>
                                                            </div>
                                                            <div class="devepbtn appliedinfo noreply">
                                                                <a class="clrbtn" href="#">Accept</a>
                                                                <a class="clrbtn" href="#">View Profile</a>
                                                                <a class="clrbtn" href="#">Message</a>
                                                                <a href="#">
                                                                    <i class="far fa-trash-alt"></i>
                                                                </a>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="post-bar">
                                                    <div class="post_topbar  applied-post">
                                                        <div class="usy-dt">
                                                            <img src="images/resources/us-pic.png" alt="">
                                                            <div class="usy-name">
                                                                <h3>John Doe</h3>
                                                                <div class="epi-sec epi2">
                                                                    <ul class="descp descptab bklink">
                                                                        <li><img src="images/icon8.png" alt=""><span>Epic Coder</span></li>
                                                                        <li><img src="images/icon9.png" alt=""><span>India</span></li>
                                                                    </ul>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="ed-opts">
                                                            <a href="#" title="" class="ed-opts-open"><i class="la la-ellipsis-v"></i></a>
                                                            <ul class="ed-options">
                                                                <li><a href="#" title="">Edit Post</a></li>
                                                                <li><a href="#" title="">Accept</a></li>
                                                                <li><a href="#" title="">Unbid</a></li>
                                                                <li><a href="#" title="">Close</a></li>
                                                                <li><a href="#" title="">Hide</a></li>
                                                            </ul>
                                                        </div>
                                                        <div class="job_descp noborder">
                                                            <div class="star-descp review profilecnd">
                                                                <ul class="bklik">
                                                                    <li><i class="fa fa-star"></i></li>
                                                                    <li><i class="fa fa-star"></i></li>
                                                                    <li><i class="fa fa-star"></i></li>
                                                                    <li><i class="fa fa-star"></i></li>
                                                                    <li><i class="fa fa-star-half-o"></i></li>
                                                                    <a href="#" title="">5.0 of 5 Reviews</a>
                                                                </ul>
                                                            </div>
                                                            <div class="devepbtn appliedinfo noreply">
                                                                <a class="clrbtn" href="#">Accept</a>
                                                                <a class="clrbtn" href="#">View Profile</a>
                                                                <a class="clrbtn" href="#">Message</a>
                                                                <a href="#">
                                                                    <i class="far fa-trash-alt"></i>
                                                                </a>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="post-bar">
                                                    <div class="post_topbar applied-post">
                                                        <div class="usy-dt">
                                                            <img src="images/resources/us-pic.png" alt="">
                                                            <div class="usy-name">
                                                                <h3>John Doe</h3>
                                                                <div class="epi-sec epi2">
                                                                    <ul class="descp descptab bklink">
                                                                        <li><img src="images/icon8.png" alt=""><span>Epic Coder</span></li>
                                                                        <li><img src="images/icon9.png" alt=""><span>India</span></li>
                                                                    </ul>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="ed-opts">
                                                            <a href="#" title="" class="ed-opts-open"><i class="la la-ellipsis-v"></i></a>
                                                            <ul class="ed-options">
                                                                <li><a href="#" title="">Edit Post</a></li>
                                                                <li><a href="#" title="">Accept</a></li>
                                                                <li><a href="#" title="">Unbid</a></li>
                                                                <li><a href="#" title="">Close</a></li>
                                                                <li><a href="#" title="">Hide</a></li>
                                                            </ul>
                                                        </div>
                                                        <div class="job_descp noborder">
                                                            <div class="star-descp review profilecnd">
                                                                <ul class="bklik">
                                                                    <li><i class="fa fa-star"></i></li>
                                                                    <li><i class="fa fa-star"></i></li>
                                                                    <li><i class="fa fa-star"></i></li>
                                                                    <li><i class="fa fa-star"></i></li>
                                                                    <li><i class="fa fa-star-half-o"></i></li>
                                                                    <a href="#" title="">5.0 of 5 Reviews</a>
                                                                </ul>
                                                            </div>
                                                            <div class="devepbtn appliedinfo noreply">
                                                                <a class="clrbtn" href="#">Accept</a>
                                                                <a class="clrbtn" href="#">View Profile</a>
                                                                <a class="clrbtn" href="#">Message</a>
                                                                <a href="#">
                                                                   <i class="far fa-trash-alt"></i>
                                                                </a>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>	
                                         </div>
									</div>
									<div class="product-feed-tab current" id="feed-dd">
										<div class="posts-section">
										
										
										<!-- post-bar가 반복되면 됨 -->
								<c:forEach var="post" items="${postList}">
								
										<div class="post-bar" post_no="${post.pNo}">
											<div class="post_topbar">
												<div class="usy-dt">
													<img src="contents/member_image/${post.mImage}" width=40px height=40px>
													<div class="usy-name">
														<h3>${post.mName}</h3>
														<span><img src="images/clock.png" alt="">${post.aGo}</span>
													</div>
												</div>
												<div class="ed-opts">
													<a href="#" title="" class="ed-opts-open"><i class="la la-ellipsis-v"></i></a>
													<!-- 이 포스트가 내꺼인 경우에만 보여주는 메뉴 -->
													<c:if test="${post.mId!=sessionScope.loginId}">
														<ul class="ed-options">
															<li><a class="updatePost" href="#" title="">Edit Post</a></li>
															<li><a class="deletePost" href="#" title="">Unsaved</a></li>
															<li><a class="hiddenPost" href="#" title="">
															<c:if test="${post.status=='A'}">Hide</c:if>
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
															src="contents/post_contents/${post.fileName}" alt="여기에이미지들어옴"
															width="500" height="300" >
													</div>
												</c:if>
												<c:if test="${fn:startsWith(post.fileName, 'mov')}">
													<div class="embed-responsive embed-responsive-4by3" style="margin-bottom:10px;" >
													  		<iframe class="embed-responsive-item" style="padding-top:10px;"
													  			src="contents/post_contents/${post.fileName}"></iframe>
													</div>
												</c:if>
											</div>
											<div class="job_descp">
												<h3>${post.pTitle}</h3>
												<p>${post.pContents}<a href="#" title="">view more</a></p>
												<ul class="skill-tags">
													<c:forEach var='tag' items="${post.tagArray}">
														<li><a href="#" title="">${tag}</a></li>
													</c:forEach>
											
												</ul>
											</div>
											<div class="job-status-bar">
													<ul class="like-com">
														<li><a href="#"><i class="fas fa-heart"></i> Like</a>
															<img src="images/liked-img.png" alt=""> <span>${post.likeCount}</span>
														</li>
														<!-- a: 누를 시 comment-section toggle-->
														<li><a href="#" class="com"> <i class="fas fa-comment-alt"></i> Comment 15</a></li>
													</ul>
													<a href="#"><i class="fas fa-eye"></i>Views
														${post.pViewCount}</a>
													<!-- comment-section-->
													<div class="comment-section"></div>
													<!--comment-section end-->
												</div>
												<!-- post-comment -->
												<div class="post-comment">
													<div class="cm_img">
														<img src="images/resources/bg-img4.png" alt="">
													</div>
													<div class="comment_box">
														<form id="comment-insert-form">
															<!-- 댓글 내용 쓰는 곳 -->
															<input type="text" placeholder="Post a comment"
																id="comment-cContent" name="comment-cContent">
															<button type="submit" id="comment-insert-button">Send</button>
														</form>
													</div>
												</div>
												<!--post-comment end-->
										</div><!--post-bar end-->
								</c:forEach>	
										</div><!--posty end-->
										
										
										
										
										</div><!--posts-section end-->
									</div><!--product-feed-tab end-->
									<div class="product-feed-tab" id="portfolio-dd">
										<div class="portfolio-gallery-sec">
											<h3>Portfolio</h3>
											<div class="portfolio-btn">
												<a href="#" title=""><i class="fas fa-plus-square"></i> Add Portfolio</a>
											</div>
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
									<div class="product-feed-tab" id="payment-dd">
										<div class="billing-method">
											<ul>
												<li>
													<h3>Add Billing Method</h3>
													<a href="#" title=""><i class="fa fa-plus-circle"></i></a>
												</li>
												<li>
													<h3>See Activity</h3>
													<a href="#" title="">View All</a>
												</li>
												<li>
													<h3>Total Money</h3>
													<span>$0.00</span>
												</li>
											</ul>
											<div class="lt-sec">
												<img src="images/lt-icon.png" alt="">
												<h4>All your transactions are saved here</h4>
												<a href="#" title="">Click Here</a>
											</div>
										</div><!--billing-method end-->
										<div class="add-billing-method">
											<h3>Add Billing Method</h3>
											<h4><img src="images/dlr-icon.png" alt=""><span>With workwise payment protection , only pay for work delivered.</span></h4>
											<div class="payment_methods">
												<h4>Credit or Debit Cards</h4>
												<form>
													<div class="row">
														<div class="col-lg-12">
															<div class="cc-head">
																<h5>Card Number</h5>
																<ul>
																	<li><img src="images/cc-icon1.png" alt=""></li>
																	<li><img src="images/cc-icon2.png" alt=""></li>
																	<li><img src="images/cc-icon3.png" alt=""></li>
																	<li><img src="images/cc-icon4.png" alt=""></li>
																</ul>
															</div>
															<div class="inpt-field pd-moree">
																<input type="text" name="cc-number" placeholder="">
																<i class="fa fa-credit-card"></i>
															</div><!--inpt-field end-->
														</div>
														<div class="col-lg-6">
															<div class="cc-head">
																<h5>First Name</h5>
															</div>
															<div class="inpt-field">
																<input type="text" name="f-name" placeholder="">
															</div><!--inpt-field end-->
														</div>
														<div class="col-lg-6">
															<div class="cc-head">
																<h5>Last Name</h5>
															</div>
															<div class="inpt-field">
																<input type="text" name="l-name" placeholder="">
															</div><!--inpt-field end-->
														</div>
														<div class="col-lg-6">
															<div class="cc-head">
																<h5>Expiresons</h5>
															</div>
															<div class="rowwy">
																<div class="row">
																	<div class="col-lg-6 pd-left-none no-pd">
																		<div class="inpt-field">
																			<input type="text" name="f-name" placeholder="">
																		</div><!--inpt-field end-->
																	</div>
																	<div class="col-lg-6 pd-right-none no-pd">
																		<div class="inpt-field">
																			<input type="text" name="f-name" placeholder="">
																		</div><!--inpt-field end-->
																	</div>
																</div>
															</div>
														</div>
														<div class="col-lg-6">
															<div class="cc-head">
																<h5>Cvv (Security Code) <i class="fa fa-question-circle"></i></h5>
															</div>
															<div class="inpt-field">
																<input type="text" name="l-name" placeholder="">
															</div><!--inpt-field end-->
														</div>
														<div class="col-lg-12">
															<button type="submit">Continue</button>
														</div>
													</div>
												</form>
												<h4>Add Paypal Account</h4>
											</div>
										</div><!--add-billing-method end-->
									</div><!--product-feed-tab end-->
								</div><!--main-ws-sec end-->
							</div>
							<div class="col-lg-3">
								<div class="right-sidebar">
									<div class="message-btn">
										<a href="profile-account-setting.html" title=""><i class="fas fa-cog"></i> Setting</a>
									</div>
									<!--<div class="widget widget-portfolio">
										 <div class="wd-heady">
											<h3>Portfolio</h3>
											<img src="images/photo-icon.png" alt="">
										</div>
										<div class="pf-gallery">
											<ul>
												<li><a href="#" title=""><img src="images/resources/pf-gallery1.png" alt=""></a></li>
												<li><a href="#" title=""><img src="images/resources/pf-gallery2.png" alt=""></a></li>
												<li><a href="#" title=""><img src="images/resources/pf-gallery3.png" alt=""></a></li>
												<li><a href="#" title=""><img src="images/resources/pf-gallery4.png" alt=""></a></li>
												<li><a href="#" title=""><img src="images/resources/pf-gallery5.png" alt=""></a></li>
												<li><a href="#" title=""><img src="images/resources/pf-gallery6.png" alt=""></a></li>
												<li><a href="#" title=""><img src="images/resources/pf-gallery7.png" alt=""></a></li>
												<li><a href="#" title=""><img src="images/resources/pf-gallery8.png" alt=""></a></li>
												<li><a href="#" title=""><img src="images/resources/pf-gallery9.png" alt=""></a></li>
												<li><a href="#" title=""><img src="images/resources/pf-gallery10.png" alt=""></a></li>
												<li><a href="#" title=""><img src="images/resources/pf-gallery11.png" alt=""></a></li>
												<li><a href="#" title=""><img src="images/resources/pf-gallery12.png" alt=""></a></li>
											</ul>
										</div>pf-gallery end
									</div> --><!--widget-portfolio end-->
								</div><!--right-sidebar end-->
							</div>
						</div>
					</div><!-- main-section-data end-->
				</div> 
			</div>
		</main>

		 <jsp:include page="/WEB-INF/commons/include_footy_js.jsp"/>
			<!--footer end-->
		<div class="overview-box" id="overview-box">
			<div class="overview-edit">
				<h3>Overview</h3>
				<span>5000 character left</span>
				<form>
					<textarea></textarea>
					<button type="submit" class="save">Save</button>
					<button type="submit" class="cancel">Cancel</button>
				</form>
				<a href="#" title="" class="close-box"><i class="la la-close"></i></a>
			</div><!--overview-edit end-->
		</div><!--overview-box end-->


		<div class="overview-box" id="experience-box">
			<div class="overview-edit">
				<h3>Experience</h3>
				<form>
					<input type="text" name="subject" placeholder="Subject">
					<textarea></textarea>
					<button type="submit" class="save">Save</button>
					<button type="submit" class="save-add">Save & Add More</button>
					<button type="submit" class="cancel">Cancel</button>
				</form>
				<a href="#" title="" class="close-box"><i class="la la-close"></i></a>
			</div><!--overview-edit end-->
		</div><!--overview-box end-->

		<div class="overview-box" id="education-box">
			<div class="overview-edit">
				<h3>Education</h3>
				<form>
					<input type="text" name="school" placeholder="School / University">
					<div class="datepicky">
						<div class="row">
							<div class="col-lg-6 no-left-pd">
								<div class="datefm">
									<input type="text" name="from" placeholder="From" class="datepicker">	
									<i class="fa fa-calendar"></i>
								</div>
							</div>
							<div class="col-lg-6 no-righ-pd">
								<div class="datefm">
									<input type="text" name="to" placeholder="To" class="datepicker">
									<i class="fa fa-calendar"></i>
								</div>
							</div>
						</div>
					</div>
					<input type="text" name="degree" placeholder="Degree">
					<textarea placeholder="Description"></textarea>
					<button type="submit" class="save">Save</button>
					<button type="submit" class="save-add">Save & Add More</button>
					<button type="submit" class="cancel">Cancel</button>
				</form>
				<a href="#" title="" class="close-box"><i class="la la-close"></i></a>
			</div><!--overview-edit end-->
		</div><!--overview-box end-->

		<div class="overview-box" id="location-box">
			<div class="overview-edit">
				<h3>Location</h3>
				<form>
					<div class="datefm">
						<select>
							<option>Country</option>
							<option value="pakistan">Pakistan</option>
							<option value="england">England</option>
							<option value="india">India</option>
							<option value="usa">United Sates</option>
						</select>
						<i class="fa fa-globe"></i>
					</div>
					<div class="datefm">
						<select>
							<option>City</option>
							<option value="london">London</option>
							<option value="new-york">New York</option>
							<option value="sydney">Sydney</option>
							<option value="chicago">Chicago</option>
						</select>
						<i class="fa fa-map-marker"></i>
					</div>
					<button type="submit" class="save">Save</button>
					<button type="submit" class="cancel">Cancel</button>
				</form>
				<a href="#" title="" class="close-box"><i class="la la-close"></i></a>
			</div><!--overview-edit end-->
		</div><!--overview-box end-->

		<div class="overview-box" id="skills-box">
			<div class="overview-edit">
				<h3>Skills</h3>
				<ul>
					<li><a href="#" title="" class="skl-name">HTML</a><a href="#" title="" class="close-skl"><i class="la la-close"></i></a></li>
					<li><a href="#" title="" class="skl-name">php</a><a href="#" title="" class="close-skl"><i class="la la-close"></i></a></li>
					<li><a href="#" title="" class="skl-name">css</a><a href="#" title="" class="close-skl"><i class="la la-close"></i></a></li>
				</ul>
				<form>
					<input type="text" name="skills" placeholder="Skills">
					<button type="submit" class="save">Save</button>
					<button type="submit" class="save-add">Save & Add More</button>
					<button type="submit" class="cancel">Cancel</button>
				</form>
				<a href="#" title="" class="close-box"><i class="la la-close"></i></a>
			</div><!--overview-edit end-->
		</div><!--overview-box end-->

		<div class="overview-box" id="create-portfolio">
			<div class="overview-edit">
				<h3>Create Portfolio</h3>
				<form>
					<input type="text" name="pf-name" placeholder="Portfolio Name">
					<div class="file-submit">
						<input type="file" id="file">
						<label for="file">Choose File</label>	
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

<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/popper.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/jquery.mCustomScrollbar.js"></script>
<script type="text/javascript" src="lib/slick/slick.min.js"></script>
<script type="text/javascript" src="js/scrollbar.js"></script>
<script type="text/javascript" src="js/script.js"></script>
<script type="text/javascript" src="js/wPost.js"></script>

 <jsp:include page="/WEB-INF/commons/include_footer_js.jsp"/>
 </head>
</body>
</html>