package com.practice.Quiz_service.entitiesModel;

import lombok.Data;

@Data
public class QuizDto {
    private String categoryName;
    private Integer numberOfQuestons;
    private String title;
}
