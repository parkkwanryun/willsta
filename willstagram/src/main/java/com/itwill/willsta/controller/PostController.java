package com.itwill.willsta.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.itwill.willsta.domain.Likes;
import com.itwill.willsta.domain.Post;
import com.itwill.willsta.domain.PostImage;
import com.itwill.willsta.service.MemberService;
import com.itwill.willsta.service.PostService;

@RestController
public class PostController {
	@Autowired
	PostService postService;
	@MemberLoginCheck
	@RequestMapping(value="/index")
	public ModelAndView selectMyList(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		String mId = (String)request.getSession().getAttribute("mId");
		List<Post> postList = postService.selectMyList(mId);
		for (Post post : postList) {
			post.setTagArray(post.getHasTag().split(" "));
		}
		mv.addObject("postList", postList);
		mv.setViewName("index");
		return mv;
	}
	@MemberLoginCheck
	@RequestMapping(value="/main_post")
	public ModelAndView selectMainList(HttpServletRequest request) {
		
		String mId = (String)request.getSession().getAttribute("mId");
		ModelAndView mv = postService.main_page(mId);
		
		mv.setViewName("main_post");
		return mv;
	}
	@MemberLoginCheck
	@RequestMapping(value="/get_post" , produces = "text/html;charset=utf-8")
	public ModelAndView selectPost(@RequestParam(value="pNo", required = true) Integer pNo, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		String mId = (String)request.getSession().getAttribute("mId");
		Post post = postService.selectPost(pNo, mId);
		post.setTagArray(post.getHasTag().split(" "));
		List<PostImage> postImages = postService.selectContents(pNo);
		
		mv.addObject("post", post);
		mv.addObject("postImages", postImages);
		mv.setViewName("detail");
		return mv;
	}
	@MemberLoginCheck
	@RequestMapping(value="/get_post_data" , produces = "application/json;charset=utf-8")
	public Post selectPostData(@RequestParam(value="pNo", required = true) Integer pNo, HttpServletRequest request) {
		String mId = (String)request.getSession().getAttribute("mId");
		Post post = postService.selectPost(pNo, mId);
		post.setTagArray(post.getHasTag().split(" "));
		//List<PostImage> postImages = postService.selectContents(pNo);
		return post;
	}
	@MemberLoginCheck
	@RequestMapping(value="/write_post", method = RequestMethod.POST, produces = "text/html;charset=utf-8")
	public ModelAndView write(Post post, MultipartFile[] uploadFile, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		post.setmId((String)request.getSession().getAttribute("mId"));
		
		Post postOne = postService.createPost(post, uploadFile);
		//post번호가 있으면 update, 없으면 insert
		/*if(post.getpNo()!=null && post.getpNo() > 0) {
			Post postOne = postService.modifyPost(post);
		} else {
			Post postOne = postService.createPost(post, uploadFile);
		}
		*/
		mv.addObject("post", postOne);
		mv.setViewName("post");

		return mv;
	}
	@ResponseBody
	@MemberLoginCheck
	@RequestMapping(value="/delete_post", method = RequestMethod.POST, produces = "text/plain;charset=utf-8")
	public String delete(@RequestParam(value="pNo", required = true) int pNo) {
		
		
		try {
			int rn = postService.removePost(pNo);
			if(rn >0) {
				return "success";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}

		return "fail";
		
	}
	@MemberLoginCheck
	@RequestMapping(value="/insert_like", method = RequestMethod.POST, produces = "text/plain;charset=utf-8")
	public String insert_like(@RequestParam(value="pNo", required = true) int pNo) {
		String mId = "hjs";
		Likes lk = new Likes(pNo, mId);
		return postService.insert_like(lk);
		
	}
	
	@MemberLoginCheck
	@RequestMapping(value="/status_change", method = RequestMethod.POST, produces = "text/plain;charset=utf-8")
	public String status_change(@RequestParam(value="pNo", required = true) int pNo,
								@RequestParam(value="status", required = true) String status) {
		if(status.equals("Hide")) {
			status = "H";
		} else {
			status = "A";
		}
		int rn = postService.status_change(pNo, status);
		if(rn >0) {
			return "success";
		}
		return "fail";
	}
	
	
	
	
}
