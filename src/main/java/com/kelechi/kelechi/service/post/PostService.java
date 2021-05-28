package com.kelechi.kelechi.service.post;

import com.kelechi.kelechi.data.models.Comment;
import com.kelechi.kelechi.data.models.Post;
import com.kelechi.kelechi.web.dto.PostDto;

import java.util.List;

public interface PostService {
	
	
	Post savePost(PostDto postDto);
	
	List<Post> findAllPosts();
	
	Post updatePost(PostDto postDto);
	
	Post findById(Integer id);
	
	void deletePostById(Integer id);
	
	Post addCommentToPost(Integer id, Comment comment);
	
}
