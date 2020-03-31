package com.itwill.willsta.service;

import java.io.File;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.itwill.willsta.domain.Post;
import com.itwill.willsta.domain.PostImage;
import com.itwill.willsta.repository.PostDao;
@Service
public class PostServiceImpl implements PostService {
	@Autowired
	PostDao postDao;
	
	@Override
	public Post createPost(Post post, MultipartFile[] uploadFile) {
		String uploadFolder = "C:\\eclipse-workspace5\\willsta\\willstagram\\src\\main\\webapp\\contents\\post_contents";
		Post postOne=null;
		int rn = postDao.insert(post);
		if(rn >0) {
			//2.파일처리(파일네임은DB에 저장 하고 파일은 image폴더에 저장)
			String filename="";
			String filterFileName="";
			PostImage pi;
			System.out.println("##########"+uploadFile.length);
			for (MultipartFile multipartFile : uploadFile) {
	
					filename = multipartFile.getOriginalFilename();
					filename = filename.substring(filename.lastIndexOf("\\")+1);
					String sepString = filename.substring(filename.lastIndexOf("."), filename.length());
					String maxContentNo = maxContentNo(post.getpNo());
					if(filename.toUpperCase().endsWith(".MP4") || filename.endsWith(".AVI") || filename.endsWith(".MKV") || filename.endsWith(".MOV")) {
						filterFileName =  "mov_";
					}else if(filename.toUpperCase().endsWith(".JPG") || filename.endsWith(".PNG") || filename.endsWith(".JPEG") || filename.endsWith(".GIF")) {
						filterFileName =  "img_";
					} else {
						filterFileName =  "etc_";
					}
					
					filterFileName+=post.getpNo()+"_"+maxContentNo.trim()+sepString;	
					
						System.out.println("$$$$$$$$$$$$$$"+filterFileName);
					if (!(filename == null || filename.equals(""))) {
						pi = new PostImage(post.getpNo(), filterFileName);	
						insertImg(pi);
						File saveFile = new File(uploadFolder, filterFileName);
						try {
							multipartFile.transferTo(saveFile);
						} catch (Exception e) {
							e.getMessage();
						}
					}
			}
		
		
			//성공인 경우 해당 포스트를 전송해 줌 1개의 포스트를  jsp 로 구성해서 던져줌.
			postOne = selectPost(post.getpNo());
			postOne.setTagArray(postOne.getHasTag().split(" "));
		}
		
		return postOne;
	}
	
	@Override
	public int insertImg(PostImage pi) {
		return postDao.insertImg(pi);
	}

	@Override
	public int modifyPost(Post post) {
		return postDao.update(post);
	}

	@Override
	public int removePost(Integer pNo) {
		return postDao.delete(pNo);
	}

	@Override
	public List<Post> selectMyList(String userId) {
		return postDao.selectMyList(userId);
	}

	@Override
	public Post selectPost(Integer pNo) {
		return postDao.selectPost(pNo);
	}

	@Override
	public List<PostImage> selectContents(Integer pNo) {
		return postDao.selectContents(pNo);
	}

	@Override
	public String maxContentNo(Integer pNo) {
		return postDao.maxContentNo(pNo);
	}

	

}
