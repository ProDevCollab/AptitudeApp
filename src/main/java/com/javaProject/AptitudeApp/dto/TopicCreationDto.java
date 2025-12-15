package com.javaProject.AptitudeApp.dto;

public class TopicCreationDto {
    private String topicName;
    private final Long categoryId;
    private String slug;
    
    public TopicCreationDto(String topicName, Long categoryId, String slug) {
    	this.slug = slug;
    	this.topicName = topicName;
    	this.categoryId= categoryId;
    }

    public String getTopicName() {
        return topicName;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public String getSlug() {
        return slug;
    }

}
