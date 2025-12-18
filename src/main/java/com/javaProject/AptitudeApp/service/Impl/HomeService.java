package com.javaProject.AptitudeApp.service.Impl;

import com.javaProject.AptitudeApp.dao.ICategoryRepo;
import com.javaProject.AptitudeApp.dao.ITopicRepo;
import com.javaProject.AptitudeApp.dto.CategoryDto;
import com.javaProject.AptitudeApp.dto.TopicDto;
import com.javaProject.AptitudeApp.exception.CategoryNotFoundException;
import com.javaProject.AptitudeApp.model.Category;
import com.javaProject.AptitudeApp.model.Topic;
import com.javaProject.AptitudeApp.service.IHomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeService implements IHomeService {

    private ICategoryRepo categoryRepo;
    private ITopicRepo topicRepo;

    @Autowired
    public void setCategoryRepo(ICategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    @Autowired
    public void setTopicRepo(ITopicRepo topicRepo) {
        this.topicRepo = topicRepo;
    }

    @Override
    public List<CategoryDto> getAllCategories() {
        List<Category> allCategories = categoryRepo.findAll();
        return allCategories.stream().map(category -> new CategoryDto(category.getcId(), category.getcName())).toList();
    }

    @Override
    public List<TopicDto> getTopicsByCategory(Long categoryId) {
        Category category = categoryRepo.findById(categoryId).orElseThrow(
                () -> new CategoryNotFoundException("Category not found with id: " + categoryId));
        List<Topic> allTopics = topicRepo.findByCategory(category);
        return allTopics.stream().map(topic -> new TopicDto(topic.getTopicId(), topic.getTopicName(), topic.getSlug())).toList();
    }


}
