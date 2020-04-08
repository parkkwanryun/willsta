/*
 * Controller 부분 
 *  follow list  (완료)
 *  following list (완료)
 *  follow count (완료)
 *  following count (완료)
 할것들 
 - follow & following list UI 아니면 bootstrap 써서 뽑기 
 - view more 눌렀을때 더 나오게 만들기
 - 친구추천목록에서 +버튼누르면 팔로잉 되게만들면서 (완료)
 - 팔로잉카운트수도같이 늘리기(완료)
 - 자신의 아이디는 안나오게 만들기.(완료)
- 마이페이지 펄스널 페이지로 링크바꾸기.(완료)
  
 */



$(function(){
	//팔로잉카운트
	$(document).on('click','.followingCount',function(e){
		var $mIdYou=$(e.target).parents("div.company-up-info");
		var param="mIdYou="+$mIdYou.attr("mIdYou");
		$.ajax({
			url: "followingCount",
			method: "POST",
			data: param,
			dataType: "int",
			success:function(){
				$(e.target).hide();
				$(e.target.parentNode).prev().children().show();
			}
		});
		e.preventDefault();
	});
	//팔로워카운트
	$(document).on('click','.followCount',function(e){
		var $mIdYou=$(e.target).parents("div.company-up-info");
		var param="mIdYou="+$mIdYou.attr("mIdYou");
		$.ajax({
			url: "followerCount",
			method: "POST",
			data: param,
			dataType: "int",
			success:function(){
				$(e.target).hide();
				$(e.target.parentNode).prev().children().show();
			}
		});
		e.preventDefault();
	});
	
	//팔로잉리스트
	function followingList(e){
		var mIdYou = $(e.target).find('#mIdYou').text();
		var params = "mIdYou=" + mIdYou;
		$.ajax({
			url : 'followingList',
			method : 'POST',
			data : params,
			dataType : 'json',
			success : function(jsonArrayData) {
				for(var i; i<=params.size(); i++){
					params[i].following.name="jhj"
				}
				
				console.log(jsonArrayData);
				
				
				/*
				$(function() {
					message_send_function(e);
				});
				*/
			}
		});
	};
	
	//팔로우리스트
	function message_detail_function(e){
		var dmNo = $(e.target).find('#mId').text();
		var params = "mId=" + dmNo;
		$.ajax({
			url : 'followList',
			method : 'GET',
			data : params,
			dataType : 'json',
			success : function(jsonArrayData) {
				console.log(jsonArrayData);
				/*
				$(function() {
					message_send_function(e);
				});
				*/
			}
		});
	};
	
	
	
	
	
	//팔로우
	$('.follow').on(
			'click',
			function(e) {
				var $mIdYou = $(e.target);
				/*
				console.log('--------------->' + e.target);
				console.log('--------------->' + $mIdYou);
				console.log('--------------->' + $mIdYou.attr("midyou"));
				*/
				var param = "mIdYou=" + $mIdYou.attr("midyou");
				$.ajax({
					url : "follow",
					method : "POST",
					data : param,
					dataType : "text",
					success : function(data) {

						// location.href='personal_info'; get방식이였다면.
						$(e.target).hide();
						// $(e.target.parentNode).prev().children().show();
						$('#follow_count_a').text(
								parseInt($('#follow_count_a').text()) + 1);

					}
				});
				e.preventDefault();
				e.stopPropagation();

			});

	

	//언팔로우
	$(document).on('click','.unFollow',function(e){
		var $mIdYou=$(e.target).parents("div.company-up-info");
		var param="mIdYou="+$mIdYou.attr("mIdYou");
		$.ajax({
			url: "unFollow",
			method: "POST",
			data: param,
			dataType: "text",
			success:function(){
				$(e.target).hide(); 
				$(e.target.parentNode).next().children().show();
			}
		});
		e.preventDefault();
	});
	
	
});

/*

$(document).ready(function(){
	$(".show-open").css('display','none'); //우선 내용부분을 모두 감춰줍니다
	$(".bms-list-tr").click(function(){ //클릭했을때
		var check = $(this).next().css("display") == "none"; //변수로, 열릴 부분의 display 상태 체크
		$(this).siblings().removeClass('bms-list-tr-active');//클릭하는 부분의 형제들에 배경색을 제거해줍니다
		var except = $(this).next();//선택된부분의 다음(내용)부분만 열리기 위해, 변수를 선언해주는데요. 이는 다음을 보시면 이해가 가실겁니다.
		if(check)// 열릴부분의 display가 none으로 되어있다면, 
		{
			$(this).next().css('display','block'); //열릴부분의 display를 block으로 변경해주고,
			$(".show-open").not(except).css('display','none'); //그외의 내용부분(.not() 으로 제어함) 은 display를 none으로 안보이게 변경시킵니다.
			$(this).addClass('bms-list-tr-active');//클릭한 부분에 클래스를 더해 배경색을 보여줍니다.		
        }else{ //클릭 2번했을 경우 check는 display block으로 변했기때문에 그때의 상황에 맞춰 상태조절,
			$(this).next().css('display','none'); //선택된 다음 부분의 display를 감춥니다.
			$(this).removeClass('bms-list-tr-active');//선택된 부분의 배경색을 뺍니다. 
		}
	});
})

*/

/*

	function displayGuestListXML() {
		if (xhr.readyState == 4) {
			if (xhr.status == 200) {
				var xmlDoc = xhr.responseXML;
				//var xmlStr = xhr.responseText;
				var guestNodeList = xmlDoc.getElementsByTagName("guest");
				var html = "";

				for (var i = 0; i < guestNodeList.length; i++) {
					var guestE = guestNodeList[i];

					var title = guestE.getElementsByTagName("guest_title")[0].firstChild.nodeValue;
					var no = guestE.getElementsByTagName("guest_no")[0].firstChild.nodeValue;

					html += "<div class='guest_item'>";
					html += "<h3 class='guest_title'  guest_no='"+no+"'><a href=''>"
							+ title + "[XML]</a></h3></div>";

				}

				document.getElementById('guest_list').innerHTML = html;
			}
			showLoadingDialog(false);
		}
	}



document.getElementById('menu-b')
				.getElementsByTagName('a').item(0)
				.addEventListener('click',function(e){
					//ajax요청
					sendRequest('guest/guest_list_json.jsp',
								null,
								displayGuestListJSON,
								'GET',true);
					showLoadingDialog(true);
					e.preventDefault();
				});
*/	
	