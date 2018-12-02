package mapper;

import entity.Assignment;
import entity.Question;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface QuestionMapper {

    int addQuestionToAssignment(Question question, @Param("aid") int aid);

    Question getQuestionById(int qid);
    List<Question> getQusetionsByAssignment(int aid);
}
