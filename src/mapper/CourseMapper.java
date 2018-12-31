package mapper;

import entity.Course;
import entity.User;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface CourseMapper {

    void addCourse(Course course);
    void addStudentToCourse(@Param("code") String code, @Param("uid") int uid);
    void updateCourseInfo(Course course);
    Course getCourseByCode(String code);
    List<Course> getCoursesByTeacher(int uid);
    List<Course> getCoursesByStudent(int uid);
    List<Course> getCourses();
    //find the students for the course
    List<User> getStudentsByCourseCode(String code);
    List<User> getStudentsNotInCourse(String code);
}
