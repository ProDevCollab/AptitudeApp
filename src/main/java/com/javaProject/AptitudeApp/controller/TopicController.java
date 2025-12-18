package com.javaProject.AptitudeApp.controller;

import com.javaProject.AptitudeApp.dto.LearningResourceDto;
import com.javaProject.AptitudeApp.model.LearningResource;
import com.javaProject.AptitudeApp.service.ITopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/topics/{slug}")
public class TopicController {

    private ITopicService topicService;

    @Autowired
    public void setTopicService(ITopicService topicService) {
        this.topicService = topicService;
    }

    @GetMapping("/resources")
    public ResponseEntity<List<LearningResourceDto>> getLearningResources(@PathVariable String slug) {
        List<LearningResourceDto> learningResources = topicService.getLearningResourcesByTopic(slug);
        return new ResponseEntity<>(learningResources, HttpStatus.OK);
    }
}
