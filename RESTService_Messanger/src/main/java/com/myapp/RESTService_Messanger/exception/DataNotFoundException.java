package com.myapp.RESTService_Messanger.exception;

public class DataNotFoundException extends RuntimeException{

	private static final long serialVersionUID = -6350207333645357477L;

	public DataNotFoundException(String msg){
		super(msg);
	}
}
