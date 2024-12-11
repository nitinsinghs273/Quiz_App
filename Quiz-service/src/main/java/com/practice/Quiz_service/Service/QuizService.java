package com.practice.Quiz_service.Service;

import com.practice.Quiz_service.DAORepository.QuizzDao;
import com.practice.Quiz_service.Feign.QuizInterface;
import com.practice.Quiz_service.entitiesModel.Question;
import com.practice.Quiz_service.entitiesModel.QuestionWrapper;
import com.practice.Quiz_service.entitiesModel.Quiz;
import com.practice.Quiz_service.entitiesModel.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {



    private final QuizzDao quizzDao;
    private final QuizInterface quizInterface;


    @Autowired
    public QuizService(QuizzDao quizzDao, QuizInterface quizInterface) {
        this.quizzDao = quizzDao;
        this.quizInterface=quizInterface;
    }

    public ResponseEntity<String> createQuiz(String category, int numQ, String title){
        try {
            //since we are not creating quizz now from Question Dao so we need to interact with the Question-service.
            // for that we use Eureka server for service registry and service discovery for the calling using Rest Templates.
            Quiz quiz = new Quiz();
            quiz.setTitle(title);
            List<Integer>questions = quizInterface.getQuestionForQuiz(category,numQ).getBody();
            quiz.setQuestions(questions);
            quizzDao.save(quiz);
            return new ResponseEntity<>("Quiz created sucessfully", HttpStatus.CREATED);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>("Failed in creating the Quizz", HttpStatus.BAD_REQUEST);
        }

    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
        try{
            Optional<Quiz>quiz =quizzDao.findById(id);
            if(quiz.isPresent()){
                List<Integer>questionIds = quiz.get().getQuestions();
                ResponseEntity<List<QuestionWrapper>> questions = quizInterface.getQuestionFromId(questionIds);
                return questions;
            }
            else{
                return new ResponseEntity<>( HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
        }
    }


    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
        try{
            int score = quizInterface.getScore(responses).getBody();
            return new ResponseEntity<>(score, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(-1, HttpStatus.BAD_REQUEST);
        }


    }

    public ResponseEntity<String> deleteQuiz(Integer id) {
        try{
            quizzDao.deleteById(id);
            return new ResponseEntity<>("Deletion sucess", HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>("Deletion of Quiz Failed", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
