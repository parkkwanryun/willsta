package com.itwill.willsta.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.itwill.willsta.domain.Post;
import com.itwill.willsta.service.PostService;

@Controller
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
	
	@RequestMapping(value="/write_post")
	public ModelAndView write_post() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("write_post");
		return mv;
	}
	/*
	@RequestMapping(value="/write_post", method = RequestMethod.POST)
	public String productUpdate(Post post, 
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
