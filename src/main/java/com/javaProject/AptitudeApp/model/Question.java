package com.javaProject.AptitudeApp.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;

@Entity
public class Question {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String qId;
	private String qTopicId;
	private String question; 
	@Lob
	private byte[] imageArr; //need to add 1 image in question
	private String opA;
	private String opB;
	private String opC;
	private String opD;
	private String answer;
	

}
