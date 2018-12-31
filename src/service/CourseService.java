package service;

import entity.Course;
import entity.User;

import java.util.List;

public interface CourseService {

    void addCourse(Course course);
    void addStudentToCourse(String code, int uid);
    void updateCourseInfo(Course course);
    Course getCourseByCode(String code);
    List<Course> getCoursesByTeacher(int uid);
    List<Course> getCoursesByStudent(int uid);
    List<Course> getCourses();
    List<User> getStudentsForCourse(String code);
    List<User> getStudentsNotInCourse(String code);
}
