package com.practice.Quiz_service.entitiesModel;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table
@Data
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column
    private String title;

    @ElementCollection
    private List<Integer> questions; // because a Quizz can have many Question table.
}
