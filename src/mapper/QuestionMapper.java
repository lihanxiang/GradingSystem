package mapper;

import entity.Question;
import java.util.List;

public interface QuestionMapper {

    int addQuestionToAssignment(Question question);
    Question getQuestionById(int qid);
    Double getQuestionWeight(int qid);
    List<Question> getQuestionsByAssignment(int aid);
}
