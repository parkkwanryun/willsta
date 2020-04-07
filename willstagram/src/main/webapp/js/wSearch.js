$(function(){
	
	//팔로우 여부 체크
	var mIdArray=$('#mId-List').serializeArray();
	//console.log(mIdArray);
	for (var i = 0; i < mIdArray.length; i++) {
		var mId=mIdArray[i].value;
		var param="mIdYou="+mId;
		$.ajax({
			url:'follow_Check',
			method:'POST',
			data:param,
			dataType:'text',
			async: false,
			success:function(resultText){
				if (resultText.trim()=='true') {
					//console.log(mId);
					//console.log(resultText.trim())
					$("h3:contains("+mId+")").next().next().children().eq(1).children().hide();
				}else if (resultText.trim()=='false') {
					//console.log(mId);
					//console.log(resultText.trim())
					$("h3:contains("+mId+")").next().next().children().first().children().hide();
				}
			}
		
		});
	}
	
	//검색 두번했을때 버튼 다시 보임..
	//사용자 검색
	$('.userSearch').submit(function(e) {
		
		//키워드 값 변수에 저장
		userKeyword="findId="+$('input[name=search]').val();
		//console.log(userKeyword);
		
		$.ajax({
			url:'search_member',
			method:'POST',
			data:userKeyword,
			dataType:'text',
			success:function(resultText){
				console.log(resultText);
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

	//스크롤이벤트 : 문서의 끝 위치에 오면 사용자 추가 조회
    $(window).on("scroll", function(e){
       //문서의높이에 윈도우높이를 제외한 값이 스크롤의 최대값이다
       if(($(document).height()-$(window).height()) != $(document).scrollTop()){
          return;
       }            
       var $member = $("div.company-up-info").last();
       var params = "lastId="+ $member.attr('mIdYou');
       console.log(params);
         $.ajax({
          url:'profiles',
          method:'POST',
          data:params,
          dataType:'html',
          success: function(resultText){
             $('div.companies-list').append(resultText);
          }
       });
         e.preventDefault();
     });
    
}); 