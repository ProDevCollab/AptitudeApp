package com.javaProject.AptitudeApp.dto;

public class TopicDto {
    private Long topicId;
    private String topicName;

    public TopicDto() {

    }

    public TopicDto(Long topicId, String topicName) {
        this.topicId = topicId;
        this.topicName = topicName;
    }

    public Long getTopicId() {
        return topicId;
    }

    public String getTopicName() {
        return topicName;
    }
}
