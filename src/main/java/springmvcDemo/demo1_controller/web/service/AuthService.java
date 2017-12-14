package springmvcDemo.demo1_controller.web.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import springmvcDemo.demo1_controller.web.model.UserAuthority;

@Service
public class AuthService {

	/**
	 * 模拟用户权限
	 * @param userId
	 * @return
	 */
	public List<UserAuthority> getUserAuthorites(String userId) {
		List<UserAuthority> authorities = new ArrayList<>();
		authorities.add(new UserAuthority("1", "ROLE_USER", "1"));
		authorities.add(new UserAuthority("2", "ROLE_ADMIN", "1"));
		return authorities;
	}
	
	public List<String> getUserAuthoritesByUsename(String username) {
		List<String> authorities = new ArrayList<>();
		authorities.add("ROLE_USER");
		authorities.add("ROLE_ADMIN");
		return authorities;
	}
}
