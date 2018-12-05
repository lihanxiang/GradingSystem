package mapper;

import entity.Answer;

import java.util.List;

public interface AnswerMapper {

    int writeAnswer(Answer answer);

    void changeAnswerStatus(int anid);

    List<Answer> getAnswerForQuestion(int qid);
    int getAnswerStatus(Answer answer);
}
