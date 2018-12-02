package service.impl;

import entity.Question;
import mapper.QuestionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.QuestionService;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionMapper questionMapper;

    @Override
    public int addQuestionToAssignment(Question question, int aid) {
        return questionMapper.addQuestionToAssignment(question, aid);
    }

    @Override
    public Question getQuestionById(int qid) {
        return questionMapper.getQuestionById(qid);
    }

    @Override
    public List<Question> getQusetionsByAssignment(int aid) {
        return questionMapper.getQusetionsByAssignment(aid);
    }
}
