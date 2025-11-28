package com.javaProject.AptitudeApp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaProject.AptitudeApp.model.Category;

public interface ICategoryRepo extends JpaRepository<Category, Long> {

}
