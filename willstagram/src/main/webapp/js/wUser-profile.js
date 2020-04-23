$(function(){
	
	//상대방 팔로우 여부 체크
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
	
	//상대방 팔로우
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
				$('.followers').text(
						parseInt($('.followers').text()) + 1);
			}
		});
		e.preventDefault();
	});
	
	//상대방 언팔로우
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
				$('.followers').text(
						parseInt($('.followers').text()) - 1);
			}
		});
		e.preventDefault();
	});
	
	// 컨텐츠 보기 detail
	$(document).on('click', 'div.job_descp a', function(e) {
		var $post = $(e.target).parents('div.post-bar');
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
	
	// Top Views를 통해 컨텐츠 보기 detail
	$(document).on('click', '.top-views', function(e) {
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
	
	$(document).on('click', 'button.btn-default', function(e) {
		$('div.post_deatil').removeClass("active");
		$(".wrapper").removeClass("overlay");
		setTimeout(function() {
			window.location.reload();
		}, 500);
		e.preventDefault();
	});
	
	// 좋아유 추가
	$(document).on('click','ul.like-com a.like', function(e) {
				var $post = $(e.target).parents('div.post-bar');
				var params = "pNo=" + $post.attr('post_no');
				$.ajax({
					url : 'insert_like',
					data : params,
					type : "POST",
					dataType : 'text',
					success : function(resultText) {
						var likeCount = $(e.target).siblings('span.likeCount')
								.text();
						if (resultText.trim() == 'insert') {
							$(e.target).siblings('span.likeCount').text(
									Number(likeCount) + 1);
							$(e.target).addClass("active");
						} else if (resultText.trim() == 'delete') {
							$(e.target).siblings('span.likeCount').text(
									Number(likeCount) - 1);
							$(e.target).removeClass("active");
						}
						setTimeout(function() {
							window.location.reload();
						}, 500);
					}

				});
				e.preventDefault();
			});
	
	// 스크롤이벤트 : 문서의 끝 위치에 오면 post 추가 조회
	$(window).on("scroll",function(e) {
				// 문서의높이에 윈도우높이를 제외한 값이 스크롤의 최대값이다
				if (($(document).height() - $(window).height()) != $(document).scrollTop()) {
					return;
				}
				var $post = $("div.post-bar").last();
				var params = "lastpNo="+$post.attr('post_no')+"&mIdYou="+$(".user_profile").attr("mIdYou");
				console.log(params);
				$.ajax({
					url : 'you_add_post',
					method : 'POST',
					data : params,
					dataType : 'html',
					success : function(resultText) {
						console.log(resultText);
						$('div.posts-section').append(resultText);
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
					if ($mIdYou.attr("mid")==$(".user_profile").attr("mIdYou")) {
						$('.followers').text(parseInt($('.followers').text()) + 1);
						$('.follow').hide();
						$('.unFollow').show();
					}
				}
			});
			e.preventDefault();
			e.stopPropagation();

	});
    
}); 