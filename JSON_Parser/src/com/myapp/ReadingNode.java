package com.myapp;

import java.io.IOException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ReadingNode {

	public static void main(String[] args) {

		String carJson =
		        "{ \"brand\" : \"Mercedes\", \"doors\" : 5," +
		        "  \"owners\" : [\"John\", \"Jack\", \"Jill\"]," +
		        "  \"nestedObject\" : { \"field\" : \"value\" } }";

		ObjectMapper objectMapper = new ObjectMapper();


		try {

		    JsonNode node = objectMapper.readValue(carJson, JsonNode.class);

		    JsonNode brandNode = node.get("brand");
		    String brand = brandNode.asText();
		    System.out.println("brand = " + brand);

		    JsonNode doorsNode = node.get("doors");
		    int doors = doorsNode.asInt();
		    System.out.println("doors = " + doors);

		    JsonNode array = node.get("owners");
		    JsonNode readingNode = array.get(0);
		    String john = readingNode.asText();
		    System.out.println("john  = " + john);

		    JsonNode child = node.get("nestedObject");
		    JsonNode childField = child.get("field");
		    String field = childField.asText();
		    System.out.println("field = " + field);

		} catch (IOException e) {
		    e.printStackTrace();
		}

	}

}
