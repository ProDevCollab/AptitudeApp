package com.javaProject.AptitudeApp.dto;

public class TopicCreationDto {
    private String topicName;
    private final Long categoryId;
    
    public TopicCreationDto(String topicName, Long categoryId) {
    	this.topicName = topicName;
    	this.categoryId= categoryId;
    }

    public String getTopicName() {
        return topicName;
    }

    public Long getCategoryId() {
        return categoryId;
    }

}
