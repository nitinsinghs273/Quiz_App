package com.practice.question_service.entitiesModel;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "questions")
@Data
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public Question() {
    }

    @Column(name = "difficulty")
    private String difficulty;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestionsTitle() {
        return questionsTitle;
    }

    public void setQuestionsTitle(String questionsTitle) {
        this.questionsTitle = questionsTitle;
    }

    public String getOptionA() {
        return optionA;
    }

    public void setOptionA(String optionA) {
        this.optionA = optionA;
    }

    public String getOptionB() {
        return optionB;
    }

    public void setOptionB(String optionB) {
        this.optionB = optionB;
    }

    public String getOptionC() {
        return optionC;
    }

    public void setOptionC(String optionC) {
        this.optionC = optionC;
    }

    public String getOptionD() {
        return optionD;
    }

    public void setOptionD(String optionD) {
        this.optionD = optionD;
    }

    public String getRightAnswer() {
        return rightAnswer;
    }

    public void setRightAnswer(String rightAnswer) {
        this.rightAnswer = rightAnswer;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }
// Constructors, Getters, Setters omitted for brevity

    public Question(int id, String difficulty, String category, String rightAnswer, String optionD, String optionC, String optionB, String optionA, String questionsTitle) {
        this.id = id;
        this.difficulty = difficulty;
        this.category = category;
        this.rightAnswer = rightAnswer;
        this.optionD = optionD;
        this.optionC = optionC;
        this.optionB = optionB;
        this.optionA = optionA;
        this.questionsTitle = questionsTitle;
    }
}
