package com.javaProject.AptitudeApp.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cId;
	private String cName;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Topic> topics;

    public Category() {

    }

    public Category(String cName, List<Topic> topics) {
        this.cName = cName;
        this.topics = topics;
    }

    public Long getcId() {
        return cId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public List<Topic> getTopics() {
        return topics;
    }

    public void setTopics(List<Topic> topics) {
        this.topics = topics;
    }
}
