$(function(){
	var mIdArray=$('#mId-List').serializeArray();
	//검색 결과 여부
	if (mIdArray.length==0) {
		alert("결과없음");
		location.href="profiles";
	}
	//팔로우 여부 체크
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
					//팔로우 버튼 숨김
					$("h3:contains("+mId+")").next().next().children().eq(1).children().hide();
				}else if (resultText.trim()=='false') {
					//언팔로우 버튼 숨김
					$("h3:contains("+mId+")").next().next().children().first().children().hide();
				}
			}
		});
	}
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
         $.ajax({
	          url:'add_profile',
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