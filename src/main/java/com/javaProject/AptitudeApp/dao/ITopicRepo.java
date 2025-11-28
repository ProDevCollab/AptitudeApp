package com.javaProject.AptitudeApp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.javaProject.AptitudeApp.model.Topic;

public interface ITopicRepo extends JpaRepository<Topic, Long> {

}
