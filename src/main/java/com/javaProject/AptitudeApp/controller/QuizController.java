package com.javaProject.AptitudeApp.controller;

import com.javaProject.AptitudeApp.dto.QuestionDto;
import com.javaProject.AptitudeApp.service.ISetupQuiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.PathMatcher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/topics/{slug}")
public class QuizController {

    private ISetupQuiz setupQuiz;

    @Autowired
    public void setSetupQuiz(ISetupQuiz setupQuiz) {
        this.setupQuiz = setupQuiz;
    }

    @GetMapping("/quiz")
    public ResponseEntity<List<QuestionDto>> getRandomQuestions(@PathVariable String slug) {
        List<QuestionDto> questionList = setupQuiz.getQuestionForSlug(slug);
        return new ResponseEntity<>(questionList, HttpStatus.OK);
    }
}
