package com.javaProject.AptitudeApp.service;

import com.javaProject.AptitudeApp.dto.QuestionDto;


import java.util.List;

public interface ISetupQuiz {
   List<QuestionDto> getQuestionForTopicId(Long topicID);
}
