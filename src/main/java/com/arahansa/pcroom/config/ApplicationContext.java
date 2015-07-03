package com.arahansa.pcroom.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;


@Configuration
@ComponentScan(basePackages = { "com.arahansa.pcroom.service" })
@PropertySource("classpath:application.properties")
@Import({ PersistenceContext.class})
public class ApplicationContext {

	
	
}
