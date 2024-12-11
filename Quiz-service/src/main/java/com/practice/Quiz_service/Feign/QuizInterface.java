package com.practice.Quiz_service.Feign;

import com.practice.Quiz_service.entitiesModel.QuestionWrapper;
import com.practice.Quiz_service.entitiesModel.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("QUESTION-SERVICE")
public interface QuizInterface {
    @GetMapping("/api/questions/generate")
    public ResponseEntity<List<Integer>> getQuestionForQuiz(@RequestParam("category") String categoryName, @RequestParam("limit") Integer noOfQuestions );

    @PostMapping("/api/questions/getQuestion")
    public ResponseEntity<List<QuestionWrapper>> getQuestionFromId(@RequestBody List<Integer>questionIds);


    @PostMapping("/api/questions/getScore")
    public ResponseEntity<Integer> getScore(@RequestBody List<Response>responses);


}
