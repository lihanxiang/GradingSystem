package service;

import entity.Question;

import java.util.List;

public interface QuestionService {

    int addQuestionToAssignment(Question question, int aid);

    Question getQuestionById(int qid);
    List<Question> getQusetionsByAssignment(int aid);
}
