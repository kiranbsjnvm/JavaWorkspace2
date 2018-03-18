package com.myapp.models;

import com.myapp.aspects.Loggable;

public class Circle {

	private String name;

	public String getName() {
		return name;
	}

	@Loggable
	public void setName(String name) {
		this.name = name;
		//System.out.println("Circle setter method");
	}
	
	public String setNameAndReturn(String name) {
		this.name = name;
		return this.name;
	}
	
}
