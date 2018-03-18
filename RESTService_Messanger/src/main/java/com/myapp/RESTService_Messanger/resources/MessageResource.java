package com.myapp.RESTService_Messanger.resources;


import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.myapp.RESTService_Messanger.model.Message;
import com.myapp.RESTService_Messanger.service.MessageService;

@Path("/messages")
//@Produces(MediaType.APPLICATION_JSON)
//@Consumes(MediaType.APPLICATION_JSON)
public class MessageResource {

	MessageService messageService = new MessageService();
	
	@GET
	//@Produces(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_JSON)
	//localhost:8010/RESTService_Messanger/messages
	//localhost:8010/RESTService_Messanger/messages?year=2018   [for QueryParam]
	//localhost:8010/RESTService_Messanger/messages?start=1&size=1
	public List<Message> getMessages(@QueryParam("year") int year,
									 @QueryParam("start") int start,
									 @QueryParam("size") int size){
		if(year>0){
			return messageService.getAllMessagesByYear(year);
		}
		if(start>=0 && size>0){
			return messageService.getAllMessagesPaginated(start, size);
		}
		return messageService.getAllMessages();
	}
	
	@GET
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_JSON)
	//localhost:8010/RESTService_Messanger/messages/2
	public Message getMessage(@PathParam("messageId") long id){
		return messageService.getMessage(id);
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	//localhost:8010/RESTService_Messanger/messages [post type]
	public Message addMessage(Message message){
		return messageService.addMessage(message);
	}
	
	
	@PUT
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Message updateMessage(@PathParam("messageId") long id,Message message){
		message.setId(id);
		return messageService.updateMessage(message);
	}
	
	@DELETE
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Message deleteMessage(@PathParam("messageId") long id){
		return messageService.deleteMessage(id);
	}
	
	
	
	
	//**********************************************************
	//SubResources
	//webapi/messages/{messageId}/comments
	//webapi/messages/{messageId}/comments/{commentId}
		
	@Path("/{messageId}/comments")
	public CommentResource getCommentResource(){
		return new CommentResource();
	}
}
