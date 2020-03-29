package com.itwill.willsta.controller;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.itwill.willsta.domain.Post;
import com.itwill.willsta.service.PostService;

@RestController
public class PostController {
	@Autowired
	PostService postService;
	
	@RequestMapping(value="/index")
	public ModelAndView selectMyList(@RequestParam(value="userId", required = false, defaultValue = "hjs") String userId) {
		ModelAndView mv = new ModelAndView();
		List<Post> postList = postService.selectMyList(userId);
		for (Post post : postList) {
			post.setTagArray(post.getHasTag().split(" "));
		}
		mv.addObject("postList", postList);
		mv.setViewName("index");
		return mv;
	}
	
	@RequestMapping(value="/post" , produces = "text/html;charset=utf-8")
	public ModelAndView selectPost(@RequestParam(value="pNo", required = true) Integer pNo) {
		ModelAndView mv = new ModelAndView();
		Post post = postService.selectPost(pNo);
		post.setTagArray(post.getHasTag().split(" "));
		
		mv.addObject("post", post);
		mv.setViewName("redirect:post.jsp");
		return mv;
	}
	
	@RequestMapping(value="/write_post", method = RequestMethod.POST, produces = "text/html;charset=utf-8")
	public ModelAndView write(Post post) {
		ModelAndView mv = new ModelAndView();
		post.setmId("hjs");
		//1.데이터 저장처리
		try {
			int rn = postService.createPost(post);
			if(rn >0) {
				//성공인 경우 해당 포스트를 전송해 줌 1개의 포스트를  jsp 로 구성해서 던져줌.
				Post postOne = postService.selectPost(post.getpNo());
				postOne.setTagArray(postOne.getHasTag().split(" "));
				mv.addObject("post", postOne);
				mv.setViewName("post");
				
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			mv.setViewName("error");
		}
		return mv;
	}
	
	@ResponseBody
	@RequestMapping(value="/delete_post", method = RequestMethod.POST, produces = "text/plain;charset=utf-8")
	public String delete(@RequestParam(value="pNo", required = true) int pNo) {
		//1.데이터 저장처리
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
	
	
	/*
	 * 	@RequestMapping(value="/write_post", method = RequestMethod.POST)
	public String write(Post post, 
								HttpServletRequest request) throws Exception {
		String filename="";
		//String fileSavePath="/image/";
		PostImage pi;
		//1.데이터 저장처리
		postService.(post);
		//2.파일처리(파일네임은DB에 저장 하고 파일은 image폴더에 저장)
		if(request.getContentType()!=null && request.getContentType().toLowerCase().startsWith("multipart/")) {
			Collection<Part> parts = request.getParts();
			for (Part part : parts) {
				System.out.println(part.getName());
				System.out.println(filename);

				filename = part.getSubmittedFileName();
				if (!(filename == null || filename.equals(""))) {
					pi = new ProductImage(product.getpNo(), filename);	
					productService.setImage(pi);
					if(part.getSize()>0) {
						part.write(filename);
						part.delete();
					}
				}
				
			}
		}
		
		return "forward:adminlist";
	}
	 */
	
	
}
