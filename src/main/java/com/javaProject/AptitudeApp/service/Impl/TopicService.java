package com.javaProject.AptitudeApp.service.Impl;

import com.javaProject.AptitudeApp.dao.ILearningResourceRepo;
import com.javaProject.AptitudeApp.dao.ITopicRepo;
import com.javaProject.AptitudeApp.dto.LearningResourceDto;
import com.javaProject.AptitudeApp.model.LearningResource;
import com.javaProject.AptitudeApp.model.Topic;
import com.javaProject.AptitudeApp.service.ITopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicService implements ITopicService {

    private ITopicRepo topicRepo;
    private ILearningResourceRepo learningResourceRepo;

    @Autowired
    public void setTopicRepo(ITopicRepo topicRepo) {
        this.topicRepo = topicRepo;
    }

    @Autowired
    public void setLearningResourceRepo(ILearningResourceRepo learningResourceRepo) {
        this.learningResourceRepo = learningResourceRepo;
    }

    @Override
    public List<LearningResourceDto> getLearningResourcesByTopic(String slug) {
        Topic topic = topicRepo.findBySlug(slug);
        List<LearningResource> learningResourcesList = learningResourceRepo.findByTopic(topic);

        return learningResourcesList.stream()
                .map(lr -> new LearningResourceDto(lr.getLrUrl()))
                .toList();
    }
}
