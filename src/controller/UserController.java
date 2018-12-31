package controller;

import entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import service.UserService;

@Controller
@RequestMapping(value = "user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "pre-add-student", method = RequestMethod.GET)
    public ModelAndView preAddStudent(){
        return new ModelAndView("user/addStudent");
    }

    @RequestMapping(value = "pre-add-teacher", method = RequestMethod.GET)
    public ModelAndView preAddTeacher(){
        return new ModelAndView("user/addTeacher");
    }

    @RequestMapping(value = "add-student")
    public ModelAndView addStudent(User user){
        userService.addStudent(user);
        return new ModelAndView("user/login");
    }

    @RequestMapping(value = "add-teacher")
    public ModelAndView addTeacher(User user){
        userService.addTeacher(user);
        return new ModelAndView("user/login");
    }

    @RequestMapping(value = "pre-login", method = RequestMethod.GET)
    public ModelAndView preLogin(){
        return new ModelAndView("user/login");
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public ModelAndView login(User user){
        ModelAndView modelAndView;
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
        try {
            subject.login(token);
            User _user = userService.getByName(user.getUsername());
            subject.getSession().setAttribute("id", _user.getUid());
            subject.getSession().setAttribute("username", _user.getUsername());
            if (_user.getRole().equals("student")){
                modelAndView = new ModelAndView("student/main");
            } else {
                modelAndView = new ModelAndView("teacher/main");
            }
            modelAndView.addObject("username", user.getUsername());
            modelAndView.addObject("id", subject.getSession().getAttribute("id"));
        } catch (AuthenticationException e){
            modelAndView = new ModelAndView("/user/login");
            modelAndView.addObject("message", "用户名/密码错误");
        }
        return modelAndView;
    }

    @RequestMapping(value = "logout")
    public String logout(){
        SecurityUtils.getSubject().logout();
        return "/user/login";
    }
}
