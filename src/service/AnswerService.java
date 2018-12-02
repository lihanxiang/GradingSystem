package service;

import entity.Answer;

import java.util.List;

public interface AnswerService {

    int addAnswer(Answer answer);

    List<Answer> getAnswerForQuestion(int qid);
}
