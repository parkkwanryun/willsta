$(function(){
	
	//팔로우 여부 체크
	var $mIdYou=$(".user_profile").attr("mIdYou");
	var param="mIdYou="+$mIdYou;
	$.ajax({
		url:'follow_Check',
		method:'POST',
		data:param,
		dataType:'text',
		async: false,
		success:function(resultText){
			if (resultText.trim()=='true') {
				//팔로우 버튼 숨김
				$(".follow").hide();
			}else if (resultText.trim()=='false') {
				//언팔로우 버튼 숨김
				$(".unFollow").hide();
			}
		}
	
	});
	
	//팔로우
	$(document).on('click','.follow',function(e){
		var $mIdYou=$(e.target).parents("div.user_profile");
		var param="mIdYou="+$mIdYou.attr("mIdYou");
		$.ajax({
			url: "follow",
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
	
	//언팔로우
	$(document).on('click','.unFollow',function(e){
		var $mIdYou=$(e.target).parents("div.user_profile");
		var param="mIdYou="+$mIdYou.attr("mIdYou");
		$.ajax({
			url: "unFollow",
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
	
    
}); 