package com.myapp.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import com.myapp.models.Circle;

@Aspect
public class LoggingAspect {

	//@Before("execution(public String getName())") //this runs before all getName() methods
	/*@Before("execution(public String com.myapp.models.Circle.getName())")  //this restricted to only Circle.getName()
	public void LoggingAdvice1(){ 
		System.out.println("CIRCLE : Adive run, Get method called");
	}
	
	@Before("execution(public String com.myapp.models.Triangle.getName())")
	public void LoggingAdvice2(){ 
		System.out.println("TRIANGLE : Adive run, Get method called");
	}*/
	

	
	//***********************************************************

	/*//this advice is executed for all methods which start with get and return type anything
	//this is wildcards
	@Before("execution(public * get*())")  
	public void LoggingAdvice(){ 
		System.out.println("for all get methods Adive run, Get method called");
	}
	
	//another advice get executed before each get method
	@Before("execution(public * get*())")  
	public void secondLoggingAdvice(){ 
		System.out.println("second get methods Adive run, Get method called");
	}*/
	
	
	
	
	//OR ************************************
	//using pointcutters
	//@Before("allGetters()")  
	//@Before("allGetters() && forAllCircleMethods()") // combining two pointcuts  
	/*public void LoggingAdvice(){ 
		System.out.println("for all get methods Advice run, Get method called");
	}
	
	@Before("allGetters()")  
	public void secondLoggingAdvice(){ 
		System.out.println("second get methods Advice run, Get method called");
	}
	
	@Pointcut("execution(public * get*())")
	public void allGetters() {}*/
	
	
	//*****************************************************
	//any access modifier, any return type, any number of parameters and for all the methods inside Circle class
	/*@Pointcut("execution(* com.myapp.models.Circle.*(..))")
	public void forAllCircleMethods() {}
	
	//or
	@Pointcut("within(com.myapp.models.Circle)")
	public void forAllCircleMethods2() {}
	
	//or [this is for entire package
	@Pointcut("within(com.myapp.models.*)")
	public void forAllCircleMethods3() {}*/
	
	
	
	//*****************************************************
	/*@Before("forAllCircleMethods()")
	public void LoggingAdvice3(JoinPoint joinPoint)
	{
		//JoinPoint contains all  the information about current method in which advice is running
		//System.out.println(joinPoint.toString());
		//System.out.println(joinPoint.getTarget());
		
		//Circle circle = (Circle)joinPoint.getTarget();
	}*/
	
	
	
	//***************************************************
	
	/*@Before("args(String)")
	public void adiveForAllStringArgsMethods(){
		System.out.println("Method which takes String as argument");
	}*/
	
	//to get returned value  
	/*@AfterReturning(pointcut="args(name)",returning="returnedString")
	public void adiveForAllStringArgsMethods2(String name,String returnedString){
		System.out.println(" After: Method which takes String as argument "+name+". Returned value : "+returnedString);
		
	}
	
	@Before("args(name)")
	public void adiveForAllStringArgsMethods2(String name){
		System.out.println("Before : Method which takes String as argument; The value is :"+name);
	}
	
	@After("args(String)")
	public void afterAdiveForAllStringArgsMethods(){
		System.out.println("After advice :Method which takes String as argument");
	}*/
	
	/*@AfterReturning("args(String)")
	public void afterAdive1(){
		System.out.println("After advice : after succesfull return");
	}*/
	
	/*@AfterThrowing("args(String)")
	public void afterAdive2(){
		System.out.println("After advice : after throwing exception");
	}*/
	
} 
