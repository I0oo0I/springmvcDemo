package springmvcDemo.demo1_controller.config;

import javax.servlet.Filter;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import springmvcDemo.demo1_controller.filter.MyFilter2;

/**
 * AbstractAnnotationConfigDispatcherServletInitializer 创建  DispatcherServlet 和 ContextLoaderListener
 * 可以替代  web.xml 的配置方式，唯一问题在于它只能部署到支持Servlet 3.0的服务器中才能正常工作，如Tomcat 7或更高版本。
 * 扩展 AbstractAnnotationConfigDispatcherServletInitializer 的任意类都会自动地配置Dispatcher-Servlet和Spring应用上下文，Spring的应用上下
 * 		文会位于应用程序的Servlet上下文之中。
 * DispatcherServlet 和 ContextLoaderListener（一个servlet监听器） ，看最下面的xml配置，里面这两个都有配置
 * @author Administrator
 *
 */
public class SpittrWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	/**
	 * 而ContextLoaderListener要加载应用中的其他bean。这些bean通常是驱动应用后端的中间层和数据层组件。
	 * 应该是最下面的 web.xml 中配置的 ApplicationContext.xml, 加载相 model层 ，mapper层 ，事务，数据库 , service层的bean配置
	 * return：返回的带有@Configuration注解的类，将会用来配置ContextLoaderListener创建的应用上下文中的bean。
	 */
	@Override
	protected Class<?>[] getRootConfigClasses() {
		System.out.println("----------------------------------我是初始化ContextLoaderListener----------------------------------");
		return new Class<?> [] {RootConfig.class};
	}

	/**
	 * DispatcherServlet 启动时，现在加载自定义的配置类，加载包含Web组件的bean，如控制
	 * 器（Controller层）、视图解析器以及处理器映射。
	 * return：返回的带有@Configuration注解的类，将会用来定义DispatcherServlet应用上下文中的bean。
	 */
	@Override
	protected Class<?>[] getServletConfigClasses() {
		System.out.println("----------------------------------我是初始化DispatcherServlet----------------------------------");
		return new Class<?> [] {WebConfig.class};
	}

	/**
	 * 将一个或者多个路径映射到 DispatcherServlet 上
	 */
	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}
	
	/**
	 * AbstractAnnotationConfigDispatcherServletInitializer 将 DispatcherServlet 注册到 Servlet 容器后会调用的方法，得到注册后的
	 * Registration 的 Dynamic， 通过重载 customizeRegistration()方法，可以对 DispatcherServlet 进行额外的配置
	 * 以下应该都是对 DispatcherServlet的配置
	 */
	@Override
	protected void customizeRegistration(Dynamic registration) {
		System.out.println("----------------------------------我是初始化DispatcherServlet配置参数----------------------------------");
		registration.setLoadOnStartup(1); //设置优先级
		registration.setInitParameter("aa", "dfd");	//设置初始化参数
		//DispatcherServlet 启用配置Servlet 3.0对multipart的支持 , 对应的参数是，位置，最大文件尺寸，最大请求大小，文件写入硬盘临界值
		//如果不是Servlet 3.0 的容器，需要其他的配置方式了，现在在 WebConfig 中定义一个 CommonsMultipartResolver
		//registration.setMultipartConfig(new MultipartConfigElement("/upload", 4000000, 5000000, 0)); 
	}
	
	/**
	 * 覆盖getServletFilter，直接映射到 DispatcherServlet, 意思是作用到 DispatcherServlet 的请求
	 */
	@Override
	protected Filter[] getServletFilters() {
		return new Filter [] {new MyFilter2()};
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
//    </servlet>
//    <servlet-mapping>
//        <servlet-name>spring</servlet-name>
//        <!-- 1、.action访问以.action结尾的  由DispatcherServlet进行解析
//           2、/,所有访问都由DispatcherServlet进行解析
//         -->
//        <url-pattern>/</url-pattern>
//    </servlet-mapping>

}
