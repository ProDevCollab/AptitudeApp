package com.javaProject.AptitudeApp.controller;

import com.javaProject.AptitudeApp.dao.ICategoryRepo;
import com.javaProject.AptitudeApp.dto.CategoryDto;
import com.javaProject.AptitudeApp.dto.TopicDto;
import com.javaProject.AptitudeApp.model.Category;
import com.javaProject.AptitudeApp.service.IHomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/")
public class HomeController {

    private IHomeService homeService;

    @Autowired
    public void setHomeService(IHomeService homeService) {
        this.homeService = homeService;

    }

    @GetMapping("/categories")
    public ResponseEntity<List<CategoryDto>> getCategories() {
        List<CategoryDto> categoryDto = homeService.getAllCategories();
        return new ResponseEntity<>(categoryDto, HttpStatus.OK);
    }

    @GetMapping("/topics/{categoryId}")
    public ResponseEntity<List<TopicDto>> getTopicsByCategory(@PathVariable Long categoryId) {
        List<TopicDto> topicDto = homeService.getTopicsByCategory(categoryId);
        return new ResponseEntity<>(topicDto, HttpStatus.OK);
    }
}
