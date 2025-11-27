package com.javaProject.AptitudeApp.model;

import java.util.Arrays;
import java.util.List;

import jakarta.persistence.*;

@Entity
public class Question {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String qId;

    @ManyToOne
    @JoinColumn(name = "topic_id")
	private Topic topic;

	private String question; 
	@Lob
	private byte[] imageArr; //need to add 1 image in question
	private String opA;
	private String opB;
	private String opC;
	private String opD;
	private String answer;

    public Question() {
    }

    public Question(Topic topic, String question, String opA, String opB, String opC,
            String opD, String answer) {
        this.topic = topic;
        this.question = question;
        this.opA = opA;
        this.opB = opB;
        this.opC = opC;
        this.opD = opD;
        this.answer = answer;
    }

    public Question(Topic topic, String question, byte[] imageArr, String opA, String opB, String opC,
                    String opD, String answer) {
        this.topic = topic;
        this.question = question;
        this.imageArr = imageArr;
        this.opA = opA;
        this.opB = opB;
        this.opC = opC;
        this.opD = opD;
        this.answer = answer;
    }



    public String getqId() {
        return qId;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public byte[] getImageArr() {
        return imageArr;
    }

    public void setImageArr(byte[] imageArr) {
        this.imageArr = imageArr;
    }

    public String getOpA() {
        return opA;
    }

    public void setOpA(String opA) {
        this.opA = opA;
    }

    public String getOpB() {
        return opB;
    }

    public void setOpB(String opB) {
        this.opB = opB;
    }

    public String getOpC() {
        return opC;
    }

    public void setOpC(String opC) {
        this.opC = opC;
    }

    public String getOpD() {
        return opD;
    }

    public void setOpD(String opD) {
        this.opD = opD;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
