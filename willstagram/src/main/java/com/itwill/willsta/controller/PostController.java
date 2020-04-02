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
import com.itwill.willsta.service.PostService;

@RestController
public class PostController {
	@Autowired
	PostService postService;
	
	@RequestMapping(value="/index")
	public ModelAndView selectMyList(HttpServletRequest request) {
		request.getSession().setAttribute("mId", "hjs");
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
	
	@RequestMapping(value="/write_post", method = RequestMethod.POST, produces = "text/html;charset=utf-8")
	public ModelAndView write(Post post, MultipartFile[] uploadFile) {
		ModelAndView mv = new ModelAndView();
		post.setmId("hjs");
		
		Post postOne = postService.createPost(post, uploadFile);
		mv.addObject("post", postOne);
		mv.setViewName("post");

		return mv;
	}
	@ResponseBody
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
	
	@RequestMapping(value="/insert_like", method = RequestMethod.POST, produces = "text/plain;charset=utf-8")
	public String insert_like(@RequestParam(value="pNo", required = true) int pNo) {
		String mId = "hjs";
		Likes lk = new Likes(pNo, mId);
		return postService.insert_like(lk);
		
	}
	
	
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
