$(function(){
	
	/*var mId="mIdYou="+$('.member-id').text();
	console.log(mId);
	$.ajax({
		url:'follow_Check',
		method:'POST',
		data:mId,
		dataType:'text',
		success:function(){
			
		}
	});*/
	
	
	//사용자 검색
	$('.userSearch').submit(function(e) {
		
		//키워드 값 변수에 저장
		userKeyword="find="+$('input[name=search]').val();
		console.log(userKeyword);
		
		$.ajax({
			url:'search_member',
			method:'POST',
			data:userKeyword,
			dataType:'text',
			success:function(resultText){
				$('div.wrapper').html(resultText);
				$('div.company-title').children().text("Search Profile");
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
				$(".unFollow").show();
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
				$(".follow").show();
			}
		});
		e.preventDefault();
	});
	
}); 