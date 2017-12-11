package springmvcDemo.demo1_controller.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;
import org.springframework.web.WebApplicationInitializer;
import springmvcDemo.demo1_controller.servlet.MyServlet;

/**
 * 这是手动设置 一个 Servlet，当然也可以用这个设置DispatcherServlet，但是 AbstractAnnotationConfigDispatcherServletInitializer 
 * 		可以更好的实现 DispatcherServlet
 * @author Administrator
 *
 */
public class MyServletInitializar implements WebApplicationInitializer{

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		System.out.println("----------------------------------我会自定义Servlet----------------------------------");
		Dynamic myServlet = servletContext.addServlet("myServlet", MyServlet.class);
		myServlet.addMapping("/myServlet");
	}

}
