package springmvcDemo.demo1_controller.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages= {"springmvcDemo"}, 
				excludeFilters= {@Filter(type=FilterType.ANNOTATION, value= EnableWebMvc.class)})
public class RootConfig {

	@Bean
	public PrintBean printBean() {
		return new PrintBean();
	}
}