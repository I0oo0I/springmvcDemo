package springmvcDemo.demo1_controller.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class PrintBean implements BeanPostProcessor{

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		 System.out.println("***************************************************************");
		 System.out.println("Bean '" + beanName + "' 已创建 ");  
		 System.out.println("***************************************************************");
	     return bean;  
	}

}
