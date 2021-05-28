package com.kelechi.kelechi.service.post;

import com.kelechi.kelechi.data.models.Comment;
import com.kelechi.kelechi.data.models.Post;
import com.kelechi.kelechi.data.repository.PostRepository;
import com.kelechi.kelechi.web.dto.PostDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImplementation implements PostService{
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public Post savePost(PostDto postDto) {
		return null;
	}
	
	@Override
	public List<Post> findAllPosts() {
		return null;
	}
	
	@Override
	public Post updatePost(PostDto postDto) {
		return null;
	}
	
	@Override
	public Post findById(Integer id) {
		return null;
	}
	
	@Override
	public void deletePostById(Integer id) {
	
	}
	
	@Override
	public Post addCommentToPost(Integer id, Comment comment) {
		return null;
	}
}
