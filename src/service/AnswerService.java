package service;

import entity.Answer;

import java.util.List;

public interface AnswerService {

    //Student
    int writeAnswer(Answer answer);
    int updateAnswer(Answer answer);

    //Teacher
    Answer getAnswerByTitleAndUsername(int aid, String title, String username);
    List<Answer> getAnswerByTitle(int aid, String title, String code);
    List<Answer> getAnswerByUsername(int aid, String username, String code);
    Answer getById(int anid);
    void markAnswer(Answer answer);

    //Both
    Answer checkAnswerDetail(int qid, int uid);
}
