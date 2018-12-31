package controller;

import entity.*;
import entity.result.AnswerSet;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import service.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "teacher")
public class TeacherController {

    private final QuestionService questionService;
    private final AssignmentService assignmentService;
    private final CourseService courseService;
    private final AnswerService answerService;
    private final UserService userService;
    private final SummaryService summaryService;

    @Autowired
    public TeacherController(QuestionService questionService, AssignmentService assignmentService,
                             CourseService courseService, AnswerService answerService, UserService userService,
                             SummaryService summaryService) {
        this.questionService = questionService;
        this.assignmentService = assignmentService;
        this.courseService = courseService;
        this.answerService = answerService;
        this.userService = userService;
        this.summaryService = summaryService;
    }


    @RequestMapping(value = "course-sheet", method = RequestMethod.GET)
    public ModelAndView courseSheet(){
        return new ModelAndView("teacher/course/addCourse");
    }

    @RequestMapping(value = "add-course", method = RequestMethod.POST)
    public ModelAndView addCourse(Course course){
        int uid = (int)SecurityUtils.getSubject().getSession().getAttribute("id");
        course.setUid(uid);
        courseService.addCourse(course);
        return new ModelAndView("redirect:/teacher/" +
                course.getCode() + "/students-not-in-course");
    }

    @RequestMapping(value = "{uid}/courses", method = RequestMethod.GET)
    public ModelAndView getCoursesByTeacher(@PathVariable("uid") int uid){
        List<Course> courses = courseService.getCoursesByTeacher(uid);
        return new ModelAndView("teacher/course/courses")
                .addObject("courses", courses)
                .addObject("size", courses.size());
    }

    @RequestMapping(value = "{code}/students-not-in-course", method = RequestMethod.GET)
    public ModelAndView getStudentNotInCourse(@PathVariable("code") String code){
        List<User> students = courseService.getStudentsNotInCourse(code);
        int uid = (int)SecurityUtils.getSubject().getSession().getAttribute("id");
        return new ModelAndView("teacher/course/studentsNotInCourse")
                .addObject("students", students)
                .addObject("size", students.size())
                .addObject("code", code);
    }

    @RequestMapping(value = "{code}/{uid}/add-student-to-course", method = RequestMethod.GET)
    public ModelAndView addStudentToCourse(@PathVariable("code") String code, @PathVariable("uid") int uid){
        courseService.addStudentToCourse(code, uid);
        return new ModelAndView("redirect:/teacher/" + code + "/students-not-in-course");
    }

    @RequestMapping(value = "{code}/students", method = RequestMethod.GET)
    public ModelAndView getStudentByCourseId(@PathVariable("code") String code){
        List<User> students = courseService.getStudentsForCourse(code);
        return new ModelAndView("teacher/course/studentsInCourse")
                .addObject("students", students)
                .addObject("size", students.size());
    }

    @RequestMapping(value = "{code}/assignments", method = RequestMethod.GET)
    public ModelAndView getAssignmentByCourseName(@PathVariable("code") String code){
        int uid = (int)SecurityUtils.getSubject().getSession().getAttribute("id");
        List<Assignment> assignments = assignmentService.getAssignmentByCourseCode(code);
        return new ModelAndView("teacher/assignment/assignments")
                .addObject("assignments", assignments)
                .addObject("size", assignments.size())
                .addObject("code", code);
    }

    @RequestMapping(value = "{code}/assignment-sheet", method = RequestMethod.GET)
    public ModelAndView preAddAssignment(@PathVariable("code") String code){
        return new ModelAndView("teacher/assignment/addAssignment")
                .addObject("code", code);
    }

    @RequestMapping(value = "{code}/add-assignment", method = RequestMethod.POST)
    public String addAssignment(Assignment assignment, @PathVariable("code") String code){
        assignmentService.addAssignmentToCourse(assignment);
        return "redirect:/teacher/" + code + "/assignments";
    }

    @RequestMapping(value = "{code}/{aid}/questions", method = RequestMethod.GET)
    public ModelAndView getQuestionByAssignment(@PathVariable("code") String code, @PathVariable("aid") int aid){
        List<Question> questions = questionService.getQuestionsByAssignment(aid);
        return new ModelAndView("teacher/question/questions")
                .addObject("questions", questions)
                .addObject("size", questions.size())
                .addObject("code", code);
    }

    @RequestMapping(value = "{code}/{aid}/question-sheet", method = RequestMethod.GET)
    public ModelAndView preAddQuestion(@PathVariable("code") String code, @PathVariable("aid") int aid){
        return new ModelAndView("teacher/question/addQuestion")
                .addObject("aid", aid)
                .addObject("code", code);
    }

    @RequestMapping(value = "{code}/{aid}/add-question", method = RequestMethod.POST)
    public String addQuestion(Question question, @PathVariable("code") String code,
                              @PathVariable("aid") int aid){
        questionService.addQuestionToAssignment(question);
        return "redirect:/teacher/" + code + "/" + aid + "/questions";
    }

    @RequestMapping(value = "{code}/{aid}/select-answers", method = RequestMethod.GET)
    public ModelAndView chooseAnswers(@PathVariable("code")String code, @PathVariable("aid")int aid){
        return new ModelAndView("teacher/answer/selectAnswers")
                .addObject("questions", questionService.getQuestionsByAssignment(aid))
                .addObject("students", assignmentService.getStudentNameByAssignment(aid))
                .addObject("aid", aid)
                .addObject("code", code);
    }

    @RequestMapping(value = "{code}/{aid}/get-answers-by-both", method = RequestMethod.GET)
    public ModelAndView getAnswerByTitleAndUsername(@PathVariable("code") String code,
                                                    @PathVariable("aid") int aid,
                                                    @RequestParam("title") String title,
                                                    @RequestParam("username") String username) {
        Answer answer = answerService.getAnswerByTitleAndUsername(aid, title, username);
        Double weight = answer == null ? null : questionService.getQuestionWeight(answer.getQid());
        return new ModelAndView("teacher/answer/answer")
                .addObject("answer", answer)
                .addObject("code", code)
                .addObject("aid", aid)
                .addObject("weight", weight);
    }

    @RequestMapping(value = "{code}/{aid}/get-answers-by-title", method = RequestMethod.GET)
    public ModelAndView getAnswerByTitle(@RequestParam("title") String title, @PathVariable("code")String code,
                                         @PathVariable("aid")int aid){
        List<Answer> answerList = answerService.getAnswerByTitle(aid, title, code);
        List<AnswerSet> answerSets = new ArrayList<>();
        for (Answer answer:
             answerList) {
            answerSets.add(new AnswerSet(answer.getAnid(),
                                        answer.getQid(),
                                        answer.getUid(),
                                        questionService.getQuestionById(answer.getQid()).getTitle(),
                                        userService.getById(answer.getUid()).getUsername(),
                                        answer.getAnswer()));
        }
        return new ModelAndView("teacher/answer/answersForTitle")
                .addObject("answers", answerSets)
                .addObject("size", answerSets.size())
                .addObject("aid", aid)
                .addObject("code", code);
    }

    @RequestMapping(value = "{code}/{aid}/get-answers-by-username", method = RequestMethod.GET)
    public ModelAndView getAnswerByUsername(@RequestParam("username") String username, @PathVariable("code")String code,
                                            @PathVariable("aid")int aid){
        List<Answer> answerList = answerService.getAnswerByUsername(aid, username, code);
        List<AnswerSet> answerSets = new ArrayList<>();
        for (Answer answer:
                answerList) {
            answerSets.add(new AnswerSet(answer.getAnid(),
                                        answer.getQid(),
                                        answer.getUid(),
                                        questionService.getQuestionById(answer.getQid()).getTitle(),
                                        userService.getById(answer.getUid()).getUsername(),
                                        answer.getAnswer()));
        }
        return new ModelAndView("teacher/answer/answersForUsername")
                .addObject("answers", answerSets)
                .addObject("size", answerSets.size())
                .addObject("aid", aid)
                .addObject("code", code);
    }

    @RequestMapping(value = "{code}/{aid}/{anid}/detail", method = RequestMethod.GET)
    public ModelAndView getAnswerDetailByUsername(@PathVariable("code") String code, @PathVariable("aid") int aid,
                                                  @PathVariable("anid") int anid){
        Answer answer = answerService.getById(anid);
        Double weight = answer == null ? null : questionService.getQuestionWeight(answer.getQid());
        return new ModelAndView("teacher/answer/answer")
                .addObject("answer", answer)
                .addObject("aid", aid)
                .addObject("weight", weight)
                .addObject("code", code);
    }

    @RequestMapping(value = "{code}/{aid}/{anid}/mark")
    public ModelAndView markAnswerByBoth(Answer answer, @PathVariable("code") String code,
                                         @PathVariable("aid") int aid, @PathVariable("anid") int anid){
        answer.setAnid(anid);
        answerService.markAnswer(answer);
        return new ModelAndView("redirect:/teacher/" + code + "/" + aid + "/select-answers");
    }

    @RequestMapping(value = "{code}/{aid}/select-student", method = RequestMethod.GET)
    public ModelAndView selectStudent(@PathVariable("code") String code, @PathVariable("aid") int aid){
        List<User> students = courseService.getStudentsForCourse(code);
        return new ModelAndView("teacher/summary/students")
                .addObject("students", students)
                .addObject("code", code)
                .addObject("aid", aid)
                .addObject("size", students.size());
    }

    @RequestMapping(value = "{code}/{aid}/{uid}/summary-sheet", method = RequestMethod.GET)
    public ModelAndView getSummarySheetByBoth(@PathVariable("code") String code, @PathVariable("aid") int aid,
                                              @PathVariable("uid") int uid){
        return new ModelAndView("teacher/summary/summarySheet")
                .addObject("code", code)
                .addObject("aid", aid)
                .addObject("uid", uid);
    }

    @RequestMapping(value = "{code}/{aid}/{uid}/write-summary", method = RequestMethod.POST)
    public String writeSummaryByTitle(Summary summary, @PathVariable("code") String code,
                                      @PathVariable("aid") int aid, @PathVariable("uid") int uid){
        summaryService.writeSummary(summary);
        return "redirect:/teacher/" + code + "/" + aid + "/select-student";

    }

    @RequestMapping(value = "info", method = RequestMethod.GET)
    public ModelAndView userInfo(){
        int uid = (int)SecurityUtils.getSubject().getSession().getAttribute("id");
        return new ModelAndView("teacher/info")
                .addObject("user", userService.getById(uid));
    }

    @RequestMapping(value = "update-info", method = RequestMethod.POST)
    public String updateInfo(User user){
        user.setUid((int)SecurityUtils.getSubject().getSession().getAttribute("id"));
        userService.updateUserInfo(user);
        return "redirect:/teacher/main";
    }

    @RequestMapping(value = "main")
    public String main(){
        return "teacher/main";
    }
}
