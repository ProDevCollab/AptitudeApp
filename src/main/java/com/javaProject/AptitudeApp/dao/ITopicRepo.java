package com.javaProject.AptitudeApp.dao;

import com.javaProject.AptitudeApp.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import com.javaProject.AptitudeApp.model.Topic;

import java.util.List;

public interface ITopicRepo extends JpaRepository<Topic, Long> {
    List<Topic> findByCategory(Category category);
    Topic findBySlug(String slug);
}
