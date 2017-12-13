package springmvcDemo.demo1_controller.config;

import javax.servlet.FilterRegistration.Dynamic;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.WebApplicationInitializer;

import springmvcDemo.demo1_controller.filter.MyFilter;

public class MyFilterInitalizar implements WebApplicationInitializer{


	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		System.out.println("----------------------------------我是自定义Filter----------------------------------");
		Dynamic myFilter = servletContext.addFilter("myFilter", MyFilter.class);
		myFilter.addMappingForUrlPatterns(null, false, "/myServlet");
		//拦截指定的Url
		//如果Filter只是直接映射到 DispatcherServlet, AbstractAnnotationConfigDispatcherServletInitializer 可以有更好的方法
	}

}
