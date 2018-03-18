package com.myapp.aspects;

import org.aspectj.lang.ProceedingJoinPoint;

public class LoggingAspect3 {

	//configuring this aspect in xml
	public Object aroundAdvice(ProceedingJoinPoint proceedingJoinPoint){  
		
		Object returningValue = null;
		try {
			System.out.println("Before advice");
			
			returningValue = proceedingJoinPoint.proceed();
			
			System.out.println("after returning");
			
		} catch (Throwable e) {
			System.out.println("after throwing");
		}
		
		System.out.println("finally");
		return returningValue;
	}
	
}
