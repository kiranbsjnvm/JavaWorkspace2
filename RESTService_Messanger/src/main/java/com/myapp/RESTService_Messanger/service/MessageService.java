package com.myapp.RESTService_Messanger.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.myapp.RESTService_Messanger.database.DatabaseClass;
import com.myapp.RESTService_Messanger.exception.DataNotFoundException;
import com.myapp.RESTService_Messanger.model.Message;

public class MessageService {

	private static Map<Long, Message> messages = DatabaseClass.getMessages();
	
	public MessageService(){
		messages.put(1L, new Message(1,"text1","kiran"));
		messages.put(2L, new Message(2,"text2","kiran"));
	}
	
	
	public List<Message> getAllMessages(){
		return new ArrayList<Message>(messages.values());
	}
	
	public List<Message> getAllMessagesByYear(int  year){
		List<Message> yearList = new ArrayList<>();
		Calendar cal = Calendar.getInstance();
		
		for(Message message : messages.values()){
			cal.setTime(message.getCreated());
			if(cal.get(Calendar.YEAR)==year){
				yearList.add(message);
			}
		}
		
		return yearList;
	}
	
	public List<Message> getAllMessagesPaginated(int start,int size){
		if(start+size > messages.size())
			return new ArrayList<Message>();
		
		List<Message> list = new ArrayList<>(messages.values());
		return list.subList(start, start+size);
	}
	
	
	public Message getMessage(long  id){
		Message message = messages.get(id);
		if(message == null){
			throw new DataNotFoundException("Message not found for "+id);
		}
		return message;
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
