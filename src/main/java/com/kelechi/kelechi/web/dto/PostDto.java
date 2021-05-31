package com.kelechi.kelechi.web.dto;

import javax.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class PostDto {
	
@NotNull(message = "title can't be null")
	
	private String title;
	
	private String content;
	
	private MultipartFile mageFile;
	
}
