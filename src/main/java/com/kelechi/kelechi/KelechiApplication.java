package com.kelechi.kelechi;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.kelechi.kelechi.service.util.CloudinaryConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component("com")

@SpringBootApplication
public class KelechiApplication {
	
	@Autowired
	CloudinaryConfig cloudinaryConfig;
	
	public static void main(String[] args) {
		SpringApplication.run(KelechiApplication.class, args);
	}
	
	@Bean
	public Cloudinary getCloudinary(){
	
	return new Cloudinary(ObjectUtils.asMap(
					"cloud_name", cloudinaryConfig.getCloudName(),
					"api_key", cloudinaryConfig.getApiKey(),
					"api_secret", cloudinaryConfig.getApiSecret()));
	}
	
}
