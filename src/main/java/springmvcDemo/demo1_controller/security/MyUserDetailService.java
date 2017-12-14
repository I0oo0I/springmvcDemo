package springmvcDemo.demo1_controller.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import springmvcDemo.demo1_controller.web.model.SysUser;
import springmvcDemo.demo1_controller.web.service.AuthService;
import springmvcDemo.demo1_controller.web.service.UserService;

/**
 * 自定义服务
 * @author Administrator
 *
 */
public class MyUserDetailService implements UserDetailsService{
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private AuthService authorityService;

	@Override
	public MyUserDetail loadUserByUsername(String username) throws UsernameNotFoundException {
		//暂时有一个疑问，如果用户重名了怎么办，使用用户姓名查询，可能出现重名的情况
		SysUser user = userService.getUserInfoByName(username);
		if(null != user) {
			List<String> authorities = authorityService.getUserAuthoritesByUsename(username);
			List<GrantedAuthority> auths = new ArrayList<>();
			if(null != authorities && authorities.size() > 0) {
				for(String authority : authorities) {
					auths.add(new SimpleGrantedAuthority(authority));
				}
			}
			return new MyUserDetail(user.getId(), user.getUsername(), user.getPassword(), auths, user.getIsEnabled());
		}else {
			throw new UsernameNotFoundException("没有找到用户 " + username);
		}
	}

}
