package com.javaProject.AptitudeApp.service.Impl;

import com.javaProject.AptitudeApp.dao.IQuestionRepo;
import com.javaProject.AptitudeApp.dao.ITopicRepo;
import com.javaProject.AptitudeApp.model.Question;
import com.javaProject.AptitudeApp.dto.QuestionDto;
import com.javaProject.AptitudeApp.model.Topic;
import com.javaProject.AptitudeApp.service.ISetupQuiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

@Service
public class SetupQuiz implements ISetupQuiz {

    private IQuestionRepo questionRepo;
    private ITopicRepo topicRepo;

    @Autowired
    public void setQuestionRepo(IQuestionRepo questionRepo) {
        this.questionRepo = questionRepo;
    }

    @Autowired
    public void setTopicRepo(ITopicRepo topicRepo) {
        this.topicRepo = topicRepo;
    }

    @Override
    public List<QuestionDto> getQuestionForSlug(String slug) {
            // get topic id from slug
           Topic topic = topicRepo.findBySlug(slug);
            List<Question> questionList = questionRepo.findByTopic(topic);
            return chooseRandom(questionList).stream().map(q ->
                    new QuestionDto(q.getQuestion(), q.getImageUrl(),
                            q.getOpA(),q.getOpB(), q.getOpC(), q.getOpD(), q.getAnswer())).toList();

    }

    private List<Question> chooseRandom(List<Question> questions) {

        List<Long> randomIndexList = generateRandomIndex(questions.size());
        List<Question> selectedQuestions = IntStream.range(0, questions.size()).filter(i -> randomIndexList.contains((long) i))
                .mapToObj(questions::get)
                .toList();
        return selectedQuestions;
    }

    private static List<Long> generateRandomIndex(Integer size) {
        Random random = new Random();
        List<Long> randomIndexes = new ArrayList<>();
        for(int i = 0; i < 5; i++) {
            Long nextIndex = random.nextLong(size);
            if(randomIndexes.stream().noneMatch(r->r==nextIndex)){
                randomIndexes.add(nextIndex);
            } else {
                i--;
            }
        }
        return randomIndexes;
    }


}
