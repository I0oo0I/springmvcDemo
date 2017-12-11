package springmvcDemo.demo1_controller.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;

public class MyFilter2 implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("我是MyFilter2， 拦截的DispatcherServlet");
		HttpServletRequest httpRequest = (HttpServletRequest)request;
		String name = httpRequest.getParameter("name");
		if(StringUtils.isNotBlank(name)) {
			if(name.indexOf("aaa") >= 0) {
				System.out.println(name+"是敏感词汇拦截");
			}else {
				chain.doFilter(httpRequest, response);
			}
			
		}
	}

	@Override
	public void destroy() {
		
	}

}
