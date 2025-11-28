package com.javaProject.AptitudeApp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.persistence.criteria.Fetch;

import java.util.List;

@Entity
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long topicId;
    private String topicName;

    @ManyToOne
    @JoinColumn(name = "c_id")
    private Category category;

    @OneToMany(mappedBy = "topic", cascade = CascadeType.ALL)
    private List<LearningResource> learningResources;

    @OneToMany(mappedBy = "topic", cascade = CascadeType.ALL , fetch = FetchType.LAZY)
    private List<Question> questions;

    public Topic() {
    }

    public Topic(String topicName, Category category, List<LearningResource> learningResources, List<Question> questions) {
        this.topicName = topicName;
        this.category = category;
        this.learningResources = learningResources;
        this.questions = questions;
    }

    public Long getTopicId() {
        return topicId;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<LearningResource> getLearningResources() {
        return learningResources;
    }

    public void setLearningResources(List<LearningResource> learningResources) {
        this.learningResources = learningResources;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }


}
