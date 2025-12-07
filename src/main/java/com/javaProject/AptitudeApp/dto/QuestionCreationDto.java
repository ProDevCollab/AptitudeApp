package com.javaProject.AptitudeApp.dto;

public class QuestionCreationDto {
    private String question;
    private String imageData; 
    private String opA;
    private String opB;
    private String opC;
    private String opD;
    private String answer;
    private final Long topicId;

    //from frontend image is encoded to String and in backend image is coverted from String to Byte Array and then decoded back to it's original format and is stored file storage
    public QuestionCreationDto(String question, String imageData, String opA, String opB, String opC, String opD, String answer, Long topicId) {
        this.question = question;
        this.imageData = imageData;
        this.opA = opA;
        this.opB = opB;
        this.opC = opC;
        this.opD = opD;
        this.answer = answer;
        this.topicId = topicId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getImageData() {
        return imageData;
    }

    public void setImageData(String imageData) {
        this.imageData = imageData;
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

    public Long getTopicId(){
        return topicId;
    }
}
