package com.practice.Quiz_service.Controller;


import com.practice.Quiz_service.Service.QuizService;

import com.practice.Quiz_service.entitiesModel.QuestionWrapper;
import com.practice.Quiz_service.entitiesModel.QuizDto;
import com.practice.Quiz_service.entitiesModel.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizzController {


    private QuizService quizService;
    public static final String classname = QuizzController.class.getName();


    @Autowired
    public QuizzController(QuizService quizService) {
        this.quizService = quizService;
    }


    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestBody QuizDto quizDto){

        return quizService.createQuiz(quizDto.getCategoryName(), quizDto.getNumberOfQuestons(), quizDto.getTitle());
    }

    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionWrapper>>getQuizQuestions(@PathVariable Integer id){

        return quizService.getQuizQuestions(id);
    }
    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id,@RequestBody List<Response>responses){
        System.out.println(classname);
        return quizService.calculateResult(id, responses);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteQuiz(@PathVariable Integer id){
        return quizService.deleteQuiz(id);
    }
}
