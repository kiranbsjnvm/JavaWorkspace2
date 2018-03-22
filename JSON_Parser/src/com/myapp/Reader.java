package com.myapp;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.myapp.model.Car;

public class Reader {
	
	public static void main(String[] args) {
		
		ObjectMapper objectMapper = new ObjectMapper();
		String carJson = "{ \"brand\" : \"Mercedes\", \"doors\" : 5 }";
		
		try{
			Car car = objectMapper.readValue(carJson, Car.class);
			System.out.println("Brand = " + car.getBrand() +"; Doors: "+car.getDoors());
		    
		    
		    //Reading object from json file
			File file = new File("car.json");
			Car car2 = objectMapper.readValue(file, Car.class);
			System.out.println("Brand = " + car2.getBrand() +"; Doors: "+car2.getDoors());
		    
		    
		    //Read Object From JSON InputStream
		    InputStream input = new FileInputStream("car.json");
		    Car car3 = objectMapper.readValue(input, Car.class);
		    System.out.println("Brand = " + car3.getBrand() +"; Doors: "+car3.getDoors());
		    
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		
		//Reading list of cars
		try{
			File file1 = new File("cars.json");
			List<Car> cars = objectMapper.readValue(file1, new TypeReference<List<Car>>(){});
		
			for(Car c:cars){
				System.out.println("Brand = " + c.getBrand() +"; Doors: "+c.getDoors());
			}
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		
		
	}
	
}
