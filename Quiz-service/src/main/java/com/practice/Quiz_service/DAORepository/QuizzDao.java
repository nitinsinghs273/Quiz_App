package com.practice.Quiz_service.DAORepository;

import com.practice.Quiz_service.entitiesModel.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizzDao extends JpaRepository<Quiz, Integer> {
}
