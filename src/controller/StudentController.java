package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import service.CourseService;
import service.UserService;

@Controller
@RequestMapping(value = "/student")
public class StudentController {

    private final UserService userService;

    private final CourseService courseService;

    @Autowired
    public StudentController(CourseService courseService, UserService userService) {
        this.courseService = courseService;
        this.userService = userService;
    }

    @RequestMapping(value = "/{id}/get-courses-by-student", method = RequestMethod.GET)
    public ModelAndView getCoursesByTeacher(@PathVariable("id") int id){
        return new ModelAndView("student/courseList")
                .addObject("courseList", courseService.getCoursesByStudent(id));
    }

    @RequestMapping(value = "main")
    public String main(){
        return "teacher/main";
    }
}
