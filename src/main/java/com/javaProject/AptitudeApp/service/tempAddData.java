package com.javaProject.AptitudeApp.service;

import com.javaProject.AptitudeApp.dao.ICategoryRepo;
import com.javaProject.AptitudeApp.model.Category;
import com.javaProject.AptitudeApp.model.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class tempAddData {

    @Autowired
    private ICategoryRepo categoryRepo;

    public void addData(){
        List<Category> categories = Arrays.asList(
                new Category("Quantitative Aptitude"),
                new Category("Logical Aptitude"));
        categoryRepo.saveAll(categories);
    }
}
