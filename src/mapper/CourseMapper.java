package mapper;

import entity.Course;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CourseMapper {

    void addCourse(Course course);

    void updateCourseInfo(Course course);

    int countCourseByStudentId(int uid);
    List<Course> getCoursesByTeacher(int uid);
    List<Course> getCoursesByStudent(int uid);
    List<Course> getAllCourses();
}
