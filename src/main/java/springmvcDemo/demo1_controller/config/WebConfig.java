package springmvcDemo.demo1_controller.config;

import java.io.IOException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * 	@Configuration
 *	@EnableWebMvc
 *	public class WebConfig {}, 就这两个就是最简单的SpringMVC配置，会有以下问题
 * 		1. 无视图解析器，默认使用 BeanNameView-Resolver，解析方式：会查找ID和视图名称匹配的bean(例如：return a, 会查找名字为a的bean)，并且这个bean要实现view接口；
 * 			 xml中的配置如下：应该是直接return一个字符串，字符串拼接 .jsp后缀和前缀，找到对应的视图
 *		  	 <!-- 配置视图解析器 -->
 *		     <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
 *		         <!-- 使用前缀和后缀 -->
 *		         <property name="prefix" value="/"></property>
 *		         <property name="suffix" value=".jsp"></property>
 *		     </bean>
 *		2. 没有启用组件扫面，Spring只能找到显示声明在配置类（可以多个配置类，比如这个也算）中的bean；
 * @author Administrator
 *
 */
@Configuration
@EnableWebMvc	//启用mvc
@ComponentScan("springmvcDemo.demo1_controller.web")
public class WebConfig extends WebMvcConfigurerAdapter{

	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		//设置是否把所有在上下文中定义的bean作为request属性可公开访问。这样在JSP 2.0中可使用${}来存取，JSTL中使用c:out。默认为false。
		resolver.setExposeContextBeansAsAttributes(true);
		//resolver.setViewClass(org.springframework.web.servlet.view.JstlView.class); //将视图解析为jstlview
		return resolver;
	} 
	
	/**
	 * 配置静态资资源处理
	 */
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		//要求将静态资源的请求转发到Servlet容器默认的servlet上，而不是DispatcherServlet本身来处理请求
		//因为前配置的 SpittrWebAppInitializer DispatcherServlet拦截的是 return new String[] {"/"}; 所有请求，包括了静态资源的请求
		//将 configurer.enable(); 注释掉后，http://localhost:8080/springmvcDemo/js/test.js 会出现404，访问不到静态资源
		//个人理解：DispacherServlet 的拦截指定的请求，拿到请求后，例如：/home/home 去匹配，匹配的资源是所有的
		//       requestMapping的 url，匹配上了就会执行对应的 方法，没有匹配上就会报404，
		//如果，只是拦截.do的请求，在web-inf外的静态资源是可以直接访问的。
		configurer.enable();
	}
	
	/**
	 * 文件上传 MultipartConfigElement 的替代方法
	 * @return
	 * @throws IOException 
	 */
	@Bean
	public MultipartResolver multipartResolver() throws IOException {
		CommonsMultipartResolver mutipart = new CommonsMultipartResolver();
		mutipart.setUploadTempDir(new FileSystemResource("/upload"));
		mutipart.setMaxInMemorySize(0);
		mutipart.setMaxUploadSize(5000000);
		return mutipart;
	}
}
