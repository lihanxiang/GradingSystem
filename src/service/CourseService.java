package service;

import entity.Course;

import java.util.List;

public interface CourseService {

    void addCourse(Course course);

    void updateCourseInfo(Course course);

    int countCourseByUsername(int uid);
    List<Course> getCoursesByTeacher(int uid);
    List<Course> getCoursesByStudent(int uid);
    List<Course> getAllCourses();
}
