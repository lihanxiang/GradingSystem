package service.impl;

import entity.Course;
import mapper.CourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.CourseService;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseMapper courseMapper;

    @Override
    public void addCourse(Course course) {
        courseMapper.addCourse(course);
    }

    @Override
    public void updateCourseInfo(Course course) {
        courseMapper.updateCourseInfo(course);
    }

    @Override
    public int countCourseByUsername(int uid) {
        return courseMapper.countCourseByStudentId(uid);
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
    public List<Course> getAllCourses() {
        return courseMapper.getAllCourses();
    }
}
