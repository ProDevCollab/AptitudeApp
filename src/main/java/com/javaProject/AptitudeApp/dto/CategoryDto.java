package com.javaProject.AptitudeApp.dto;

public class CategoryDto {
    private Long cId;
    private String categoryName;

    public CategoryDto(){

    }

    public CategoryDto(Long cId, String categoryName) {
        this.cId = cId;
        this.categoryName = categoryName;
    }

    public Long getcId() {
        return cId;
    }

    public String getCategoryName() {
        return categoryName;
    }
}
