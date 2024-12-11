package com.practice.question_service.Controller;

import com.practice.question_service.Service.QuestionService;
import com.practice.question_service.entitiesModel.Question;

import com.practice.question_service.entitiesModel.QuestionWrapper;
import com.practice.question_service.entitiesModel.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/questions")
public class QuestionController {
    @Autowired
    QuestionService questionService;

    @GetMapping
    public ResponseEntity<List<Question>> getAllQuestions() {
        return questionService.getAllQuestions();
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<Question>> getQuestionByCategories(@PathVariable String category){
        return questionService.getQuestionByCategory(category);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addQuestion(@RequestBody Question question) {
         return questionService.addQuestion(question);
    }

    @GetMapping("/generate")
    public ResponseEntity<List<Integer>> getQuestionForQuiz(@RequestParam("category") String categoryName, @RequestParam("limit") Integer noOfQuestions ){
        return questionService.getQuestionForQuiz(categoryName, noOfQuestions);
    }
    @PostMapping("/getQuestion")
    public ResponseEntity<List<QuestionWrapper>> getQuestionFromId(@RequestBody List<Integer>questionIds){
        return questionService.getQuestionsFromIds(questionIds);
    }

    @PostMapping("/getScore")
    public ResponseEntity<Integer> getScore(@RequestBody List<Response>responses){
        return questionService.calculateScore(responses);
    }

    @GetMapping("/{id}")
    public Question getQuestionById(@PathVariable int id) {
        return questionService.getQuestionById(id);
    }
}