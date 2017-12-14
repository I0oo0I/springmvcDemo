package springmvcDemo.demo1_controller.web.model;

public class SysUser {

	private String id;
	
	private String username;
	
	private String password;
	
	private Boolean isEnabled;
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Boolean getIsEnabled() {
		return isEnabled;
	}
	
	public void setIsEnabled(Boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	public SysUser(String id, String username, String password, Boolean isEnabled) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.isEnabled = isEnabled;
	}

	public SysUser() {
		super();
	}
	
}
