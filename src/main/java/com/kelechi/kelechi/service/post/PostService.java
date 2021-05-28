package com.kelechi.kelechi.service.post;

import com.kelechi.kelechi.data.models.Post;

import java.util.List;

public interface PostService {
	
	
	Post savePost();
	List<Post> findAllPosts();
	
	Post updatePost();
}
