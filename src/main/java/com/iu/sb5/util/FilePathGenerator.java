package com.iu.sb5.util;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

@Component
public class FilePathGenerator {
	@Autowired
	private ResourceLoader resourceLoader;

	//파일 저장 폴더 생성 후 리턴해 줄 class
	
	//1. resourceLoader 사용
	public File getUseResourceLoader(String filePath) throws Exception{
		
		String path ="classpath:/static/";
		File file= new File(resourceLoader.getResource(path).getFile(), filePath);
		
		if(!file.exists()) {
			file.mkdirs();
		}
		return file;
	}
}
