package com.practice.Quiz_service.entitiesModel;


import jakarta.persistence.Column;
import lombok.Data;

@Data
public class QuestionWrapper {
    private int id;
    private String questionsTitle;
    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;

    public QuestionWrapper(int id, String questionsTitle, String optionA, String optionB, String optionC, String optionD) {
        this.id = id;
        this.questionsTitle = questionsTitle;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
    }



}
