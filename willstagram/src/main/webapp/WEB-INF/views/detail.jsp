<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <!-- 합쳐지고 최소화된 최신 자바스크립트 -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
	
	<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
     
 <div class="post-project">
	<h3>${post.pTitle}</h3>
	<div class="post-project-fields">
        <div id="carousel-product" class="carousel slide center-block" data-ride="carousel" data-interval="3000">
		      <!-- Indicators -->
		      <ol class="carousel-indicators">
		      	<c:forEach var="pi" items="${postImages}" varStatus="vs">	
			        <li data-target="#carousel-product" data-slide-to="${vs.index}" 
			        	<c:if test="${vs.index==0}">class="active"</c:if>></li>
			    </c:forEach>
		      </ol>
		
		      <!-- Wrapper for slides -->
		      <div class="carousel-inner" role="listbox" >
		      	<c:forEach var="pi" items="${postImages}" varStatus="vs">	
		      		<div class="item <c:if test="${vs.index==0}">active</c:if>">
			          	<c:if test="${fn:startsWith(pi.fileName, 'img')}">
							<img style="width:100%; height: 550px;" class="center-block" src="contents/post_contents/${pi.fileName}" alt="${pi.fileName}" >
						</c:if>
						<c:if test="${fn:startsWith(pi.fileName, 'mov')}">
							<div class="embed-responsive embed-responsive-4by3">
							  	<iframe class="embed-responsive-item" src="contents/post_contents/${pi.fileName}"></iframe>
							</div>
						</c:if>
			        </div>
		        </c:forEach>
		      </div>
		
		      <!-- Controls -->
		      <a class="left carousel-control" href="#carousel-product" role="button" data-slide="prev">
		        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
		        <span class="sr-only">Previous</span>
		      </a>
		      <a class="right carousel-control" href="#carousel-product" role="button" data-slide="next">
		        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
		        <span class="sr-only">Next</span>
		      </a>
	     </div>
	     <div class="post-content">
	       <p>${post.pContents}</p>
	     </div>
     </div>
     
     <div class="pull-right">
       <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
     </div>
 </div>