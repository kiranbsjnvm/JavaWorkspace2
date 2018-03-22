package com.myapp;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.myapp.model.Car;

public class Writing {

	public static void main(String[] args) {
		ObjectMapper objectMapper = new ObjectMapper();

		Car car = new Car();
		car.setBrand("BMW");
		car.setDoors(4);
		car.setDate(new Date());

		try {
			
			objectMapper.writeValue(new FileOutputStream("output1.json"), car);
			
			String json = objectMapper.writeValueAsString(car);
			System.out.println(json);
			
			//Date formating
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			objectMapper.setDateFormat(dateFormat);
			String json2 = objectMapper.writeValueAsString(car);
			System.out.println(json2);
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
