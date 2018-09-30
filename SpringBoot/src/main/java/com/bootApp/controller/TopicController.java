package com.bootApp.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bootApp.Models.Topic;
import com.bootApp.service.TopicService;

@RestController
public class TopicController {

	@Autowired
	private TopicService topicService;
	
	@RequestMapping("/topics")
	public List<Topic> fettchAllTopics(){
		return topicService.fettchAllTopics();
	}
	
	@RequestMapping("/topics/{id}")
	public Topic getTopic(@PathVariable("id") int topicId){
		return topicService.getTopic(topicId);
	}
	
	@RequestMapping(method=RequestMethod.POST, value = "/topics")
	public void addTopic(@RequestBody Topic topic){
		topicService.addTopic(topic);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value = "/topics")
	public void updateTopic(@RequestBody Topic topic){
		topicService.updateTopic(topic);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value = "/topics/{id}")
	public void deleteTopic(@PathVariable int id){
		topicService.deleteTopic(id);
	}
}
