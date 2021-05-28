package com.kelechi.kelechi.service.post;

import com.kelechi.kelechi.data.repository.PostRepository;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class PostServiceImplementationTest {
	
	
	
	@Mock
	PostRepository postRepository;
	
	@InjectMocks
	PostService postServiceImplementation = new PostServiceImplementation();
	
	
	
	@BeforeEach
	void setUp() {
		
		MockitoAnnotations.openMocks(this);
	}
	}