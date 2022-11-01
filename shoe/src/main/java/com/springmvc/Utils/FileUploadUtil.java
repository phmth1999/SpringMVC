package com.springmvc.Utils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtil {
	public static void saveFile(String uploadDir, String fileName, MultipartFile multipartFile) throws IOException {
		Path path = Paths.get(uploadDir);
		System.out.println(path);
		if (!Files.exists(path)) {
			Files.createDirectories(path);
			System.out.println(path);
		}
		try (InputStream inputStream = multipartFile.getInputStream()){
			Path filePath = path.resolve(fileName);
			System.out.println(filePath);
			Files.copy(inputStream, filePath,StandardCopyOption.REPLACE_EXISTING);
		} catch (Exception e) {
			throw new IOException("Count not save image file"+fileName);
		}
	}
}
