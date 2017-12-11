package springmvcDemo.demo1_controller.data;

import org.springframework.web.multipart.MultipartFile;

public class RequestUploadFile {

	private String username;
	
	private MultipartFile uploadFile;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public MultipartFile getUploadFile() {
		return uploadFile;
	}

	public void setUploadFile(MultipartFile uploadFile) {
		this.uploadFile = uploadFile;
	}
	
}
