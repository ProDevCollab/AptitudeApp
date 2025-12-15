package com.javaProject.AptitudeApp.controller;

import com.javaProject.AptitudeApp.dto.*;
import com.javaProject.AptitudeApp.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private IAdminService adminService;


    @Autowired
    public void setAdminService(IAdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/categories")
    public ResponseEntity<List<CategoryDto>> getCategories() {
       List<CategoryDto> categoryDtoList = adminService.getAllCategories();
       return new ResponseEntity<>(categoryDtoList, HttpStatus.OK);
    }

    @GetMapping("/topics")
    public ResponseEntity<List<TopicDto>> getTopic() {
        List<TopicDto> topicDtoList = adminService.getAllTopics();
        return new ResponseEntity<>(topicDtoList, HttpStatus.OK);
    }

    @PostMapping("/topic/add")
    public ResponseEntity<String> addTopic(@RequestBody TopicCreationDto topicCreationDto) {
        String responseText =  adminService.addTopic(topicCreationDto.getTopicName(), topicCreationDto.getCategoryId(), topicCreationDto.getSlug());
        return new ResponseEntity<>(responseText, HttpStatus.CREATED);
    }

    @PostMapping("/learning-resource/add")
    public ResponseEntity<String> addLearningResource(@RequestBody LearningResourceCreationDto learningResourceCreationDto) {
        String responseText = adminService.addLearningResource(learningResourceCreationDto.getResourceUrl(), learningResourceCreationDto.getTopicId());
        return new ResponseEntity<>(responseText, HttpStatus.CREATED);
    }

    @PostMapping("/question/add")
    public ResponseEntity<String> addQuestion(@RequestBody QuestionCreationDto questionCreationDto) {
        String responseText = adminService.addQuestion(
                questionCreationDto.getQuestion(),
                questionCreationDto.getImageData(),
                questionCreationDto.getOpA(),
                questionCreationDto.getOpB(),
                questionCreationDto.getOpC(),
                questionCreationDto.getOpD(),
                questionCreationDto.getAnswer(),
                questionCreationDto.getTopicId());
        return new ResponseEntity<>(responseText, HttpStatus.CREATED);
    }
}

