package com.javaProject.AptitudeApp.service.Impl;

import com.javaProject.AptitudeApp.dao.IQuestionRepo;
import com.javaProject.AptitudeApp.model.Question;
import com.javaProject.AptitudeApp.dto.QuestionDto;
import com.javaProject.AptitudeApp.service.ISetupQuiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class SetupQuiz implements ISetupQuiz {

    @Autowired
    private IQuestionRepo questionRepo;

    @Override
    public List<QuestionDto> getQuestionForTopicId(Long topicID) {
//            List<Question> questionList = questionRepo.findAllByTopicId();
//            return chooseRandom(questionList).stream().map(q ->
//                    new QuestionDto(q.getQuestion(), q.getImageUrl(),
//                            q.getOpA(),q.getOpB(), q.getOpC(), q.getOpD(), q.getAnswer())).toList();
        return null;
    }

    private List<Question> chooseRandom(List<Question> questions) {

        List<Long> randomIndexList = generateRandomIndex(questions.size());
        List<Question> selectedQuestions = questions.stream().filter(
                q->randomIndexList.contains(q.getqId())).toList();
        return selectedQuestions;
    }

    private static List<Long> generateRandomIndex(Integer size) {
        Random random = new Random();
        List<Long> randomIndexes = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            Long nextIndex = random.nextLong(size);
            if(randomIndexes.stream().noneMatch(r->r!=nextIndex)){
                randomIndexes.add(nextIndex);
            } else {
                i--;
            }
        }
        return randomIndexes;
    }


}
