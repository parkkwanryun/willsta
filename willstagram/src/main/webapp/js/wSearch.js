$(function(){
	
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
	
}); 