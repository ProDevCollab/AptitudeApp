package com.javaProject.AptitudeApp.controller;

import com.javaProject.AptitudeApp.dto.CategoryDto;
import com.javaProject.AptitudeApp.dto.LearningResourceDto;
import com.javaProject.AptitudeApp.dto.TopicDto;
import com.javaProject.AptitudeApp.model.LearningResource;
import com.javaProject.AptitudeApp.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AdminController {

    @Autowired
    private IAdminService adminService;

    @GetMapping("/admin/categories")
    public List<CategoryDto> getCategories() {
       return adminService.getAllCategories();
    }

    @GetMapping("/admin/topics")
    public void getTopic() {

    }

    @PostMapping("/admin/topic/add")
    public String addTopic(@RequestBody TopicDto topicDto) {
        return adminService.addTopic(topicDto.getCategoryId(), topicDto.getTopicName());
    }

    @PostMapping("/admin/learning-resource/add")
    public String addLearningResource(@RequestBody LearningResourceDto learningResourceDto) {
        return adminService.addLearningResource(learningResourceDto.getTopicId(), learningResourceDto.getResourceUrl());
    }

    @PostMapping("/admin/question/add")
    public void addQuestion() {

    }
}

