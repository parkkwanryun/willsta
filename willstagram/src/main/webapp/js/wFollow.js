function followers(){
	
	var formData = new FormData();
	
	var paramArray = $('#followerList').serializeArray();
	for (var i = 0; i < paramArray.length; i++) {
		formData.append(paramArray[i].name, paramArray[i].value);
	}  
	
	var inputfollower = $("input[name='file1']");
	var followers = inputfollower[0].followers;
	for (var i = 0; i < followers.length; i++) {
		formData.append("newFollower", followers[i]);
	}
	
	
	$.ajax({
		url:'followList',
		processData:false, //k:v 방식으로 전달
		contentType: false, //file전송을 위해서는 false로 줘야 한다.
		data:formData,
		type: "POST",
		dataType:'html',
		success: function(resultText){
				$('span.Followers').prepend(resultText);
		}
		
	});
	
};