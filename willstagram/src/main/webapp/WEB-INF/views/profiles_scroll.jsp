<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
		<div class="row">
		<!-- loop start -->
		<c:forEach var="member" items="${memberList}" varStatus="status">
			<c:if test="${status.index!=0}">
				</div>
			</c:if>
			<div class="col-lg-3 col-md-4 col-sm-6 col-12">
				<div class="company_profile_info">
					<div class="company-up-info"  mIdYou="${member.mId}">
					<input type="hidden" name="mId" value="${member.mId}" placeholder="Id">
						<c:choose>
							<c:when test="${member.mImage==null}">
								<img src="contents/member_image/default.png" alt="">
							</c:when>	
							<c:otherwise >
								<img src="contents/member_image/${member.mImage}" alt="">
							</c:otherwise>
						</c:choose>
						<h3 class="member-id">${member.mId}</h3>
						<h4>${member.mName}</h4>
						<c:choose>
							<c:when test="${member.mId!=sessionScope.mId}">
								<ul>	
									<li><a href="#" title="" class="unFollow"><s:message code="profile.unfollow"/></a></li><!-- follow중인 상태 -->
									<li><a href="#" title="" class="follow"><s:message code="profile.follow"/></a></li>
									<li><a href="#" title="" class="message-us"><i class="fa fa-envelope"></i></a></li>
								</ul>
							</c:when>
							<c:otherwise>
								<b><s:message code="profile.my"/></b>
							</c:otherwise>
						</c:choose>
					</div>
					<c:choose>
						<c:when test="${member.mId==sessionScope.mId}">								
							<a href="personal_info" title="" class="view-more-pro"><s:message code="profile.view"/></a>
						</c:when>
						<c:otherwise>
							<a href="user-profile?youId=${member.mId}" title="" class="view-more-pro"><s:message code="profile.view"/></a>
						</c:otherwise>
					</c:choose>
				</div><!--company_profile_info end-->
				</c:forEach>
				<!-- loop end -->
			</div>
		</div>
<script type="text/javascript">
//팔로우 여부 체크
	var mIdArray=$('#mId-List').serializeArray();
	for (var i = 0; i < mIdArray.length; i++) {
		var mId=mIdArray[i].value;
		var param="mIdYou="+mId;
		$.ajax({
			url:'follow_Check',
			method:'POST',
			data:param,
			dataType:'text',
			async: false,
			success:function(resultText){
				if (resultText.trim()=='true') {
					$("h3:contains("+mId+")").next().next().children().eq(1).children().hide();
				}else if (resultText.trim()=='false') {
					$("h3:contains("+mId+")").next().next().children().first().children().hide();
				}
			}
		
		});
	}
</script>
