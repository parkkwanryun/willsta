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
				if (($(document).height() - $(window).height()) != $(document)
						.scrollTop()) {
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
										html+="<div class='suggestions-list'>";
														
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
	
	/*	var mIdArray=$('#followcheck').serializeArray();
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
						//팔로우 버튼 숨김
					
					}else if (resultText.trim()=='false') {
						//언팔로우 버튼 숨김
						//$("h3:contains("+mId+")").next().next().children().first().children().hide();
					}
				}
			
			});
		}
		*/
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
							html+="<div class='suggestions-list'>";
												
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
						// $(e.target.parentNode).prev().children().show();
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
						// $(e.target.parentNode).prev().children().show();
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
						// $(e.target.parentNode).prev().children().show();
						$('#followings').text(
								parseInt($('#followings').text()) - 1);

					}
				});
				e.preventDefault();
				e.stopPropagation();

			});

	
	

/*	
	//언팔로우
	$(document).on('click','.unFollow',function(e){
		var $mIdYou=$(e.target);
		var param="mIdYou="+$mIdYou.attr("mIdYou");
		$.ajax({
			url: "unFollow",
			method: "POST",
			data: param,
			dataType: "text",
			success:function(){
				$(e.target).hide(); 
				$(e.target.parentNode).prev().children().show();
				$('#follow_count_a').text(
						parseInt($('#follow_count_a').text()) - 1);
			}
		});
		e.preventDefault();
	});
	*/
/*
	 //언팔로우 친구추천리스트에서 버튼 클릭했을때  언팔가능하게하기.
	$('.unfollow').on(
			'click',
			function(e) {
				var $mIdYou = $(e.target);
				console.log('--------------->' + e.target);
				 console.log('--------------->' + $mIdYou);
				 console.log('--------------->' + $mIdYou.attr("mid"));
				
				 
				var param = "mIdYou=" + $mIdYou.attr("mid");
				$.ajax({
					url : "unfollow",
					method : "POST",
					data : param,
					dataType : "text",
					success : function(data) {

						// location.href='personal_info'; get방식이였다면.
						$(e.target).hide();
						// $(e.target.parentNode).prev().children().show();
						$('#follow_count_a').text(
								parseInt($('#follow_count_a').text()) - 1);

					}
				});
				e.preventDefault();
				e.stopPropagation();

			});   */

	
});

/*
 * 
 * $(document).ready(function(){ $(".show-open").css('display','none'); //우선
 * 내용부분을 모두 감춰줍니다 $(".bms-list-tr").click(function(){ //클릭했을때 var check =
 * $(this).next().css("display") == "none"; //변수로, 열릴 부분의 display 상태 체크
 * $(this).siblings().removeClass('bms-list-tr-active');//클릭하는 부분의 형제들에 배경색을
 * 제거해줍니다 var except = $(this).next();//선택된부분의 다음(내용)부분만 열리기 위해, 변수를 선언해주는데요. 이는
 * 다음을 보시면 이해가 가실겁니다. if(check)// 열릴부분의 display가 none으로 되어있다면, {
 * $(this).next().css('display','block'); //열릴부분의 display를 block으로 변경해주고,
 * $(".show-open").not(except).css('display','none'); //그외의 내용부분(.not() 으로 제어함)
 * 은 display를 none으로 안보이게 변경시킵니다. $(this).addClass('bms-list-tr-active');//클릭한
 * 부분에 클래스를 더해 배경색을 보여줍니다. }else{ //클릭 2번했을 경우 check는 display block으로 변했기때문에 그때의
 * 상황에 맞춰 상태조절, $(this).next().css('display','none'); //선택된 다음 부분의 display를
 * 감춥니다. $(this).removeClass('bms-list-tr-active');//선택된 부분의 배경색을 뺍니다. } }); })
 * 
 */

/*
 * 
 * function displayGuestListXML() { if (xhr.readyState == 4) { if (xhr.status ==
 * 200) { var xmlDoc = xhr.responseXML; //var xmlStr = xhr.responseText; var
 * guestNodeList = xmlDoc.getElementsByTagName("guest"); var html = "";
 * 
 * for (var i = 0; i < guestNodeList.length; i++) { var guestE =
 * guestNodeList[i];
 * 
 * var title =
 * guestE.getElementsByTagName("guest_title")[0].firstChild.nodeValue; var no =
 * guestE.getElementsByTagName("guest_no")[0].firstChild.nodeValue;
 * 
 * html += "<div class='guest_item'>"; html += "<h3 class='guest_title'  guest_no='"+no+"'><a
 * href=''>" + title + "[XML]</a></h3></div>"; }
 * 
 * document.getElementById('guest_list').innerHTML = html; }
 * showLoadingDialog(false); } }
 * 
 * 
 * 
 * document.getElementById('menu-b') .getElementsByTagName('a').item(0)
 * .addEventListener('click',function(e){ //ajax요청
 * sendRequest('guest/guest_list_json.jsp', null, displayGuestListJSON,
 * 'GET',true); showLoadingDialog(true); e.preventDefault(); });
 */	
	