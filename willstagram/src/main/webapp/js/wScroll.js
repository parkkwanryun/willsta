$(function() {
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
					url : 'add_post',
					method : 'POST',
					data : params,
					dataType : 'html',
					success : function(resultText) {
						$('div.posts-section').append(resultText);
					}
				});
				e.preventDefault();
			});
});