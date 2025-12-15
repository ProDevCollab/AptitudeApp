package com.javaProject.AptitudeApp.dao;

import com.javaProject.AptitudeApp.model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import com.javaProject.AptitudeApp.model.Question;

import java.util.List;

public interface IQuestionRepo extends JpaRepository<Question, Long>{
    List<Question> findByTopic(Topic topic);
}
