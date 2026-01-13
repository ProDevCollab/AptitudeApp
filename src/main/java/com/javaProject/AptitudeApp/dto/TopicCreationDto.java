package com.javaProject.AptitudeApp.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class TopicCreationDto {
    @NotBlank(message = "Topic Name is required")
    @Pattern(regexp = "^[a-zA-Z ]+$", message = "Only letters and spaces are allowed")
    private String topicName;

    private final Long categoryId;

    @NotBlank(message = "Slug is required")
    @Pattern(regexp = "^[a-z-]+$", message = "Only lowercase letters with hypens are allowed")
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
