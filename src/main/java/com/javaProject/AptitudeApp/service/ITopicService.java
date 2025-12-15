package com.javaProject.AptitudeApp.service;

import com.javaProject.AptitudeApp.dto.LearningResourceDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ITopicService {

    List<LearningResourceDto> getLearningResourcesByTopic(String slug);
}
