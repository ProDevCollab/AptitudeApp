package com.javaProject.AptitudeApp.controller;

import com.javaProject.AptitudeApp.dto.*;
import com.javaProject.AptitudeApp.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AdminController {

    private IAdminService adminService;

    @Autowired
    public void setAdminService(IAdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/admin/categories")
    public List<CategoryDto> getCategories() {
       return adminService.getAllCategories();
    }

    @GetMapping("/admin/topics")
    public List<TopicDto> getTopic() {
        return adminService.getAllTopics();
    }

    @PostMapping("/admin/topic/add")
    public String addTopic(@RequestBody TopicCreationDto topicCreationDto) {
        return adminService.addTopic(topicCreationDto.getTopicName(), topicCreationDto.getCategoryId());
    }

    @PostMapping("/admin/learning-resource/add")
    public String addLearningResource(@RequestBody LearningResourceCreationDto learningResourceCreationDto) {
        return adminService.addLearningResource(learningResourceCreationDto.getResourceUrl(), learningResourceCreationDto.getTopicId());
    }

    @PostMapping("/admin/question/add")
    public String addQuestion(@RequestBody QuestionCreationDto questionCreationDto) {
        return adminService.addQuestion(
                questionCreationDto.getQuestion(),
                questionCreationDto.getImageData(),
                questionCreationDto.getOpA(),
                questionCreationDto.getOpB(),
                questionCreationDto.getOpC(),
                questionCreationDto.getOpD(),
                questionCreationDto.getAnswer(),
                questionCreationDto.getTopicId());
    }
}

