package controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import service.AssignmentService;

@Controller
@RequestMapping(value = "/assignment")
public class AssignmentController {

    private final AssignmentService assignmentService;

    @Autowired
    public AssignmentController(AssignmentService assignmentService) {
        this.assignmentService = assignmentService;
    }

    @RequestMapping(value = "preAdd", method = RequestMethod.GET)
    public String preAdd(){
        return "teacher/addAssignment";
    }

    /*@RequestMapping(value = "/{name}/add-assignment", method = RequestMethod.POST)
    public ModelAndView addAssignment(String name, int questionNum, @PathVariable("name") String courseName){
        assignmentService.addAssignmentToCourse(name, questionNum, courseName);
        return new ModelAndView("teacher/questions")
                .addObject("questionNum", questionNum);
    }*/

    @RequestMapping(value = "/{courseName}/get-assignment")
    public ModelAndView getAssignmentByCourseForStudent(@PathVariable("courseName")String courseName){
        Subject subject = SecurityUtils.getSubject();
        int id = (int)subject.getSession().getAttribute("id");
        ModelAndView modelAndView = new ModelAndView("student/assignmentList");
        return modelAndView.addObject("assignmentList",
                assignmentService.getAssignmentByCourseForStudent(courseName, id));
    }
}
