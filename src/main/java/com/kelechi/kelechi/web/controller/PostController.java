package com.kelechi.kelechi.web.controller;


import com.kelechi.kelechi.service.post.PostService;
import com.kelechi.kelechi.web.dto.PostDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@Slf4j


@RequestMapping("/posts")

public class PostController {
	
	@Autowired
	
	PostService postServiceImpl;
	
	@PostMapping("/")
	public String getIndex(){
		return "index";
	}
	
	@GetMapping("/save")
	public String getPostFound(){
		
		return "create";
	}
	
	@PostMapping("/save")
	public String savePost(@RequestBody @Valid PostDto postDto){
		
		log.info("Post dto received -->{}", postDto);
		return "index";
		
	}
}
