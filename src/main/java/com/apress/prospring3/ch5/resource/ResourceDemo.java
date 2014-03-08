/*
 * Created on Sep 26, 2011
 */
package com.apress.prospring3.ch5.resource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.io.Resource;

/**
 * @author clarence
 */
public class ResourceDemo {

    public static void main(String[] args) throws Exception{
    	
    	//這裡用什麼樣的ApplicationContext實作類，都不是重點，載入的是哪一個xxxx.xml也不是重點
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:events/events.xml");
    	/*
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:events/events.xml");
        ctx.refresh();
        */
  
        Resource res1 = ctx.getResource("file:///tmp/test.txt");
        displayInfo(res1);
        Resource res2 = ctx.getResource("classpath:test.txt");
        displayInfo(res2);
        Resource res3 = ctx.getResource("http://www.google.co.uk");
        displayInfo(res3);
    }
    
    private static void displayInfo(Resource res) throws Exception{
        System.out.println(res.getClass());
        System.out.println(res.getURL().getContent());
        System.out.println("");
    }
}
