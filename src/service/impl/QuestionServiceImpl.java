package service.impl;

import entity.Question;
import mapper.QuestionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.QuestionService;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    private final QuestionMapper questionMapper;

    @Autowired
    public QuestionServiceImpl(QuestionMapper questionMapper) {
        this.questionMapper = questionMapper;
    }

    @Override
    public int addQuestionToAssignment(Question question) {
        return questionMapper.addQuestionToAssignment(question);
    }

    @Override
    public Question getQuestionById(int qid) {
        return questionMapper.getQuestionById(qid);
    }

    @Override
    public Double getQuestionWeight(int qid) {
        return questionMapper.getQuestionWeight(qid);
    }

    @Override
    public List<Question> getQuestionsByAssignment(int aid) {
        return questionMapper.getQuestionsByAssignment(aid);
    }
}
