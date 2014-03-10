package com.kashu.test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

@Configuration
@ComponentScan(basePackages={"com.kashu.test"})
public class AppConfig {
	@Bean
	public String message(){
		return new String("Java Configuration is running 幹得好!");
	}
	
	@Bean
	@DependsOn(value="message")
	public MessageProvider messageProvider(){
		//Constructor injection
		return new ConfigurableMessageProvider(message());
	}
	
	@Bean
	@DependsOn(value="messageProvider")
	public MessageRenderer messageRenderer(){
		MessageRenderer renderer = new StandardOutMessageRenderer();
		//setter injection
		renderer.setMessageProvider(messageProvider());
		return renderer;
	}
}
