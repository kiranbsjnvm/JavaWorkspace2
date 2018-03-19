package com.myapp.RESTService_Messanger.database;

import java.util.HashMap;
import java.util.Map;

import com.myapp.RESTService_Messanger.model.Message;
import com.myapp.RESTService_Messanger.model.Profile;

public class DatabaseClass {

	private static Map<Long, Message> messages = new HashMap<>();
	private static Map<String, Profile> profiles = new HashMap<>();
	
	public DatabaseClass(){
	}
	
	public static Map<Long, Message> getMessages(){
		return messages;
	}
	
	public static Map<String, Profile> getProfiles(){
		return profiles;
	}
}
