package com.practice.question_service.Service;

import com.practice.question_service.DAORepository.QuestionDao;
import com.practice.question_service.entitiesModel.Question;

import com.practice.question_service.entitiesModel.QuestionWrapper;
import com.practice.question_service.entitiesModel.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {
    @Autowired
    private QuestionDao questionDao;


    //Get Request
    public ResponseEntity<List<Question>> getAllQuestions() {
        try {
            return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }
    //Get Request by category
    public ResponseEntity<List<Question>> getQuestionByCategory(String category){
        try {
            return new ResponseEntity<>(questionDao.getQuestionByCategory(category), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);

    }

    //Post Request
    public ResponseEntity<String> addQuestion(Question question) {
        try{
            questionDao.save(question);
            return new ResponseEntity<>("Sucess",HttpStatus.CREATED);
        }
        catch (Exception e){
            e.printStackTrace();
        }
      return new ResponseEntity<>("Failed", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public Question getQuestionById(int id) {
        return questionDao.findById(id).orElse(null);
    }

    public ResponseEntity<List<Integer>> getQuestionForQuiz(String categoryName, Integer noOfQuestions) {
        List<Integer>questions =  questionDao.getRandomQuestionByCategory(categoryName, noOfQuestions);
        return new ResponseEntity<>(questions, HttpStatus.OK);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuestionsFromIds(List<Integer> questionIds) {
        List<Question>questions = new ArrayList<>();
        for(Integer Id: questionIds){
            questions.add(questionDao.findById(Id).get());
        }
        List<QuestionWrapper> wrappers = new ArrayList<>();
        for(Question question: questions){
          QuestionWrapper wrapper = new QuestionWrapper();
          wrapper.setId(question.getId());
          wrapper.setQuestionsTitle(question.getQuestionsTitle());
          wrapper.setOptionA(question.getOptionA());
          wrapper.setOptionB(question.getOptionB());
          wrapper.setOptionC(question.getOptionC());
          wrapper.setOptionD(question.getOptionD());
          wrappers.add(wrapper);
        }
        return new ResponseEntity<>(wrappers, HttpStatus.OK);
    }

    public ResponseEntity<Integer> calculateScore(List<Response> responses) {

        int rightAnswerScore = 0;
        for(Response response: responses){
            Question question = questionDao.findById(response.getId()).get();
            if(question.getRightAnswer().equals(response.getResponse())){
                rightAnswerScore++;
            }
        }
        return new ResponseEntity<>(rightAnswerScore, HttpStatus.OK);


    }
}
