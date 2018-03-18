package com.myapp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.myapp.services.ShapeService;

public class AppMain {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		ShapeService service = context.getBean("shapeService",ShapeService.class);
		
		//service.getCircle().setName("kiran");
		//service.getCircle().setNameAndReturn("kumar");
		//System.out.println(service.getCircle().getName());
		//System.out.println(service.getTriangle().getName());
	}

}
