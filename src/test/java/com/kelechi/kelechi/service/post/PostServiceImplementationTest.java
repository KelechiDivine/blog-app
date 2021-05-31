package com.kelechi.kelechi.service.post;

import com.kelechi.kelechi.data.models.Post;
import com.kelechi.kelechi.data.repository.PostRepository;
import com.kelechi.kelechi.web.dto.PostDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

class PostServiceImplementationTest {
	
	
	@Mock
	PostRepository postRepository;
	
	@InjectMocks
	PostServiceImplementation postServiceImplementation = new PostServiceImplementation();
	
	Post testPost;
	
	@BeforeEach
	void setUp() {
		
		testPost = new Post();
		
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	public void whenTheSaveMethodIsCalled_thenRepositoryIsCalledOnceTest() {
		when(postServiceImplementation.savePost(new PostDto())).thenReturn(testPost);
		
		postServiceImplementation.savePost(new PostDto());
		
		
		verify(postRepository, times(1)).save(testPost);

	}
}