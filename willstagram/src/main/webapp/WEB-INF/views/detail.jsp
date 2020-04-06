<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
	
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
		      <div class="carousel-inner" >
		      	<c:forEach var="pi" items="${postImages}" varStatus="vs">	
		      		<div class="carousel-item <c:if test="${vs.index==0}">active</c:if>">
			          	<c:if test="${fn:startsWith(pi.fileName, 'img')}">
							<img style="width:100%; height: 480px;" class="d-block w-100" src="contents/post_image/${pi.fileName}" alt="${pi.fileName}" >
						</c:if>
						<c:if test="${fn:startsWith(pi.fileName, 'mov')}">
							<div class="embed-responsive embed-responsive-4by3">
							  	<iframe class="embed-responsive-item" src="contents/post_image/${pi.fileName}"></iframe>
							</div>
						</c:if>
			        </div>
		        </c:forEach>
		      </div>
		
		      <!-- Controls -->
		      <a class="carousel-control-prev" href="#carousel-product" role="button" data-slide="prev">
		        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
		        <span class="sr-only">Previous</span>
		      </a>
		      <a class="carousel-control-next" href="#carousel-product" role="button" data-slide="next">
		        <span class="carousel-control-next-icon" aria-hidden="true"></span>
		        <span class="sr-only">Next</span>
		      </a>
	     </div>
	     <div class="post-content" style="margin-top:10px;">
	       <pre>${post.pContents}</pre>
	     </div>
     </div>
     
     <div class="pull-right">
       <button type="button" class="btn btn-default btn-close" data-dismiss="modal">Close</button>
     </div>
 </div>