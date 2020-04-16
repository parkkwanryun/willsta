package com.itwill.willsta.service;

import java.io.File;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.itwill.willsta.domain.Likes;
import com.itwill.willsta.domain.Member;
import com.itwill.willsta.domain.Post;
import com.itwill.willsta.domain.PostImage;
import com.itwill.willsta.repository.PostDao;
@Service
public class PostServiceImpl implements PostService {
	@Autowired
	PostDao postDao;
	
	@Autowired
	MemberService memberService;
	
	
	//String uploadFolder = StaticProperties.postRealPath;
	//임시 경로를 만들어 저장(aws서버) -web.xml 설정 포함
	String uploadFolder = "/var/lib/tomcat8/webapps/willstagram/contents/post_image/";
	//임시 경로를 만들어 저장(로컬) -web.xml 설정 포함
	//String uploadFolder = "C:\\JAVA_SPRING\\Program\\sts-bundle\\pivotal-tc-server\\instances\\base-instance\\wtpwebapps\\willstagram\\contents\\post_image";
	//String uploadFolder = "contents/post_image";
	@Override
	public Post createPost(Post post, MultipartFile[] uploadFile){
		/*
		 * 1. 포스트 생성
		 * 2. 생성된 번호로 파일이름 설정
		 * 3. 컨텐츠정보생성
		 * 4. 파일저장
		 */
		Post postOne=null;
		int rn = postDao.insert(post);
		if(rn >0) {
			//2.파일처리(파일네임은DB에 저장 하고 파일은 image폴더에 임시저장)
			String filename="";
			String filterFileName="";
			PostImage pi;
			System.out.println("##########"+uploadFile.length);
			for (MultipartFile multipartFile : uploadFile) {
	
					filename = multipartFile.getOriginalFilename();
					filename = filename.substring(filename.lastIndexOf("\\")+1);
					String sepString = filename.substring(filename.lastIndexOf("."), filename.length());
					String maxContentNo = postDao.maxContentNo(post.getpNo());
					if(filename.toUpperCase().endsWith(".MP4") || filename.endsWith(".AVI") || filename.endsWith(".MKV") || filename.endsWith(".MOV")) {
						filterFileName =  "mov_";
					}else if(filename.toUpperCase().endsWith(".JPG") || filename.endsWith(".PNG") || filename.endsWith(".JPEG") || filename.endsWith(".GIF")) {
						filterFileName =  "img_";
					} else {
						filterFileName =  "etc_";
					}
					
					filterFileName+=post.getpNo()+"_"+maxContentNo.trim()+sepString;	
					
						System.out.println("$$$$$$$$$$$$$$"+uploadFolder+filterFileName);
					if (!(filename == null || filename.equals(""))) {
						pi = new PostImage(post.getpNo(), filterFileName);	
						postDao.insertImg(pi);
						File saveFile = new File(uploadFolder, filterFileName);
						try {
							multipartFile.transferTo(saveFile);
						} catch (Exception e) {
							e.getMessage();
						}
					}
			}
		
		
			//성공인 경우 해당 포스트를 전송해 줌 1개의 포스트를  jsp 로 구성해서 던져줌.
			postOne = postDao.selectPost(post.getpNo(), post.getmId());
			postOne.setTagArray(postOne.getHasTag().split(" "));
		}
		
		return postOne;
	}
	
	

	@Override
	public Post modifyPost(Post post, MultipartFile[] uploadFile) {
		/*
		 * 1.내용수정
		 * 2.파일삭제
		 * 3.파일저장
		 */
		Post postOne=null;
		int rn = postDao.update(post);
		
		if(rn >0) {
			
			File removeFile;
			List<PostImage> postImageList = postDao.selectContents(post.getpNo());
			for (PostImage postImage : postImageList) {
				removeFile= new File(uploadFolder, postImage.getFileName());
				removeFile.delete();
			}
			postDao.delete_img(post.getpNo());
			//2.파일처리(파일네임은DB에 저장 하고 파일은 image폴더에 저장)
			String filename="";
			String filterFileName="";
			PostImage pi;
			System.out.println("##########"+uploadFile.length);
			for (MultipartFile multipartFile : uploadFile) {
	
					filename = multipartFile.getOriginalFilename();
					filename = filename.substring(filename.lastIndexOf("\\")+1);
					String sepString = filename.substring(filename.lastIndexOf("."), filename.length());
					String maxContentNo = postDao.maxContentNo(post.getpNo());
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
						postDao.insertImg(pi);
						File saveFile = new File(uploadFolder, filterFileName);
						try {
							multipartFile.transferTo(saveFile);
						} catch (Exception e) {
							e.getMessage();
						}
					}
			}
		
		
			//성공인 경우 해당 포스트를 전송해 줌 1개의 포스트를  jsp 로 구성해서 던져줌.
			postOne = postDao.selectPost(post.getpNo(), post.getmId());
			postOne.setTagArray(postOne.getHasTag().split(" "));
		}
		
		return postOne;
		
	}

	@Override
	public int removePost(Integer pNo) {
		/*
		 * 1. 컨텐츠 리스트 조회
		 * 2. 파일삭제
		 * 3. post삭제
		 */
		File removeFile;
		List<PostImage> postImageList = postDao.selectContents(pNo);
		for (PostImage postImage : postImageList) {
			removeFile= new File(uploadFolder, postImage.getFileName());
			removeFile.delete();
		}
		postDao.delete_img(pNo);
		
		return postDao.delete(pNo);
	}
	//검색조건 queryGbn 1이 아니면 내글 만 보게 설정
	@Override
	public List<Post> selectMyList(Integer lastpNo, String userId, Integer queryGbn) {
		return postDao.selectMyList(lastpNo, userId, queryGbn);
	}

	@Override
	public Post selectPost(Integer pNo, String mId) {
		//이거 호출 시 뷰카운트 업데이트 해줌
		postDao.up_viewcount(pNo);
		return postDao.selectPost(pNo, mId);
	}

	@Override
	public List<PostImage> selectContents(Integer pNo) {
		return postDao.selectContents(pNo);
	}


	@Override
	public String insert_like(Likes lk) {
		int rn = postDao.select_like_count(lk);
		if(rn==0) {
			postDao.insert_like(lk);
			return "insert";
		} else {
			postDao.delete_like(lk);
			return "delete";
		}
	}
	
	@Override
	public int status_change(Integer pNo, String status) {

		return postDao.status_update(pNo, status);
	}
	
	@Override
	public ModelAndView main_page(String mId) {
		ModelAndView mv = new ModelAndView();
		
		Member member = memberService.selectByIdContainFollowInfo(mId);
		List<Member> memberList = memberService.selectByRandom(mId);
		List<Map> postRankList = postDao.selectPostRanking();
		mv.addObject("member", member);
		mv.addObject("memberList", memberList);
		mv.addObject("postRankList", postRankList);
		List<Post> postList = selectMyList(0, mId, 1);
		for (Post post : postList) {
			post.setTagArray(post.getHasTag().split(" "));
		}
		mv.addObject("postList", postList);
		return mv;
	}
	
	@Override
	public ModelAndView you_main_page(String mId,String mIdYou) {
		ModelAndView mv = new ModelAndView();
		
		Member member = memberService.selectByIdContainFollowInfo(mId);
		List<Member> memberList = memberService.selectByRandom(mId);
		List<Map> postRankList = postDao.selectPostRanking();
		mv.addObject("member", member);
		mv.addObject("memberList", memberList);
		mv.addObject("postRankList", postRankList);
		List<Post> postList = selectMyList(0, mIdYou, 1);
		for (Post post : postList) {
			post.setTagArray(post.getHasTag().split(" "));
		}
		mv.addObject("postList", postList);
		return mv;
	}
	
	@Override
	public ModelAndView personal_main_page(String mId) {
		ModelAndView mv = new ModelAndView();
		
		Member member = memberService.selectByIdContainFollowInfo(mId);
		List<Member> memberList = memberService.selectByRandom(mId);
		mv.addObject("member", member);
		mv.addObject("memberList", memberList);
		List<Post> postList = selectMyList(0, mId, 0);
		for (Post post : postList) {
			post.setTagArray(post.getHasTag().split(" "));
		}
		mv.addObject("postList", postList);
		return mv;
	}
	

}
