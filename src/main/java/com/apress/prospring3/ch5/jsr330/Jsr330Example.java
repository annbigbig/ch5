/**
 * Created on Sep 27, 2011
 */
package com.apress.prospring3.ch5.jsr330;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.apress.prospring3.ch5.javaconfig.AppConfig;

/**
 * @author Clarence
 *
 */
public class Jsr330Example {

	public static void main(String[] args) {
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:jsr330/jsr330.xml");
		ctx.refresh();
		
		MessageRenderer renderer = ctx.getBean("messageRenderer", MessageRenderer.class);
		renderer.render();
	}

}
