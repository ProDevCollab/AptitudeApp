package com.javaProject.AptitudeApp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.javaProject.AptitudeApp.model.Question;

public interface IQuestionRepo extends JpaRepository<Question, Long>{

}
