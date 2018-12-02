package mapper;

import entity.Answer;

import java.util.List;

public interface AnswerMapper {

    int addAnswer(Answer answer);

    List<Answer> getAnswerForQuestion(int qid);
}
