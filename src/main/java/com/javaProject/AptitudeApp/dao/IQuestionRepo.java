package com.javaProject.AptitudeApp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.javaProject.AptitudeApp.model.Question;

import java.util.List;

public interface IQuestionRepo extends JpaRepository<Question, Long>{
    //List<Question> findAllByTopicId();
}
