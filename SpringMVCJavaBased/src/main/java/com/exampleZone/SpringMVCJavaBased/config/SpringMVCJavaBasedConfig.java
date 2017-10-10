package com.exampleZone.SpringMVCJavaBased.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.exampleZone.SpringMVCJavaBased")
public class SpringMVCJavaBasedConfig {

	@Bean
	public ViewResolver viewResolver()
	{
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views/jsp/");
		viewResolver.setSuffix(".jsp");
		
		return viewResolver;
	}
	
	/**
	 * @return for returning the name of the property file which defines the error messages to return if invalid values are inserted in the form
	 * 			as per defined in the Entity classes
	 */
	@Bean
	public MessageSource messageSource()
	{
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("message");
		return messageSource;
	}
}
