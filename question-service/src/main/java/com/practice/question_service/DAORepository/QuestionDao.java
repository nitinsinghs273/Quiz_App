package com.practice.question_service.DAORepository;

import com.practice.question_service.entitiesModel.Question;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer> {

    public List<Question> getQuestionByCategory(String category);

    @Query(value = "SELECT q.id FROM questions q WHERE q.category=:category ORDER BY RAND() LIMIT :numQ", nativeQuery = true)
    List<Integer> getRandomQuestionByCategory(@Param("category") String categoryName, @Param("numQ") Integer noOfQuestions);

}
