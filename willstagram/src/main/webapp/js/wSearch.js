$(function(){
	
	$(function(a){
		//팔로우 여부 체크
		var mId="";
		var mIdArray=$('#mId-List').serializeArray();
		console.log(mIdArray);
		for (var i = 0; i < mIdArray.length; i++) {
			var mId=mIdArray[i].value;
			var param="mIdYou="+mId;
			$.ajax({
				url:'follow_Check',
				method:'POST',
				data:param,
				dataType:'text',
				success:function(resultText){
					if (resultText.trim()=='true') {
						console.log(mId);
						console.log(resultText.trim())
						//$("h3:contains("+mId+")").next().next().children().eq(1).hide();
					}else if (resultText.trim()=='false') {
						console.log(mId);
						console.log(resultText.trim())
						$("h3:contains("+mId+")").next().next().children().first().hide();
					}
				}
			
			});
		}
		a.preventDefault();
	});
	
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
				$(e.target.parentNode).prev().children().show();
				$(e.target).hide();
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
				$(e.target.parentNode).next().children().show();
				$(e.target).hide(); 
			}
		});
		e.preventDefault();
	});
	
}); 