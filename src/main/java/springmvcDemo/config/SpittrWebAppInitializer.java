package springmvcDemo.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * 可以替代  web.xml 的配置方式，唯一问题在于它只能部署到支持Servlet 3.0的服务器中才能正常工作，如Tomcat 7或更高版本。
 * 扩展 AbstractAnnotationConfigDispatcherServletInitializer 的任意类都会自动地配置Dispatcher-Servlet和Spring应用上下文，Spring的应用上下
 * 		文会位于应用程序的Servlet上下文之中。
 * DispatcherServlet 和 ContextLoaderListener（一个servlet监听器） ，看下面的xml配置，里面这两个都有配置
 * 		DispatcherServlet启动时，创建Spring应用的上下文，会加载配置文件或者配置类中所申明的bean
 * 		另外一个上下文 ContextLoaderListener 创建，
 * @author Administrator
 *
 */
public class SpittrWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	/**
	 * 而ContextLoaderListener要加载应用中的其他bean。这些bean通常是驱动应用后端的中间层和数据层组件。
	 * return：返回的带有@Configuration注解的类，将会用来配置ContextLoaderListener创建的应用上下文中的bean。
	 */
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?> [] {RootConfig.class};
	}

	/**
	 * DispatcherServlet 启动时，现在加载自定义的配置类，加载包含Web组件的bean，如控制
	 * 器、视图解析器以及处理器映射。
	 * return：返回的带有@Configuration注解的类，将会用来定义DispatcherServlet应用上下文中的bean。
	 */
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?> [] {WebConfig.class};
	}

	/**
	 * 将一个或者多个路径映射到 DispatcherServlet 上
	 */
	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}
	
//	<!-- 加载spring容器 -->
//    <context-param>
//        <param-name>contextConfigLocation</param-name>
//        <param-value>classpath:applicationContext.xml</param-value>
//    </context-param>
//    <listener>
//        <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
//    </listener>
//		    
//    <!-- 配置前端控制器 -->
//    <servlet>
//      <servlet-name>spring</servlet-name>
//      <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
//      <init-param>
//          <!-- ContextconfigLocation配置springmvc加载的配置文件
//         		 适配器、处理映射器等
//           -->
//          <param-name>contextConfigLocation</param-name>
//          <param-value>classpath:spring-mvc.xml</param-value>
//      </init-param>
//      <init-param>
//      	  <param-name>spring.profiles.default</param-name>		<!-- 为servlet配置默认的profile -->
//      	  <param-value>dev</param-value>
//      </init-param>
//    </servlet>
//    <servlet-mapping>
//        <servlet-name>spring</servlet-name>
//        <!-- 1、.action访问以.action结尾的  由DispatcherServlet进行解析
//           2、/,所有访问都由DispatcherServlet进行解析
//         -->
//        <url-pattern>/</url-pattern>
//    </servlet-mapping>

}
