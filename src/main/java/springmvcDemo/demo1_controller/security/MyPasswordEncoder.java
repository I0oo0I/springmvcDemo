package springmvcDemo.demo1_controller.security;

import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * spring security 提供了三种的加密实现
 * 		BCryptPasswordEncoder，NoOpPasswordEncoder 和 StandardPasswordEncoder
 * 如果 觉得没有满足自己的需求，可以自定义自己的加密实现
 * @author Administrator
 *
 */
public class MyPasswordEncoder implements PasswordEncoder{

	//加密的方法
	@Override
	public String encode(CharSequence rawPassword) {
		return null;
	}

	//比较
	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		return false;
	}

}
