package service.impl;

import entity.Assignment;
import entity.Course;
import entity.Question;
import entity.Summary;
import entity.result.AssignmentScoreSet;
import entity.result.CourseScoreSet;
import entity.result.QuestionScoreSet;
import exception.NotYetException;
import mapper.AssignmentMapper;
import mapper.CourseMapper;
import mapper.QuestionMapper;
import mapper.SummaryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.SummaryService;
import util.GPACalculator;
import java.util.ArrayList;
import java.util.List;

@Service
public class SummaryServiceImpl implements SummaryService {

    private final QuestionMapper questionMapper;
    private final CourseMapper courseMapper;
    private final SummaryMapper summaryMapper;
    private final AssignmentMapper assignmentMapper;
    private final GPACalculator calculator;

    @Autowired
    public SummaryServiceImpl(SummaryMapper summaryMapper, AssignmentMapper assignmentMapper,
                              CourseMapper courseMapper, QuestionMapper questionMapper, GPACalculator calculator) {
        this.summaryMapper = summaryMapper;
        this.assignmentMapper = assignmentMapper;
        this.courseMapper = courseMapper;
        this.questionMapper = questionMapper;
        this.calculator = calculator;
    }

    @Override
    public int writeSummary(Summary summary) {
        return summaryMapper.writeSummary(summary);
    }

    @Override
    public Summary getSummaryOfStudent(int aid, int uid) {
        return summaryMapper.getSummaryOfStudent(aid, uid);
    }

    @Override
    public Double getScoreOfAnswer(int qid, int uid){
        Double score = summaryMapper.getScoreOfAnswer(qid, uid);
        if (score == null){
            return null;
        }
        return score;
    }

    @Override
    public List<QuestionScoreSet> getScoreOfAnswers(int aid, int uid){
        List<Question> questions = questionMapper.getQuestionsByAssignment(aid);
        List<QuestionScoreSet> sets = new ArrayList<>();
        for (Question q :
                questions) {
            sets.add(new QuestionScoreSet(q.getQid(), q.getTitle(), q.getWeight(), getScoreOfAnswer(q.getQid(), uid)));
        }
        return sets;
    }

    @Override
    public Double getScoreOfAssignment(int aid, int uid){
        Double score = summaryMapper.getScoreOfAssignment(aid, uid);
        if (score == null){
            return null;
        }
        return score;
    }

    @Override
    public List<AssignmentScoreSet> getScoreOfAssignments(String code, int uid){
        List<Assignment> assignments = assignmentMapper.getAssignmentByCourseCode(code);
        List<AssignmentScoreSet> sets = new ArrayList<>();
        for (Assignment a :
                assignments) {
            sets.add(new AssignmentScoreSet(a.getAid(), a.getCode(), a.getName(),
                    getScoreOfAssignment(a.getAid(), uid)));
        }
        return sets;
    }

    @Override
    public String getGradeOfCourse(String code, int uid) {
        Double total = summaryMapper.getTotalScoreOfCourse(code, uid);
        if (total == null){
            return null;
        }
        List<Assignment> assignments = assignmentMapper.getAssignmentByCourseCode(code);
        return calculator.convertScoreToGrade(total / assignments.size());
    }

    @Override
    public List<CourseScoreSet> getGradeOfCourses(int uid) {
        List<Course> courses = courseMapper.getCoursesByStudent(uid);
        List<CourseScoreSet> sets = new ArrayList<>();
        for (Course c :
                courses) {
            sets.add(new CourseScoreSet(c.getCode(), c.getName(), c.getCredit(), getGradeOfCourse(c.getCode(), uid)));
        }
        return sets;
    }

    @Override
    public String calculateGPA(List<CourseScoreSet> sets) {
        return calculator.calculateGPA(sets);
    }
}
