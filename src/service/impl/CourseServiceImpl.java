package service.impl;

import entity.Course;
import entity.User;
import mapper.CourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.CourseService;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseMapper courseMapper;

    @Autowired
    public CourseServiceImpl(CourseMapper courseMapper) {
        this.courseMapper = courseMapper;
    }

    @Override
    public void addCourse(Course course) {
        courseMapper.addCourse(course);
    }

    @Override
    public void addStudentToCourse(String code, int uid) {
        courseMapper.addStudentToCourse(code, uid);
    }

    @Override
    public void updateCourseInfo(Course course) {
        courseMapper.updateCourseInfo(course);
    }

    @Override
    public Course getCourseByCode(String code) {
        return courseMapper.getCourseByCode(code);
    }

    @Override
    public List<User> getStudentsForCourse(String code) {
        return courseMapper.getStudentsByCourseCode(code);
    }

    @Override
    public List<User> getStudentsNotInCourse(String code) {
        return courseMapper.getStudentsNotInCourse(code);
    }

    @Override
    public List<Course> getCoursesByTeacher(int uid) {
        return courseMapper.getCoursesByTeacher(uid);
    }

    @Override
    public List<Course> getCoursesByStudent(int uid) {
        return courseMapper.getCoursesByStudent(uid);
    }

    @Override
    public List<Course> getCourses() {
        return courseMapper.getCourses();
    }
}
