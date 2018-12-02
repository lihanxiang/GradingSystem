package service.impl;

import entity.Answer;
import mapper.AnswerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.AnswerService;

import java.util.List;

@Service
public class AnswerServiceImpl implements AnswerService {

    @Autowired
    private AnswerMapper answerMapper;

    @Override
    public int addAnswer(Answer answer) {
        return answerMapper.addAnswer(answer);
    }

    @Override
    public List<Answer> getAnswerForQuestion(int qid) {
        return answerMapper.getAnswerForQuestion(qid);
    }
}
