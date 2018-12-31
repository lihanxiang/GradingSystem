package controller;

import entity.*;
import entity.result.AssignmentScoreSet;
import entity.result.CourseScoreSet;
import entity.result.QuestionScoreSet;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import service.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "student")
public class StudentController {

    private final UserService userService;
    private final QuestionService questionService;
    private final AssignmentService assignmentService;
    private final CourseService courseService;
    private final AnswerService answerService;
    private final SummaryService summaryService;

    @Autowired
    public StudentController(QuestionService questionService, AssignmentService assignmentService,
                             CourseService courseService, AnswerService answerService, SummaryService summaryService, UserService userService) {
        this.questionService = questionService;
        this.assignmentService = assignmentService;
        this.courseService = courseService;
        this.answerService = answerService;
        this.summaryService = summaryService;
        this.userService = userService;
    }

    @RequestMapping(value = "{uid}/courses", method = RequestMethod.GET)
    public ModelAndView getCoursesByStudent(@PathVariable("uid") int uid){
        return new ModelAndView("student/courses")
                .addObject("courses", courseService.getCoursesByStudent(uid));
    }

    @RequestMapping(value = "{code}/assignments", method = RequestMethod.GET)
    public ModelAndView getAssignmentByCourseName(@PathVariable("code") String code){
        return new ModelAndView("student/assignments")
                .addObject("code", code)
                .addObject("assignments", assignmentService.getAssignmentByCourseCode(code));
    }

    @RequestMapping(value = "{aid}/questions", method = RequestMethod.GET)
    public ModelAndView getQuestionByAssignment(@PathVariable("aid") int aid){
        return new ModelAndView("student/questions")
                .addObject("aid", aid)
                .addObject("questions", questionService.getQuestionsByAssignment(aid));
    }

    /**
     * answer 有三种形式，已填写且已被批改、已填写
     * 但未被批改和未填写，根据三种情况来显示不同
     * 的内容
     */
    @RequestMapping(value = "{qid}/answer-sheet", method = RequestMethod.GET)
    public ModelAndView answerSheet(@PathVariable("qid") int qid){
        ModelAndView modelAndView = new ModelAndView("student/answerSheet");
        int uid = (int)SecurityUtils.getSubject().getSession().getAttribute("id");
        Answer answer = answerService.checkAnswerDetail(qid, uid);
        if (answer != null){
            if (answer.getTag() == 1){
                return new ModelAndView("student/fixedAnswerSheet")
                        .addObject("title", questionService.getQuestionById(qid).getTitle())
                        .addObject("qid", qid)
                        .addObject("answer",answer)
                        .addObject("score", summaryService.getScoreOfAnswer(qid, uid));
            }
            return modelAndView
                    .addObject("title", questionService.getQuestionById(qid).getTitle())
                    .addObject("qid", qid)
                    .addObject("answer",answer);
        }
        return modelAndView
                .addObject("title", questionService.getQuestionById(qid).getTitle())
                .addObject("qid", qid);
    }

    /**
     * 如果还未填写答案，就添加，如果已经写了答案，
     * 就可以在未被批改的情况下修改答案
     */
    @RequestMapping(value = "{qid}/post-answer", method = RequestMethod.POST)
    public ModelAndView postAnswer(Answer answer, @PathVariable("qid") int qid){
        int uid = (int)SecurityUtils.getSubject().getSession().getAttribute("id");
        if (answerService.checkAnswerDetail(qid, uid) != null){
            answer.setQid(qid);
            answer.setUid(uid);
            answerService.updateAnswer(answer);
        }
        else {
            answer.setQid(qid);
            answer.setUid(uid);
            answerService.writeAnswer(answer);
        }
        return new ModelAndView("redirect:/student/" + uid + "/courses");
    }

    /**
     *  接下来都是成绩相关的方法
     */

    //得到每一门课的等级，如果
    @RequestMapping(value = "{uid}/courses-grade-point", method = RequestMethod.GET)
    public ModelAndView coursesGradePoint(@PathVariable("uid") int uid){
        List<CourseScoreSet> sets = summaryService.getGradeOfCourses(uid);
        return new ModelAndView("student/score/courses")
                .addObject("sets", sets)
                .addObject("gpa", summaryService.calculateGPA(sets));
    }

    @RequestMapping(value = "{code}/course-grade-point", method = RequestMethod.GET)
    public ModelAndView courseGradePoint(@PathVariable("code") String code){
        int uid = (int)SecurityUtils.getSubject().getSession().getAttribute("id");
        return new ModelAndView("student/score/course")
                .addObject("grade", summaryService.getGradeOfCourse(code, uid))
                .addObject("sets", summaryService.getScoreOfAssignments(code, uid));
    }

    @RequestMapping(value = "{aid}/assignment-score")
    public ModelAndView assignmentScore(@PathVariable("aid") int aid){
        int uid = (int)SecurityUtils.getSubject().getSession().getAttribute("id");
        return new ModelAndView("student/score/assignment")
                .addObject("score", summaryService.getScoreOfAssignment(aid, uid))
                .addObject("sets", summaryService.getScoreOfAnswers(aid, uid));
    }

    @RequestMapping(value = "{aid}/summary")
    public ModelAndView getSummary(@PathVariable("aid") int aid){
        int uid = (int)SecurityUtils.getSubject().getSession().getAttribute("id");
        return new ModelAndView("student/score/summary")
                .addObject("summary", summaryService.getSummaryOfStudent(aid, uid));
    }

    @RequestMapping(value = "info", method = RequestMethod.GET)
    public ModelAndView userInfo(){
        int uid = (int)SecurityUtils.getSubject().getSession().getAttribute("id");
        return new ModelAndView("student/info")
                .addObject("user", userService.getById(uid));
    }

    @RequestMapping(value = "update-info", method = RequestMethod.POST)
    public String updateInfo(User user){
        user.setUid((int)SecurityUtils.getSubject().getSession().getAttribute("id"));
        userService.updateUserInfo(user);
        return "redirect:/student/main";
    }

    @RequestMapping(value = "main")
    public ModelAndView main(){
        return new ModelAndView("student/main")
                .addObject("username",
                        SecurityUtils.getSubject().getSession().getAttribute("username"));
    }
}
