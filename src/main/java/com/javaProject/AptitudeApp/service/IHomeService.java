package com.javaProject.AptitudeApp.service;


import com.javaProject.AptitudeApp.dto.CategoryDto;
import com.javaProject.AptitudeApp.dto.TopicDto;

import java.util.List;

public interface IHomeService {
    List<CategoryDto> getAllCategories();
    List<TopicDto> getTopicsByCategory(Long categoryId);
}
