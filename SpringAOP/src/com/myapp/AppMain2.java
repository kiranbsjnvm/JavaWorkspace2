package com.myapp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.myapp.services.ShapeService;

public class AppMain2 {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		ShapeService service = context.getBean("shapeService",ShapeService.class);
		
		//System.out.println(service.getCircle().getName());
		
		//custome annotation
		//service.getCircle().setName("kiran");
	}

}
