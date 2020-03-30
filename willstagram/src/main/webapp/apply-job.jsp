<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="include_header_css.jsp"/>
<body>
<div class="modal" id="mymodal">
        <div class="modal-dialog">
            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
            <div class="modal-content">
                <div class="modal-header">
                    <h3 class="text-light text-center">Apply a Job</h3>
                </div>
                <div class="modal-body">
                    <div class="innerbody apply-jobbox">
                        <h3>Attach File With CV</h3>
                        <form>
                            <input type="text" placeholder="Full Name"><br>
                            <input type="email" placeholder="Email Address">
                        </form>
                        <div class="select-files">
                            <input type="file" class="custom-file-input">
                            <p>Upload your cv / resume file. Max file size : 3MB</p>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button class="place-bid-btn">Apply a Job</button>
                    <button>Cancel</button>
                </div>
            </div>
        </div>
    </div>
    <div class="wrapper">
        <jsp:include page="include_head_menu.jsp"/>
        <!--header end-->
        <main>
            <div class="main-section">
                <div class="container">
                    <div class="main-section-data">
                        <div class="row">
                            <div class="col-xl-9 col-lg-9 col-md-12">
                                <div class="bids-detail">
                                    <div class="row">
                                        <div class="col-12 appliedjob">
                                            <ul>
                                                <li>
                                                    <h3>Applicants</h3>
                                                    <br>
                                                    <p>10</p>
                                                </li>
                                                <li>
                                                    <h3>Job Type</h3>
                                                    <br>
                                                    <p>Full Time</p>
                                                </li>
                                                <li>
                                                    <h3>Salary</h3>
                                                    <br>
                                                    <p>$600 - Mannual</p>
                                                </li>
                                                <li>
                                                    <h3>Views</h3>
                                                    <br>
                                                    <p>195</p>
                                                </li>
                                            </ul>
                                            <div class="bids-time">
                                               <h3>Posted : 5 Days Ago</h3>
                                                    <br>
                                                    <p>Open</p> 
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="main-ws-sec">
                                    <div class="posts-section">
                                        <div class="post-bar">
                                            <div class="post_topbar">
                                                <div class="usy-dt">
                                                    <img src="images/resources/bg-img2.png" alt="">
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
                                            <div class="job_descp accountnone">
                                                <h3>Senior Wordpress Developer</h3>
                                                <ul class="job-dt">
                                                    <li>
                                                        <a href="#">Full Time</a>
                                                    </li>
                                                    <li><span>$600 / Mannual</span></li>
                                                </ul>
                                                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. In porttitor ligula et dolor dignissim, sit amet efficitur felis maximus. Suspendisse metus magna, tempus eu ultrices et, maximus id tellus. Ut eu lacinia ante, id facilisis enim. s. ut suscipit urna sollicitudin at...<a href="#" title="">view more</a></p>
                                                <ul class="skill-tags">
                                                    <li><a href="#" title="">HTML</a></li>
                                                    <li><a href="#" title="">PHP</a></li>
                                                    <li><a href="#" title="">CSS</a></li>
                                                    <li><a href="#" title="">Javascript</a></li>
                                                    <li><a href="#" title="">Wordpress</a></li>
                                                </ul>
                                            </div>
                                            <div class="job-status-bar btm-line">                                                
                                                <ul class="like-com">
                                                    <li>
                                                        <a href="#" class="active"><i class="fas fa-heart"></i> Like</a>
                                                        <img src="images/liked-img.png" alt="">
                                                        <span>25</span>
                                                    </li>
                                                    <li><a href="#" class="com"><i class="fas fa-comment-alt"></i> Comments 15</a></li>
                                                </ul>
                                                <a><i class="fas fa-eye"></i>Views 50</a>
                                            </div>
                                            <div class="comment-area">
                                                <i class="la la-plus-circle"></i>
                                                <div class="post_topbar">
                                                    <div class="usy-dt">
                                                        <img src="images/resources/bg-img1.png" alt="">
                                                        <div class="usy-name">
                                                            <h3>John Doe</h3>
                                                            <span><img src="images/clock.png" alt="">3 min ago</span>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="reply-area">
                                                    <p>Lorem ipsum dolor sit amet,</p>
                                                    <span><i class="la la-mail-reply"></i>Reply</span>
                                                    <div class="comment-area reply-rply1">
                                                        <div class="post_topbar">
                                                            <div class="usy-dt">
                                                                <img src="images/resources/bg-img2.png" alt="">
                                                                <div class="usy-name">
                                                                    <h3>John Doe</h3>
                                                                    <span><img src="images/clock.png" alt="">3 min ago</span>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="reply-area">
                                                            <p>Lorem ipsum dolor sit amet,</p>
                                                            <p>Hi John</p>
                                                            <span><i class="la la-mail-reply"></i>Reply</span>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="comment-area">
                                                <div class="post_topbar">
                                                    <div class="usy-dt">
                                                        <img src="images/resources/bg-img3.png" alt="">
                                                        <div class="usy-name">
                                                            <h3>John Doe</h3>
                                                            <span><img src="images/clock.png" alt="">3 min ago</span>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="reply-area">
                                                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam luctus hendrerit metus, ut ullamcorper quam finibus at.</p>
                                                    <span><i class="la la-mail-reply"></i>Reply</span>
                                                </div>
                                            </div>
                                            <div class="postcomment">
                                                <div class="row">
                                                    <div class="col-md-2">
                                                        <img src="images/resources/bg-img4.png" alt="">
                                                    </div>
                                                    <div class="col-md-8">
                                                        <form>
                                                            <div class="form-group">
                                                                <input type="text" class="form-control" id="inputPassword" placeholder="Post a comment">
                                                            </div>
                                                        </form>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <a href="#">Send</a>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <!--post-bar end-->
                                    </div>
                                    <!--posts-section end-->
                                </div>
                                <!--main-ws-sec end-->
                            </div>
                            <div class="col-xl-3 col-lg-3 col-md-12">
                                <div class="right-sidebar">
                                    <div class="widget widget-about bid-place">
                                        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#mymodal" data-whatever="@mdo">Apply a Job Now</button>
                                    </div>
                                    <!--widget-about end-->
                                    <div class="widget widget-projectid">
                                        <h3>Project ID : 123456789</h3>
                                        <p>Report Job</p>
                                    </div>
                                    <!--widget-about end-->
                                    <div class="widget widget-jobs">
                                        <div class="sd-title">
                                            <h3>About the Client</h3>
                                            <i class="la la-ellipsis-v"></i>
                                        </div>
                                        <div class="sd-title paymethd">
                                            <h4>Payment Method</h4>                                          
                                            <p>Verified</p>
                                            <ul class="star">
                                                <li><i class="fa fa-star"></i></li>
                                                <li><i class="fa fa-star"></i></li>
                                                <li><i class="fa fa-star"></i></li>
                                                <li><i class="fa fa-star"></i></li>
                                                <li><i class="fa fa-star-half-o"></i></li>
                                                <li>
                                                    <a>5.00 of 5 Reviews</a>
                                                </li>
                                            </ul>
                                        </div>
                                        <div class="sd-title">
                                            <h4>India</h4>                                            
                                            <p>SKS Nagar, Ludhiana 1 AM</p>
                                        </div>
                                        <div class="sd-title">
                                            <h4>20 Projects Posted | 15 Jobs Posted</h4>                                            
                                            <p>85% Hire Rate, 15% Open Jobs</p>
                                        </div>
                                        <div class="sd-title">
                                            <h4>Member Since</h4>                                            
                                            <p>August 24, 2017</p>
                                        </div>
                                    </div>
                                    <!--widget-jobs end-->
                                    <div class="widget widget-jobs">
                                        <div class="sd-title">
                                            <h3>Project Link</h3>
                                            <i class="la la-ellipsis-v"></i>
                                        </div>
                                        <div class="sd-title copylink">
                                            <P>Http://www.workwise.com/pro...</P>
                                            <span><a href="#">Copy Link</a></span>
                                        </div>
                                    </div>
                                    <!--widget-jobs end-->
                                    <div class="widget widget-jobs">
                                        <div class="sd-title">
                                            <h3>Share</h3>
                                        </div>
                                        <div class="sd-title copylink">
                                            <ul>
                                                <li>
                                                    <img src="images/social3.png" alt="image"> </li>
                                                <li>
                                                    <img src="images/social4.png" alt="image"></li>
                                                <li>
                                                    <img src="images/social1.png" alt="image"></li>
                                                <li>
                                                    <img src="images/social5.png" alt="image"></li>
                                                <li>
                                                    <img src="images/social2.png" alt="image"></li>
                                            </ul>
                                        </div>
                                    </div>
                                    <!--widget-jobs end-->
                                </div>
                                <!--right-sidebar end-->
                            </div>
                        </div>
                        <!-- freelancerbiding -->
                    </div>
                </div>
            </div>
        </main>
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
        <!--footer end-->
        <div class="post-popup pst-pj">
            <div class="post-project">
                <h3>Post a project</h3>
                <div class="post-project-fields">
                    <form>
                        <div class="row">
                            <div class="col-lg-12">
                                <input type="text" name="title" placeholder="Title">
                            </div>
                            <div class="col-lg-12">
                                <div class="inp-field">
                                    <select>
                                        <option>Category</option>
                                        <option>Category 1</option>
                                        <option>Category 2</option>
                                        <option>Category 3</option>
                                    </select>
                                </div>
                            </div>
                            <div class="col-lg-12">
                                <input type="text" name="skills" placeholder="Skills">
                            </div>
                            <div class="col-lg-12">
                                <div class="price-sec">
                                    <div class="price-br">
                                        <input type="text" name="price1" placeholder="Price">
                                        <i class="la la-dollar"></i>
                                    </div>
                                    <span>To</span>
                                    <div class="price-br">
                                        <input type="text" name="price1" placeholder="Price">
                                        <i class="la la-dollar"></i>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-12">
                                <textarea name="description" placeholder="Description"></textarea>
                            </div>
                            <div class="col-lg-12">
                                <ul>
                                    <li><button class="active" type="submit" value="post">Post</button></li>
                                    <li><a href="#" title="">Cancel</a></li>
                                </ul>
                            </div>
                        </div>
                    </form>
                </div>
                <!--post-project-fields end-->
                <a href="#" title=""><i class="la la-times-circle-o"></i></a>
            </div>
            <!--post-project end-->
        </div>
        <!--post-project-popup end-->
        <div class="post-popup job_post">
            <div class="post-project">
                <h3>Post a job</h3>
                <div class="post-project-fields">
                    <form>
                        <div class="row">
                            <div class="col-lg-12">
                                <input type="text" name="title" placeholder="Title">
                            </div>
                            <div class="col-lg-12">
                                <div class="inp-field">
                                    <select>
                                        <option>Category</option>
                                        <option>Category 1</option>
                                        <option>Category 2</option>
                                        <option>Category 3</option>
                                    </select>
                                </div>
                            </div>
                            <div class="col-lg-12">
                                <input type="text" name="skills" placeholder="Skills">
                            </div>
                            <div class="col-lg-6">
                                <div class="price-br">
                                    <input type="text" name="price1" placeholder="Price">
                                    <i class="la la-dollar"></i>
                                </div>
                            </div>
                            <div class="col-lg-6">
                                <div class="inp-field">
                                    <select>
                                        <option>Full Time</option>
                                        <option>Half time</option>
                                    </select>
                                </div>
                            </div>
                            <div class="col-lg-12">
                                <textarea name="description" placeholder="Description"></textarea>
                            </div>
                            <div class="col-lg-12">
                                <ul>
                                    <li><button class="active" type="submit" value="post">Post</button></li>
                                    <li><a href="#" title="">Cancel</a></li>
                                </ul>
                            </div>
                        </div>
                    </form>
                </div>
                <!--post-project-fields end-->
                <a href="#" title=""><i class="la la-times-circle-o"></i></a>
            </div>
            <!--post-project end-->
        </div>
        <!--post-project-popup end-->
    </div>
    <!--theme-layout end-->
<jsp:include page="include_js.jsp"/>
</body>

</html>