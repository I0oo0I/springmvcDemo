package springmvcDemo.demo1_controller.data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class InputDataValid {

	@NotNull
	private String id;
	
	@NotBlank
	@Size(min=6, max=18, message="${name.size}")
	private String name;
	
	@javax.validation.constraints.Email(message="${email.valid}")
	private String Email;
	
	@Size(min=0, max=150, message="${age.size}")
	private Integer age;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	
}
