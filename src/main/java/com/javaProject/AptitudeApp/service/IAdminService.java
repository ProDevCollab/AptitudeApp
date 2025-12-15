package com.javaProject.AptitudeApp.service;


import com.javaProject.AptitudeApp.dto.CategoryDto;
import com.javaProject.AptitudeApp.dto.TopicDto;

import java.util.List;

public interface IAdminService {
    String addTopic(String topicName, Long categoryId, String slug);
    String addLearningResource(String resourceUrl, Long topicId);
    String addQuestion(String question, String imageData, String opA, String opB, String opC, String opD, String answer, Long topicId);

    List<CategoryDto> getAllCategories();
    List<TopicDto> getAllTopics();

}
