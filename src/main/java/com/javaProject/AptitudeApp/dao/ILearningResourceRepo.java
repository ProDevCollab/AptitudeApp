package com.javaProject.AptitudeApp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaProject.AptitudeApp.model.LearningResource;

public interface ILearningResourceRepo extends JpaRepository<LearningResource, Long> {

}
