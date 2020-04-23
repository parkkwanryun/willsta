/*
 * Controller 부분 
 *  follow list  (완료)
 *  following list (완료)
 *  follow count (완료)
 *  following count (완료)
 할것들 
 - follow & following list UI 아니면 bootstrap 써서 뽑기 
 	리스트를 잘 불러왔지만 여기서 문제는 리스트 불러온 부분에서  중복이 발생하고 내자신의 이름은 나오면 안된다구.
  눈물이난다. 
 
 - view more 눌렀을때 더 나오게 만들기
 - 친구추천목록에서 +버튼누르면 팔로잉 되게만들면서 (완료)
 - 팔로잉카운트수도같이 늘리기(완료)
 - 자신의 아이디는 안나오게 만들기.(완료)
- 마이페이지 펄스널 페이지로 링크바꾸기.(완료)
  
 */



$(function(){
	
	// 스크롤이벤트 : 문서의 끝 위치에 오면 post 추가 조회
	$(window).on(
			"scroll",
			function(e) {
				// 문서의높이에 윈도우높이를 제외한 값이 스크롤의 최대값이다
				if (($(document).height() - $(window).height()) > $(document).scrollTop()) {
					return;
				}
				var $post = $("div.post-bar").last();
				var params = "lastpNo=" + $post.attr('post_no');
				$.ajax({
					url : 'my_add_post',
					method : 'POST',
					data : params,
					dataType : 'html',
					success : function(resultText) {
						$('div.posts-section').append(resultText);
					}
				});
				e.preventDefault();
			});

// 팔로우 리스트  # 팔로우 카운트 된숫자를 클릭했을때 내가 팔로우하고있는 리스트 뽑고 팔로잉 카운트 늘어나게
	// 그리고 뽑았으면 언팔로우도 가능하게 해야됨 .
		$('#followers').on('click',	function(e) {
				var $mIdYou = $(e.target);
				var param = "mId=" + $mIdYou.attr("mid");
				console.log(param);
				$.ajax({
						url : "followerList",
						method : "POST",
						data : param,
						dataType : "JSON",
						success : function(jsonArray) {
										console.log(jsonArray);
										var html="<div class='sd-title'>";
										//html+="<form id ='followcheck'>"
										html+="<h3>팔로워리스트</h3>";
										html+="<i class='la la-ellipsis-v'></i>";
										html+="</div>";
										html+="<div class='suggestions-list'  style='overflow:auto; height:450px;'>";
														
										for (var i = 0; i < jsonArray.length; i++) {
											var jsonArrayObject = jsonArray[i];
											var mId = jsonArrayObject.mId;
											var mImage = jsonArrayObject.mImage;
											var mName = jsonArrayObject.mName;
											var mEmail = jsonArrayObject.mEmail;
										    var followCheck=jsonArrayObject.followCheck;
											var sss="";
										    if(followCheck=='1'){
												sss = "<span><i mid='"+mId+"' class='la la-minus' id='unfollow' ></i></span>";
											}else if(followCheck=='0'){
												sss = "<span><i mid='"+mId+"' class='la la-plus' id='follow' ></i></span>";
											}
											
												html += "<div class='suggestion-usd'>";
												html += "<img src='contents/member_image/"
													+ mImage
													+ "' alt='' width='40px'>"
													+ "<div class='sgt-text'>"
													+ "<h4>"
													+ "<a href=user-profile?youId="+mId+">"
													+ mName
													+ "</a>"
													+ "</h4>"
													+ "<span>"
													+ mEmail
													+ "</span>"
													+ "</div>"
													+sss
													+ "</div>";	
											}
											//html+="</form>";
										 	html+="</div>";
										 
										 	$('div.suggestions').html(html);
							 	
								}
						});
					e.preventDefault();
				});
	
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////
	$('#followings').on('click', function(e) {
			var $mIdYou = $(e.target);
			var param = "mId=" + $mIdYou.attr("mid");
			console.log(param);
			$.ajax({url : "followingList",
					method : "POST",
					data : param,
					dataType : "JSON",
					success : function(jsonArray) {
							console.log(jsonArray);
							var html="<div class='sd-title'>";
							html+="<h3>팔로잉리스트</h3>";
							html+="<i class='la la-ellipsis-v'></i>";
							html+="</div>";
							html+="<div class='suggestions-list' style='overflow:auto; height:450px;'>";
												
							for (var i = 0; i < jsonArray.length; i++) {
								var jsonArrayObject = jsonArray[i];
								var mId = jsonArrayObject.mId;
								var mImage = jsonArrayObject.mImage;
								var mName = jsonArrayObject.mName;
								var mEmail = jsonArrayObject.mEmail;
							
									html += "<div class='suggestion-usd'>";
									html += "<img src='contents/member_image/"
										+ mImage
										+ "' alt='' width='40px'>"
										+ "<div class='sgt-text'>"
										+ "<h4>"
										+ "<a href=user-profile?youId="+mId+">"
										+ mName
										+ "</a>"
										+ "</h4>"
										+ "<span>"
										+ mEmail
										+ "</span>"
										+ "</div>"
										+ "<span><i mid='"
										+ mId
										+ "' class='la la-minus' id='unfollow' ></i></span>"
										+ "</div>";
								}
							 	html+="</div>";
							 
							 	$('div.suggestions').html(html);
						
							}
						});
				e.preventDefault();
			});







	
	// 친구추천 리스트에 있는 팔로우버튼 (class로 검색)
	$('.follow_add').on(
			'click',
			function(e) {
				var $mIdYou = $(e.target);
				console.log('--------------->' + e.target);
				 console.log('--------------->' + $mIdYou);
				 console.log('--------------->' + $mIdYou.attr("mid"));
				/*
				 */
				var param = "mIdYou=" + $mIdYou.attr("mid");
				$.ajax({
					url : "follow",
					method : "POST",
					data : param,
					dataType : "text",
					success : function(data) {
						// location.href='personal_info'; get방식이였다면.
						$(e.target).hide();
						$(e.target.parentNode).next().children().show();
						var html="<span><i class='la la-plus unfollow' ></i></span>";
						
						$('#followings').text(
								parseInt($('#followings').text()) + 1);

					}
				});
				e.preventDefault();
				e.stopPropagation();

			});
	
	/////////////////////////////////////////이거는 Followers 리스트안에있는 팔로우 버튼 (ID로검색)
	$(document).on('click','#follow',
			function(e) {
				var $mIdYou = $(e.target);
				console.log("없애야되는 버튼"+e.target);
				console.log('--------------->' + e.target);
				 console.log('--------------->' + $mIdYou);
				 console.log('--------------->' + $mIdYou.attr("mid"));
				/*
				 */
				var param = "mIdYou=" + $mIdYou.attr("mid");
				$.ajax({
					url : "follow",
					method : "POST",
					data : param,
					dataType : "text",
					success : function(data) {
						// location.href='personal_info'; get방식이였다면.
						$(e.target).hide();
						$(e.target.parentNode).next().children().show();
						var html="<span><i class='la la-plus unfollow' ></i></span>";
						
						$('#followings').text(
								parseInt($('#followings').text()) + 1);

					}
				});
				e.preventDefault();
				e.stopPropagation();

			});

	// 이벤트 처리안에 중복 이벤트 처리위해서는 도큐맨트를 적어줘야함 .
	$(document).on('click','#unfollow',
			function(e) {
				var $mIdYou = $(e.target);
				/*console.log('--------------->' + e.target);
				 console.log('--------------->' + $mIdYou);
				 console.log('--------------->' + $mIdYou.attr("mid"));*/
				
				var param = "mIdYou=" + $mIdYou.attr("mid");
				$.ajax({
					url : "unFollow",
					method : "POST",
					data : param,
					dataType : "text",
					success : function(data) {

						// location.href='personal_info'; get방식이였다면.
						$(e.target).hide();
						$(e.target.parentNode).next().children().show();
						
						$('#followings').text(
								parseInt($('#followings').text()) - 1);

					}
				});
				e.preventDefault();
				e.stopPropagation();

			});

	


	
});

