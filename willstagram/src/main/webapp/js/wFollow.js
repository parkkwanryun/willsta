$(function(){
	//팔로잉카운트
	$(document).on('click','.follow',function(e){
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
	$(document).on('click','.follow',function(e){
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
	$(document).on('click','.followingList',function(e){
		var $mIdYou=$(e.target).parents("div.company-up-info");
		var param="mIdYou="+$mIdYou.attr("mIdYou");
		$.ajax({
			url: "followingList",
			method: "POST",
			data: param,
			dataType: "text",
			success:function(){
				$(e.target).hide();
				$(e.target.parentNode).prev().children().show();
			}
		});
		e.preventDefault();
	});
	
	//팔로우리스트
	$(document).on('click','.followList',function(e){
		var $mIdYou=$(e.target).parents("div.company-up-info");
		var param="mId="+$mIdYou.attr("mId");
		
		$.ajax({
			url: "followList",
			method: "POST",
			data: param,
			dataType: "text",
			success:function(){
				$(e.target).hide();
				$(e.target.parentNode).prev().children().show();
			}
		});
		e.preventDefault();
	});
	
	
	
	
	
	//팔로우
	$(document).on('click','.follow',function(e){
		var $mIdYou=$(e.target).parents("div.company-up-info");
		var param="mIdYou="+$mIdYou.attr("mIdYou");
		$.ajax({
			url: "follow",
			method: "POST",
			data: param,
			dataType: "text",
			success:function(){
				$(e.target).hide();
				$(e.target.parentNode).prev().children().show();
			}
		});
		e.preventDefault();
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
		
$(document).ready(function(){
	/*list 안의 내용 열리기 새거 열면 전에꺼 닫히고, 열린거 누르면 다시 닫힘*/
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