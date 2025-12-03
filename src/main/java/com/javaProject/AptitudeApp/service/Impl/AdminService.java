package com.javaProject.AptitudeApp.service.Impl;

import com.javaProject.AptitudeApp.dao.ICategoryRepo;
import com.javaProject.AptitudeApp.dao.ILearningResourceRepo;
import com.javaProject.AptitudeApp.dao.ITopicRepo;
import com.javaProject.AptitudeApp.dto.CategoryDto;
import com.javaProject.AptitudeApp.model.Category;
import com.javaProject.AptitudeApp.model.LearningResource;
import com.javaProject.AptitudeApp.model.Topic;
import com.javaProject.AptitudeApp.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminService implements IAdminService {
    @Autowired
    private ICategoryRepo categoryRepo;

    @Autowired
    private ILearningResourceRepo learningResourceRepo;

    @Autowired
    private ITopicRepo  topicRepo;

    @Override
    public String addTopic(Long categoryId, String topicName) {
        categoryRepo.findById(categoryId)
                .ifPresentOrElse(category -> topicRepo.save(new Topic(topicName, category)),
                        () -> { throw new RuntimeException("Category not found with id: " + categoryId);});
        return "Topic added successfully";
    }

    @Override
    public String addLearningResource(Long topicId, String resourceUrl) {
        topicRepo.findById(topicId)
                .ifPresentOrElse(topic -> learningResourceRepo.save(new LearningResource(topic, resourceUrl)),
                        () -> { throw new RuntimeException("Topic not found with id: " + topicId);});
        return "Learning Resource added successfully";
    }

    @Override
    public String addQuestion() {
        // Implementation for adding a question
        return null;
    }

    public List<CategoryDto> getAllCategories(){
        List<Category> categoryList = categoryRepo.findAll();
        return categoryList.stream().map(c -> new CategoryDto(c.getcId(), c.getcName())).toList();
    }
}
