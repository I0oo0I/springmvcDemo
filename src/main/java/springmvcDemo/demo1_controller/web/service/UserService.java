package springmvcDemo.demo1_controller.web.service;

import org.springframework.stereotype.Service;

import springmvcDemo.demo1_controller.web.model.SysUser;

@Service
public class UserService {
	
	/**
	 * 模拟Service层获取用户信息
	 * @param userId
	 * @return
	 */
	public SysUser getUserInfo(String userId) {
		return new SysUser("1","小红", "123456", true);
	}
	
	public SysUser getUserInfoByName(String username) {
		return new SysUser("1","小红", "123456", true);
	}
	
}
