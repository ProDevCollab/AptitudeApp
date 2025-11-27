package com.javaProject.AptitudeApp.model;

import jakarta.persistence.*;

@Entity
public class LearningResource {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String lrId;
    private String lrUrl;

    @ManyToOne
    @JoinColumn(name = "topic_id")
    private Topic topic;

    public LearningResource() {
    }

    public LearningResource(Topic topic, String lrUrl) {
        this.topic = topic;
        this.lrUrl = lrUrl;
    }

    public String getLrId() {
        return lrId;
    }

    public String getLrUrl() {
        return lrUrl;
    }

    public void setLrUrl(String lrUrl) {
        this.lrUrl = lrUrl;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }
}
