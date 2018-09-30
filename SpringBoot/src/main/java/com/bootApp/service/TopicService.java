package com.bootApp.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootApp.Models.Topic;
import com.bootApp.repository.TopicRepository;

@Service
public class TopicService {

	@Autowired
	private TopicRepository topicRepository;
	
	
	public List<Topic> fettchAllTopics(){
		List<Topic> topics = new ArrayList<>();
		for(Topic t: topicRepository.findAll()){
			topics.add(t);
		}
		return topics;
		
	}
	
	public Topic getTopic(int id) {
		return topicRepository.findById(id).get();
	}
	
	public void addTopic(Topic topic){
		topicRepository.save(topic);
	}

	public void updateTopic(Topic topic) {
		topicRepository.save(topic);
	}

	public void deleteTopic(int id) {
		topicRepository.deleteById(id);
	}
}
