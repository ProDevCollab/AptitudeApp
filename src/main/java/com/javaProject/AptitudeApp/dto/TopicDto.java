package com.javaProject.AptitudeApp.dto;

public class TopicDto {
    private Long topicId;
    private String topicName;
    private String slug;

    public TopicDto() {

    }

    public TopicDto(Long topicId, String topicName, String slug) {
        this.topicId = topicId;
        this.topicName = topicName;
        this.slug = slug;
    }

    public Long getTopicId() {
        return topicId;
    }

    public String getTopicName() {
        return topicName;
    }

    public String getSlug() {
        return slug;
    }


}
