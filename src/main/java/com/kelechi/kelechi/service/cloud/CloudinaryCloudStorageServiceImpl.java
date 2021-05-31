package com.kelechi.kelechi.service.cloud;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;

@Service
public class CloudinaryCloudStorageServiceImpl implements CloudStorageService {
	
	
	Cloudinary cloudinary;
	
	@Autowired
	public CloudinaryCloudStorageServiceImpl(Cloudinary cloudinary){
	this.cloudinary =cloudinary;
}
	@Override
	public Map<Object, Object> uploadImage(Map<Object, Object> imageProperties)
			throws IOException {
		
		cloudinary.uploader().upload(imageProperties.get("file"),
				ObjectUtils.emptyMap());
		
		return null;
		
	}
}
