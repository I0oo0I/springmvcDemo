package springmvcDemo.demo1_controller.web.model;

public class UserAuthority {

	private String id;
	
	private String authorityName;
	
	private String userId;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAuthorityName() {
		return authorityName;
	}

	public void setAuthorityName(String authorityName) {
		this.authorityName = authorityName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public UserAuthority(String id, String authorityName, String userId) {
		super();
		this.id = id;
		this.authorityName = authorityName;
		this.userId = userId;
	}

	public UserAuthority() {
		super();
	}
	
}
