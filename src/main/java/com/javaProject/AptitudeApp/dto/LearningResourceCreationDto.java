package com.javaProject.AptitudeApp.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.URL;

public class LearningResourceCreationDto {
    private Long topicId;

    @NotBlank(message = "URL is required")
    @URL(protocol = "https", message = "Must be a valid HTTPS URL")
    @Pattern( regexp = "^[^\s]+$", message = "URL should not contain spaces")
    private String resourceUrl;

    public Long getTopicId() {
        return topicId;
    }

    public String getResourceUrl() {
        return resourceUrl;
    }

}
