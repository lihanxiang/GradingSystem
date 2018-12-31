package service;

import entity.Summary;
import entity.result.AssignmentScoreSet;
import entity.result.CourseScoreSet;
import entity.result.QuestionScoreSet;
import exception.NotYetException;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SummaryService {

    int writeSummary(Summary summary);
    Summary getSummaryOfStudent(int aid, int uid);

    /**
     * 接下来这几个计算的方法都是从数据库中查询分数，然后计算
     * 平均，最后以另外的形式（比如 QuestionScoreSet），这样的
     * 形式输出到页面
     */
    Double getScoreOfAnswer(int qid, int uid);
    List<QuestionScoreSet> getScoreOfAnswers(int aid, int uid);


    Double getScoreOfAssignment(int aid, int uid);
    List<AssignmentScoreSet> getScoreOfAssignments(String code, int uid);

    String getGradeOfCourse(String code, int uid);
    List<CourseScoreSet> getGradeOfCourses(int uid);

    String calculateGPA(List<CourseScoreSet> sets);
}
