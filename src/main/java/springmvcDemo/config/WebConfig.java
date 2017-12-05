package springmvcDemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * 	@Configuration
 *	@EnableWebMvc
 *	public class WebConfig {}, 就这两个就是最简单的SpringMVC配置，会有以下问题
 * 		1. 无视图解析器，默认使用 BeanNameView-Resolver，解析方式：会查找ID和视图名称匹配的bean，并且这个bean要实现view接口；
 * 			 xml中的配置如下：应该是直接return一个字符串，字符串拼接 .jsp后缀和前缀，找到对应的视图
 *		  	 <!-- 配置视图解析器 -->
 *		     <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
 *		         <!-- 使用前缀和后缀 -->
 *		         <property name="prefix" value="/"></property>
 *		         <property name="suffix" value=".jsp"></property>
 *		     </bean>
 *		2. 没有启用组件扫面，Spring只能找到显示声明在配置类（可以多个配置类，比如这个也算）中的bean；
 *		3. 会拦截所有的请求，包括静态资源的
 * @author Administrator
 *
 */
@Configuration
@EnableWebMvc	//启用mvc
@ComponentScan("springmvcDemo.web")
public class WebConfig extends WebMvcConfigurerAdapter{

	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		//设置是否把所有在上下文中定义的bean作为request属性可公开访问。这样在JSP 2.0中可使用${}来存取，JSTL中使用c:out。默认为false。
		resolver.setExposeContextBeansAsAttributes(true);
		return resolver;
	} 
	
	/**
	 * 配置静态资资源处理
	 */
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		//要求将静态资源的请求转发到Servlet容器默认的servlet上，而不是DispatcherServlet本身来处理请求
		configurer.enable();
	}
}
