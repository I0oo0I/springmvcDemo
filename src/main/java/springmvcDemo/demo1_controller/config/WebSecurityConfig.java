package springmvcDemo.demo1_controller.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

import springmvcDemo.demo1_controller.security.MyUserDetailService;

/**
 * @EnableWebSecurity 启用web安全功能
 * Spring Security必须配置在一个实现了 WebSecurityConfigurer 的bean中，或者（简单起见）扩展 WebSecurityConfigurerAdapter
 * @author Administrator
 *
 */
@Configuration
@EnableWebSecurity
//@EnableWebMvcSecurity	 这个是 Spring mvc 开启安全功能，但是在 Spring security 3.2 之后，这个就废弃了，还是用  @EnableWebSecurity 代替
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private DataSource dataSource;
	
	/**
	 * 通过重载配置 user-detail 服务， 配置用户的信息，作为验证源
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//启用内存用户存储，就是没有数据库数据源，使用本地用户配置
		// roles("USER") 是  authorities("") 的简写， 实际结果都是   authorities("ROLE_USER"), role("") 最后都会拼接前缀
		
//		auth.inMemoryAuthentication()
//			.withUser("user").password("123").roles("USER").and()
//			.withUser("admin").password("123").roles("USER", "ADMIN");
		
		//withUser.accountExpired(boolean)							定义账号是否过期
		//withUser.accountLocked(boolean)							定义账号是否锁定
		//withUser.authorities(GrantedAuthority...)					授予某个用户一个或多个权限
		//withUser.authorities(List<? extends GrantedAuthority>)	授予某个用户一个或多个权限
		//withUser.authorities(String...)							授予某个用户一个或多个权限
		//withUser.credentialsExpired(boolean) 						定义凭证是否过期
		//withUser.disabled(boolean)								定义账号是否被禁用
		//withUser.password(String)									定义用户密码
		//withUser.roles(String...) 								授予某个用户一个或多个权限
		//withUser.and()											用来连接作用，可以配置多个用户
		
		//基于 jdbc 的数据库的最简单配置,但是它有一些默认的查询sql的配置，例如如下：
		//public static final String DEF_USERS_BY_USERNAME_QUERY = "select username, password,enable from users where username = ?";
		//public static final String DEF_AUTHORITIES_BY_USERNAME_QUERY = 'select username, authority from authorities where username = ?'
		//public static final String DET_GROUP_AUTHORITIES_BY_USERNAME_QUERY = 
		//		'select g.id, g.group_name, ga.authority from groups g, group_members gm, group_authories ga where gm.username = ?
		//		 and g.id = gm.group_id and g.id = ga.group_id'
		//上面依次是 	查询用户信息， 用户权限信息，用户组权限信息
		//这些都被限制死了
//		auth.jdbcAuthentication()
//			.dataSource(dataSource);
		
		//自己重写默认的的SQL语句，密码转换器，查询到的加密密码，通过密码转换器，将用户提交的明文密码进行加密，然后比较加密后的密码
//		auth.jdbcAuthentication()
//		.dataSource(dataSource)
//			.usersByUsernameQuery("select username, password, true from sys_users where username = ?") //这里默认了 enable = true
//			.authoritiesByUsernameQuery("select username, 'ROLE_USER' from sys_users where username =?") //这里默认了authority = 'ROLE_USER'
//			.passwordEncoder(new StandardPasswordEncoder("53cr3t")); //当然也可以使用自定义的密码加密方法  MyPasswordEncoder
		//还有其他的一些重写方法等。
		//将默认的SQL查询替换为自定义的设计时，很重要的一点就是要遵循查询的基本协议。所有查询都将用户名作为唯一的参数。
		//		认证查询会选取用户名、密码以及启用状态信息。
		//		权限查询会选取零行或多行包含该用户名及其权限信息的数据。
		//		群组权限查询会选取零行或多行数据，每行数据中都会包含群组ID、群组名称以及权限。
		
		//ladp的验证，暂时跳过。。。。。。。。。
		
		//配置自定义用户服务
		auth.userDetailsService(new MyUserDetailService()); 
	}
	
	/**
	 * 拦截请求，指定哪些请求需要验证
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/api/home/home4").authenticated()	//前面指定要验证的url， 后面执行验证操作, 也可以使用通配符/api/**
			.antMatchers(HttpMethod.POST, "/api/home/home3").authenticated() //也可以指定方法
			.anyRequest().permitAll();		//其他的方法都方行
	}
}
