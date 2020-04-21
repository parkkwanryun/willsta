<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>

<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<div class="container">
	<div class="row">
		<div class="col-md-6 col-md-offset-3">
			<h4 style="border-bottom: 1px solid #c5c5c5;">
				<i class="glyphicon glyphicon-user"> </i> <s:message code="pw.access"/>
			</h4>
				<h4 class=""><s:message code="sign.forgotPassword"/></h4>
				<form id="findPw_action" method="post">
					<fieldset>
						<span class="help-block"> 
						<s:message code="pw.explain"/>
						</span>
						<div class="form-group input-group">
							<span class="input-group-addon"> <s:message code="sign.id"/> </span> <input
								class="form-control" placeholder="<s:message code="sign.id"/>" id="mId" name="mId"
								type="text" required>
						</div>
						<div class="form-group input-group">
							<span class="input-group-addon"> <s:message code="deactivate.email"/> </span> <input
								class="form-control" placeholder="<s:message code="deactivate.email"/>" id="mEmail" name="mEmail"
								type="email" required>
						</div>
						<button type="submit" value="submit" class="btn btn-primary btn-block"><s:message code="pw.continue"/></button>
					</fieldset>
				</form> 
			</div>
		</div>
	</div>
<script type="text/javascript">
//비밀번호 찾기 이벤트
$('#findPw_action').submit(function(e){
	findPw();
	e.preventDefault();
});
/*
6) 비밀번호 찾기 
*/
function findPw(){
	var fpwArray = $('#findPw_action').serializeArray();
	$.ajax({
		url : 'findPw_action',
		method : 'POST',
		data : fpwArray,
		dataType : 'text',
		success : function(textData) {
			if (textData.trim() !=null) {
				alert(findPw_action.mId.value+"님의 비밀번호는 "+textData+"입니다.");
				location.href = '/willstagram/sign_in';
			}
		}
	})	
}
</script>