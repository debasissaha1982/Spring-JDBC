package com.springjdbctemplete.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.springjdbctemplete.dao.ContactDAImpl;
import com.springjdbctemplete.dao.ContactDAO;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.springjdbctemplete")
public class SpringMVCConfig implements WebMvcConfigurer{
	
	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource datasource = new DriverManagerDataSource();
		datasource.setDriverClassName("com.mysql.jdbc.Driver");
		datasource.setUrl("jdbc:mysql://localhost:3306/springjdbctemplete");
		datasource.setUsername("root");
		datasource.setPassword("welcome123");	
		
		return datasource;
	}
	
	@Bean
	public ViewResolver getViewResolver() {
		
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		
		return resolver;
	}
	
	@Bean
	public ContactDAO getContactDAO() {
		return new ContactDAImpl(getDataSource());
	}

}
