package com.javaProject.AptitudeApp.service.Impl;

import com.javaProject.AptitudeApp.dao.*;
import com.javaProject.AptitudeApp.dto.CategoryDto;
import com.javaProject.AptitudeApp.dto.TopicDto;
import com.javaProject.AptitudeApp.model.*;
import com.javaProject.AptitudeApp.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService implements IAdminService {

    private ICategoryRepo categoryRepo;
    private ILearningResourceRepo learningResourceRepo;
    private ITopicRepo  topicRepo;
    private IQuestionRepo questionRepo;

    @Autowired
    public void setCategoryRepo(ICategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    @Autowired
    public void setLearningResourceRepo(ILearningResourceRepo learningResourceRepo) {
        this.learningResourceRepo = learningResourceRepo;
    }

    @Autowired
    public void setTopicRepo(ITopicRepo topicRepo) {
        this.topicRepo = topicRepo;
    }

    @Autowired
    public void setQuestionRepo(IQuestionRepo questionRepo) {
        this.questionRepo = questionRepo;
    }

    @Override
    public String addTopic(String topicName, Long categoryId) {
        categoryRepo.findById(categoryId)
                .ifPresentOrElse(category -> topicRepo.save(new Topic(topicName, category)),
                        () -> { throw new RuntimeException("Category not found with id: " + categoryId);});
        return "Topic added successfully";
    }

    @Override
    public String addLearningResource(String resourceUrl, Long topicId) {
        topicRepo.findById(topicId)
                .ifPresentOrElse(topic -> learningResourceRepo.save(new LearningResource(topic, resourceUrl)),
                        () -> { throw new RuntimeException("Topic not found with id: " + topicId);});
        return "Learning Resource added successfully";
    }

    @Override
    public String addQuestion(String question, byte[] imageData, String opA, String opB, String opC, String opD, String answer, Long topicId) {
        // Implementation for adding a question
        topicRepo.findById(topicId);

        return "Question added successfully";
    }

    public List<CategoryDto> getAllCategories(){
        List<Category> categoryList = categoryRepo.findAll();
        return categoryList.stream().map(c -> new CategoryDto(c.getcId(), c.getcName())).toList();
    }

    public List<TopicDto> getAllTopics() {
        List<Topic> topicList = topicRepo.findAll();
        return topicList.stream().map(topic -> new TopicDto(topic.getTopicId(), topic.getTopicName())).toList();
    }
}
