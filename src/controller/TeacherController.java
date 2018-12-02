package controller;

import entity.Answer;
import entity.Course;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import service.AnswerService;
import service.AssignmentService;
import service.CourseService;
import service.UserService;

import java.util.List;

@Controller
@RequestMapping(value = "/teacher")
public class TeacherController {
    @Autowired
    private AssignmentService assignmentService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private AnswerService answerService;

    @RequestMapping(value = "/{id}/get-courses-by-teacher", method = RequestMethod.GET)
    public ModelAndView getCoursesByTeacher(@PathVariable("id") int id){
        return new ModelAndView("teacher/courseList")
                .addObject("courseList", courseService.getCoursesByTeacher(id));
    }

    @RequestMapping(value = "/{courseName}/get-assignments", method = RequestMethod.GET)
    public ModelAndView getAssignmentByCourseName(@PathVariable("courseName") String courseName){
        return new ModelAndView("teacher/assignmentList")
                .addObject("assignmentList", assignmentService.getAssignmentByCourseName(courseName));
    }

    @RequestMapping(value = "/{id}/get-answers")
    public ModelAndView getAnswerForQuestion(@PathVariable("id") int id) {
        return new ModelAndView("teacher/answerList")
                .addObject("answerList", answerService.getAnswerForQuestion(id));
    }

    @RequestMapping(value = "main")
    public String main(){
        return "teacher/main";
    }
}
