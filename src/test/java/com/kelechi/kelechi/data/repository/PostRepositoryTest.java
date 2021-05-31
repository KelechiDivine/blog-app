package com.kelechi.kelechi.data.repository;

import com.kelechi.kelechi.data.models.Author;
import com.kelechi.kelechi.data.models.Comment;
import com.kelechi.kelechi.data.models.Post;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.jdbc.Sql;



import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Rollback(value = false)
@Slf4j
@Sql(scripts = {"classpath:db/insert.sql"})

class PostRepositoryTest {
	
	@Autowired
	PostRepository postRepository;
	
	@BeforeEach
	void setUp() {
	}
	
	
	@Test
	public void savePostToDBTest() {
		Post blogPost = new Post();
		blogPost.setTitle("what is Fintech?");
		blogPost.setContent("Lorem ipsum dolor sit amet, consectetur adipiscing elit. In nulla erat, luctus non mattis sit amet, finibus quis purus. Vestibulum convallis " +
				"libero id ex mattis blandit. Proin ac facilisis nibh. Pellentesque finibus ligula pharetra, venenatis enim ut, ultrices felis. Aenean egestas " +
				"luctus libero in faucibus. Mauris dapibus, mi in tristique porttitor, erat augue sollicitudin ante, non porta lorem lacus at nibh. Integer " +
				"suscipit augue ac metus vehicula eleifend. Sed id nisi nisi. Aenean quis efficitur est. Aliquam non nisi pharetra erat ullamcorper gravida. " +
				"Ut at dui urna. Etiam ut ipsum a justo malesuada fringilla. Aliquam ornare ex rhoncus sapien consectetur, ac viverra ipsum laoreet. Donec " +
				"massa nulla, pellentesque sed venenatis in, tempor vel mauris. In hac habitasse platea dictumst.");
		log.info("Created a blog post --> {}", blogPost);
		postRepository.save(blogPost);
		assertThat(blogPost.getId()).isNotNull();
	}
	
	@Test
	public void throwExceptionWhenSavingPostWithDuplicateTitle() {
		Post blogPost = new Post();
		blogPost.setTitle("what is Fintech?");
		blogPost.setContent("Lorem ipsum dolor sit amet, consectetur adipiscing elit. In nulla erat, luctus non mattis sit amet, finibus quis purus. Vestibulum convallis " +
				"libero id ex mattis blandit. Proin ac facilisis nibh. Pellentesque finibus ligula pharetra, venenatis enim ut, ultrices felis. Aenean egestas " +
				"luctus libero in faucibus. Mauris dapibus, mi in tristique porttitor, erat augue sollicitudin ante, non porta lorem lacus at nibh. Integer " +
				"suscipit augue ac metus vehicula eleifend. Sed id nisi nisi. Aenean quis efficitur est. Aliquam non nisi pharetra erat ullamcorper gravida. " +
				"Ut at dui urna. Etiam ut ipsum a justo malesuada fringilla. Aliquam ornare ex rhoncus sapien consectetur, ac viverra ipsum laoreet. Donec " +
				"massa nulla, pellentesque sed venenatis in, tempor vel mauris. In hac habitasse platea dictumst.");
		log.info("Created a blog post --> {}", blogPost);
		postRepository.save(blogPost);
		assertThat(blogPost.getId()).isNotNull();
		
		Post blogPost2 = new Post();
		blogPost2.setTitle("what is Fintech?");
		blogPost2.setContent("Lorem ipsum dolor sit amet, consectetur adipiscing elit. In nulla erat, luctus non mattis sit amet, finibus quis purus. Vestibulum convallis " +
				"libero id ex mattis blandit. Proin ac facilisis nibh. Pellentesque finibus ligula pharetra, venenatis enim ut, ultrices felis. Aenean egestas " +
				"n, tempor vel mauris. In hac habitasse platea dictumst.");
		log.info("Created a blog post --> {}", blogPost2);
	}
	
	@Test
	public void whenPostIsSaved_thenSavedAuthor(){
		Post blogPost = new Post();
		blogPost.setTitle("what is Fintech?");
		blogPost.setContent("Lorem ipsum dolor sit amet, consectetur adipiscing elit. In nulla erat, luctus non mattis sit amet, finibus quis purus. Vestibulum convallis " +
				"libero id ex mattis blandit. Proin ac facilisis nibh. Pellentesque finibus ligula pharetra, venenatis enim ut, ultrices felis. Aenean egestas " +
				"luctus libero in faucibus. Mauris dapibus, mi in tristique porttitor, erat augue sollicitudin ante, non porta lorem lacus at nibh. Integer " +
				"suscipit augue ac metus vehicula eleifend. Sed id nisi nisi. Aenean quis efficitur est. Aliquam non nisi pharetra erat ullamcorper gravida. " +
				"Ut at dui urna. Etiam ut ipsum a justo malesuada fringilla. Aliquam ornare ex rhoncus sapien consectetur, ac viverra ipsum laoreet. Donec " +
				"massa nulla, pellentesque sed venenatis in, tempor vel mauris. In hac habitasse platea dictumst.");
		log.info("Created a blog post --> {}", blogPost);
		
		Author author = new Author();
		author.setFirstname("kelechi");
		author.setLastname("okoroafor");
		author.setEmail("okoroaforkelechi.com");
		author.setPhoneNumber("08082167764");
		
		blogPost.setAuthor(author);
		author.addPost(blogPost);
		postRepository.save(blogPost);
		log.info("Blog post after saving --> {}", blogPost);
		
		
	}
	
	@Test
	public void findAllPostInTheTest(){
		
		List<Post> existingPosts = postRepository.findAll();
		assertThat(existingPosts).isNotNull();
		assertThat(existingPosts).hasSize(5);
		
//		log.info("Post author -->", existingPosts.get(1).getAuthor());
	}
	
	@Test
//	@Transactional
//	@Rollback(value = false)
	public void deletePostById(){
		Post savedPost = postRepository.findById(41).orElse(null);
		assertThat(savedPost).isNotNull();
		log.info("Post fetched from the database --> {}", savedPost.getAuthor());
		
		log.info("Post fetched from the database --> {}", savedPost);
		
		postRepository.deleteById(savedPost.getId());
		
		Post deletePost = postRepository.findById(savedPost.getId()).orElse(null);
		assertThat(deletePost).isNull();
		
	}
	
	@Test
	public void updatedSavedPostTest(){
		
		Post savedPost = postRepository.findById(41).orElse(null);
		assertThat(savedPost).isNotNull();
		assertThat(savedPost.getTitle()).isEqualTo("Title post1");
		
		savedPost.setTitle("Pentax title");
		
		postRepository.save(savedPost);
		
		Post updatePost= postRepository.findById(savedPost.getId()).orElse(null);
		assertThat(updatePost).isNotNull();
		
		assertThat(updatePost.getTitle()).isEqualTo("Pentax title");
	}
	
	@Test
	public void updatePostAuthor(){
		
		
		Post savedAuthor = postRepository.findById(41).orElse(null);
		assertThat(savedAuthor).isNotNull();
		assertThat(savedAuthor.getAuthor()).isNull();
		
		log.info("Saved post objects --> {}", savedAuthor);
		
		
		Author author = new Author();
		author.setFirstname("kelechi");
		author.setLastname("okoroafor");
		author.setPhoneNumber("08082167764");
		author.setProfession("civil engineer");
		author.setEmail("okoroaforkelechi123@gmail.com");
		
		savedAuthor.setAuthor(author);
		postRepository.save(savedAuthor);
		
		Post updatePost = postRepository.findById(savedAuthor.getId()).orElse(null);
		assertThat(updatePost).isNotNull();
		assertThat(updatePost.getAuthor()).isNotNull();
		assertThat(updatePost.getAuthor().getLastname()).isEqualTo("okoroafor");
		
		
		
	}
	
	@Test
	public void addCommentToAnAlreadyExistingPost(){
		Post savedPost = postRepository.findById(41).orElse(null);
		assertThat(savedPost).isNotNull();
		assertThat(savedPost.getComments()).hasSize(0);
		
		Comment comment1 = new Comment("Billy goat", "Really insightful post");
		Comment comment2 = new Comment("Peter Bread", "Nice one!");
		
		savedPost.addComment(comment1, comment2);
		postRepository.save(savedPost);

		Post commentedPost = postRepository.findById(savedPost.getId()).orElse(null);
		assertThat(commentedPost).isNotNull();
		assertThat(commentedPost.getComments()).hasSize(2);
		log.info("post fufiled --> {}", commentedPost);
	}
	
}