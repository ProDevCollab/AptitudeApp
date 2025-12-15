package com.javaProject.AptitudeApp.dao;

import com.javaProject.AptitudeApp.model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

import com.javaProject.AptitudeApp.model.LearningResource;

import java.util.List;

public interface ILearningResourceRepo extends JpaRepository<LearningResource, Long> {
    List<LearningResource> findByTopic(Topic topic);
}
