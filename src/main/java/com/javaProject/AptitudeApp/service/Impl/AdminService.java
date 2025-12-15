package com.javaProject.AptitudeApp.service.Impl;

import com.javaProject.AptitudeApp.dao.*;
import com.javaProject.AptitudeApp.dto.CategoryDto;
import com.javaProject.AptitudeApp.dto.TopicDto;
import com.javaProject.AptitudeApp.model.*;
import com.javaProject.AptitudeApp.service.IAdminService;
import com.javaProject.AptitudeApp.service.ISupabaseStorageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.Base64;
import java.util.List;

@Service
public class AdminService implements IAdminService {

    private ICategoryRepo categoryRepo;
    private ILearningResourceRepo learningResourceRepo;
    private ITopicRepo  topicRepo;
    private IQuestionRepo questionRepo;
    private ISupabaseStorageService supaStorageService;

    @Autowired
    public void setCategoryRepo(ICategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    @Autowired
    public void setLearningResourceRepo(ILearningResourceRepo learningResourceRepo) {
        this.learningResourceRepo = learningResourceRepo;
    }

    @Autowired
    public void setTopicRepo(ITopicRepo topicRepo) {
        this.topicRepo = topicRepo;
    }

    @Autowired
    public void setQuestionRepo(IQuestionRepo questionRepo) {
        this.questionRepo = questionRepo;
    }
    
    @Autowired
    public void setSupaStorageService(ISupabaseStorageService supaStorageService) {
    	this.supaStorageService = supaStorageService;
    }
    
    @Override
    public String addTopic(String topicName, Long categoryId, String slug) {
        categoryRepo.findById(categoryId)
                .ifPresentOrElse(category -> topicRepo.save(new Topic(topicName, category, slug)),
                        () -> { throw new RuntimeException("Category not found with id: " + categoryId);});
        return "Topic added successfully";
    }

    @Override
    public String addLearningResource(String resourceUrl, Long topicId) {
        topicRepo.findById(topicId)
                .ifPresentOrElse(topic -> learningResourceRepo.save(new LearningResource(topic, resourceUrl)),
                        () -> { throw new RuntimeException("Topic not found with id: " + topicId);});
        return "Learning Resource added successfully";
    }

    @Override
    public String addQuestion(String question, String imageData, String opA, String opB, String opC, String opD, String answer, Long topicId) {
        topicRepo.findById(topicId)
        		.ifPresentOrElse(topic -> {saveQuestioninDb(question, imageData, opA, opB, opC, opD, answer,topic);}, 
        				()->{throw new RuntimeException("Topic not found with id : " + topicId);});

        return "Question added successfully";
    }
    //method to save question while performing some checks
    public void saveQuestioninDb(String question, String imageData, String opA, String opB, String opC, String opD, String answer, Topic topic) {
//    	if(imageSize > 750kb) {
//    		throw
//    	}

    	String imageUrl = null;
    	try {
            if (!imageData.isEmpty()) {
                byte[] imageBytes = Base64.getDecoder().decode(imageData);

                //filename = {QI}-{topicId}-{dateTime}
                String filename = "QI-" + topic.getTopicId() + "-" + LocalDateTime.now();


                //call API to save image in SupaBase

                imageUrl = supaStorageService.uploadImage(imageBytes, filename + ".png");
                System.out.println(imageUrl);
//            System.out.println("____________________________________________");
//            System.out.println("Decoded byte array length: " + imageBytes.length);
//            System.out.println("____________________________________________");
//            System.out.println("Decoded string: " + new String(imageBytes, StandardCharsets.UTF_8));
                Question ques = new Question(topic,  question,  imageUrl,  opA,  opB,  opC, opD,  answer);
                questionRepo.save(ques);
            } else {
                Question ques = new Question(topic,  question,  opA,  opB,  opC, opD,  answer);
                questionRepo.save(ques);
            }
            } catch(IllegalArgumentException e){
                System.err.println("Error decoding Base64 string: " + e.getMessage());
            }



    	
    }
    

    public List<CategoryDto> getAllCategories(){
        List<Category> categoryList = categoryRepo.findAll();
        return categoryList.stream().map(c -> new CategoryDto(c.getcId(), c.getcName())).toList();
    }

    public List<TopicDto> getAllTopics() {
        List<Topic> topicList = topicRepo.findAll();
        return topicList.stream().map(topic -> new TopicDto(topic.getTopicId(), topic.getTopicName(), topic.getSlug())).toList();
    }
}
