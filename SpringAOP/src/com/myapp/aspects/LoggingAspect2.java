package com.myapp.aspects;

import javax.sound.midi.VoiceStatus;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggingAspect2 {

	@Pointcut("execution(public * get*())")
	public void allGetters() {}
	
	
	/*@Around("allGetters()")
	public Object aroundAdvice(ProceedingJoinPoint proceedingJoinPoint){  //ProceedingJoinPoint parameter is compulsarry
		Object returningValue = null;
		try {
			//Write Before logic/code for before executing target method
			System.out.println("Before advice");
			
			//this is the place where target method get executed
			returningValue = proceedingJoinPoint.proceed();
			
			//Write After logic/code for after executing target method
			System.out.println("after returning");
			
		} catch (Throwable e) {
			System.out.println("after throwing");
		}
		
		System.out.println("finally");
		return returningValue;
	}*/
	
	
	//created custome annotation , and applied that annotation in target method, now specifying annotaion path here 
	@Before("@annotation(com.myapp.aspects.Loggable)")
	public void customeAnnotationAdive(){
		System.out.println("Before Advice with custome annotation");
	}
	
}
