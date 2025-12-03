package com.javaProject.AptitudeApp.service;


import com.javaProject.AptitudeApp.dto.CategoryDto;

import java.util.List;

public interface IAdminService {
    String addTopic(Long categoryId, String topicName);
    String addLearningResource(Long topicId, String resourceUrl);
    String addQuestion();

    List<CategoryDto> getAllCategories();

}
