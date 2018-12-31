package service.impl;

import entity.Answer;
import mapper.AnswerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.AnswerService;

import java.util.List;

@Service
public class AnswerServiceImpl implements AnswerService {

    private final AnswerMapper answerMapper;

    @Autowired
    public AnswerServiceImpl(AnswerMapper answerMapper) {
        this.answerMapper = answerMapper;
    }

    @Override
    public int writeAnswer(Answer answer) {
        return answerMapper.writeAnswer(answer);
    }

    @Override
    public int updateAnswer(Answer answer) {
        return answerMapper.updateAnswer(answer);
    }

    @Override
    public Answer getById(int anid) {
        return answerMapper.getById(anid);
    }

    @Override
    public Answer checkAnswerDetail(int qid, int uid) {
        return answerMapper.checkAnswerDetail(qid, uid);
    }

    @Override
    public Answer getAnswerByTitleAndUsername(int aid, String title, String username) {
        return answerMapper.getAnswerByTitleAndUsername(aid, title, username);
    }

    @Override
    public List<Answer> getAnswerByTitle(int aid, String title, String code) {
        return answerMapper.getAnswerByTitle(aid, title, code);
    }

    @Override
    public List<Answer> getAnswerByUsername(int aid, String username, String code) {
        return answerMapper.getAnswerByUsername(aid, username, code);
    }

    @Override
    public void markAnswer(Answer answer) {
        answerMapper.markAnswer(answer);
    }
}
