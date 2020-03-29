<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div class="modal-dialog">
   <div class="modal-content">
     <div class="modal-header">
       <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
       <h4 class="modal-title text-center" id="myModalLabel">${post.title}</h4>
     </div>
     <div class="modal-body" id="myModalBody">
        <div id="carousel-product" class="carousel slide center-block" data-ride="carousel" data-interval="5000">
		      <!-- Indicators -->
		      <ol class="carousel-indicators">
		        <li data-target="#carousel-product" data-slide-to="0" class="active"></li>
		        <li data-target="#carousel-product" data-slide-to="1"></li>
		        <li data-target="#carousel-product" data-slide-to="2"></li>
		        <li data-target="#carousel-product" data-slide-to="3"></li>
		      </ol>
		
		      <!-- Wrapper for slides -->
		      <div class="carousel-inner" role="listbox">
		      	<c:forEach var="pi" items="${imgList}" varStatus="vs">	
		      		<div class="item 
		      		<c:if test="${vs.index==0}">
		      			active
		      		</c:if>
			        	">
			          <img class="center-block" src="/myshop/image/${pi.imgName}" alt="${pi.imgName}" >
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
     </div>
     <div class="modal-footer">
     	<button type="button" id="btnModify" class="btn btn-default" data-dismiss="modal">수정</button>
     	<button type="button" id="btnRemove" class="btn btn-default" data-dismiss="modal">삭제</button>
       <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
     </div>
   </div>
 </div>