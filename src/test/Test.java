package test;

import entity.User;
import mapper.UserMapper;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:config/spring/spring-*.xml")
public class Test {

    @Autowired
    private UserService userService;

    @org.junit.Test
    public void test(){
        for (int i = 1; i <= 5; i++) {
            User user = new User("teacher" + i, "teacher" + i,"teacher" + i,"teacher" + i,"teacher" + i);
            userService.addTeacher(user);
        }
        for (int i = 1; i <= 5; i++) {
            User user = new User("student" + i, "student" + i,"student" + i,"student" + i,"student" + i);
            userService.addStudent(user);
        }
    }
}
