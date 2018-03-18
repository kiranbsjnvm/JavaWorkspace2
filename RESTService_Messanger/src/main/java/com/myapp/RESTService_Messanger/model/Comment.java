package com.myapp.RESTService_Messanger.model;

import java.util.Date;

public class Comment {

	private long id;
	private String commentMessage;
	private Date createdDate;
	private String author;
	
	public Comment(){
		
	}
	

	public Comment(long id, String commentMessage, Date createdDate, String author) {
		this.id = id;
		this.commentMessage = commentMessage;
		this.createdDate = new Date();
		this.author = author;
	}



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCommentMessage() {
		return commentMessage;
	}

	public void setCommentMessage(String commentMessage) {
		this.commentMessage = commentMessage;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
	
	
}
