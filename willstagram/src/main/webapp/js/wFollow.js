//document ready
	
			//post삭제
			$(document).on('click','ul.ed-options a.deletePost',function(e){
				var $post = $(e.target).parents('div.post-bar');
				var params = "pNo="+ $post.attr('post_no');
				$.ajax({
					url:'delete_post',
					method:'POST',
					data:params,
					dataType:'text',
					success: function(resultText){
						if(resultText.trim()=='success'){
							$post.remove();
						}else{
							alert('delete fail');
						}
					}
				});
				e.preventDefault();
			});
			
			//수정 폼 호출:쓰기폼을 보여주고 데이터를 뿌려준다
			$(document).on("click", ".updatePost", function(e){
		          
		        var $post = $(e.target).parents('div.post-bar');
				var params = "pNo="+ $post.attr('post_no');
		        
		        $.ajax({
					url:'get_post_data',
					method:'POST',
					data:params,
					dataType:'json',
					success: function(jsonObject){
						postWrite.pNo.value = jsonObject.pNo;
						postWrite.pTitle.value = jsonObject.pTitle;
						postWrite.hasTag.value = jsonObject.hasTag;
						postWrite.pContents.value = jsonObject.pContents;
					}
				});
		        
		        $(".post-popup.job_post").addClass("active");
		        $(".wrapper").addClass("overlay");
		    });
			
			//post숨기거나 보이기
			$(document).on('click','ul.ed-options a.hiddenPost',function(e){
				var $post = $(e.target).parents('div.post-bar');
				var params = "pNo="+ $post.attr('post_no') + "&status="+$(e.target).text();
				$.ajax({
					url:'status_change',
					method:'POST',
					data:params,
					dataType:'text',
					success: function(resultText){
						if(resultText.trim()=='success'){
							if( $(e.target).text()=='Hide'){
								$(e.target).text('Show');
							}else{
								$(e.target).text('Hide');
							}
							 
						}else{
							alert('change fail');
						}
					}
				});
				e.preventDefault();
			});
			
			//컨텐츠 보기 detail
			$(document).on('click','div.job_descp a',function(e){
				var $post = $(e.target).parents('div.post-bar');
				var params = "pNo="+ $post.attr('post_no');
				$.ajax({
					url:'get_post',
					method:'POST',
					data:params,
					dataType:'text',
					success: function(resultText){
						$('div.post_deatil').html(resultText);
						$('div.post_deatil').addClass("active");
						$(".wrapper").addClass("overlay");
					}
				});
				e.preventDefault();
			});
			
			$(document).on('click','button.btn-default',function(e){
				$('div.post_deatil').removeClass("active");
				$(".wrapper").removeClass("overlay");
				e.preventDefault();
			});
			
			//좋아유 추가
			$(document).on('click', 'ul.like-com a.like', function(e){
				var $post = $(e.target).parents('div.post-bar');
				var params = "pNo="+ $post.attr('post_no');
				$.ajax({
					url:'insert_like',
					data:params,
					type: "POST",
					dataType:'html',
					success: function(resultText){
						var likeCount = $(e.target).siblings('span.likeCount').text();
						if(resultText.trim()=='insert'){
							$(e.target).siblings('span.likeCount').text(Number(likeCount) + 1);
							$(e.target).addClass("active");
						} else if(resultText.trim()=='delete'){
							$(e.target).siblings('span.likeCount').text(Number(likeCount) - 1);
							$(e.target).removeClass("active");
						}
					}
					
				});
				e.preventDefault();
			});
			var sel_files=[];
			$(document).on('change', 'input.TXTFLD', function(e){
				var files = e.target.files;
				var filesArr = Array.prototype.slice.call(files);
				$(".img-list").html("");
				filesArr.forEach(function(f){
					if(!f.type.match("image.*")) { 
						return;
					}
					
					sel_files.push(f);
					var reader = new FileReader();
					reader.onload = function(e) {
						var img_html = "<img src='"+ e.target.result +"' width='80px' style='margin-right:5px'/>";
						$(".img-list").append(img_html);
					}
					
					reader.readAsDataURL(f);
					
				});
			});
			
			
		