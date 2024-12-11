package com.practice.Quiz_service.entitiesModel;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "questions")
@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(name = "question_title")
    private String questionsTitle;

    @Column(name = "option_a")
    private String optionA;

    @Column(name = "option_b")
    private String optionB;

    @Column(name = "option_c")
    private String optionC;

    @Column(name = "option_d")
    private String optionD;

    @Column(name = "right_answer")
    private String rightAnswer;

    @Column(name = "category")
    private String category;

    @Column(name = "difficulty")
    private String difficulty;


}
