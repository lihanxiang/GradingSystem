package mapper;

import entity.Answer;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface AnswerMapper {

    int writeAnswer(Answer answer);
    int updateAnswer(Answer answer);
    Answer checkAnswerDetail(@Param("qid") int qid, @Param("uid") int uid);
    Answer getAnswerByTitleAndUsername(@Param("aid") int aid, @Param("title") String title, @Param("username") String username);
    List<Answer> getAnswerByTitle(@Param("aid") int aid, @Param("title") String title, @Param("code") String code);
    List<Answer> getAnswerByUsername(@Param("aid") int aid, @Param("username") String username, @Param("code") String code);
    Answer getById(int anid);
    void markAnswer(Answer answer);
}
