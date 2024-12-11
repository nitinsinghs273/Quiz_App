package com.practice.question_service.entitiesModel;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionWrapper {
    private int id;
    private String questionsTitle;
    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;




}
