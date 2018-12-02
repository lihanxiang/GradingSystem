package controller;

import entity.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import service.QuestionService;

import java.util.List;

@Controller
@RequestMapping(value = "/question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @RequestMapping(value = "/{aid}/get-questions", method = RequestMethod.GET)
    public ModelAndView getQusetionsByAssignment(@PathVariable("aid") int aid){
        return new ModelAndView("student/questionList")
                .addObject("questionList", questionService.getQusetionsByAssignment(aid));
    }
}
