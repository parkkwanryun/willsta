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
	$(document).on('click','.follow',function(e){
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
	$(document).on('click','.follow',function(e){
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
		