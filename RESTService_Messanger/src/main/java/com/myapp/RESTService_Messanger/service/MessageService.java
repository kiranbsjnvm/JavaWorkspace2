package com.myapp.RESTService_Messanger.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.myapp.RESTService_Messanger.database.DatabaseClass;
import com.myapp.RESTService_Messanger.model.Message;

public class MessageService {

	private static Map<Long, Message> messages = DatabaseClass.getMessages();
	
	public MessageService(){
		messages.put((long) 1, new Message(1,"text1","kiran"));
		messages.put((long) 2, new Message(2,"text2","kiran"));
	}
	
	
	public List<Message> getAllMessages(){
		return new ArrayList<Message>(messages.values());
	}
	
	public Message getMessage(long  id){
		return messages.get(id);
	}
	
	public Message addMessage(Message message){
		message.setId(messages.size()+1);
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message updateMessage(Message message) {
		if(message.getId() <=0){
			return null;
		}
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message deleteMessage(long  id){
		return messages.remove(id);
	}
	
}
