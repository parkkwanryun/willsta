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
	
	// Top Views를 통해 컨텐츠 보기 detail
	$(document).on('click', '.job-info a', function(e) {
		var $post = $(e.target).parents('.job-info');
		var params = "pNo=" + $post.attr('post_no');
		$.ajax({
			url : 'get_post',
			method : 'POST',
			data : params,
			dataType : 'text',
			success : function(resultText) {
				$('div.post_deatil').html(resultText);
				$('div.post_deatil').addClass("active");
				$(".wrapper").addClass("overlay");
			}
		});
		e.preventDefault();
	});
	
	// 친구추천 리스트 팔로우
	$('.sFollow').on('click',function(e) {
			var $mIdYou = $(e.target);
			var param = "mIdYou=" + $mIdYou.attr("mid");
			$.ajax({
				url : "follow",
				method : "POST",
				data : param,
				dataType : "text",
				success : function(data) {
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
    
}); 