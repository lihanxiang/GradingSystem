package mapper;

import entity.Assignment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AssignmentMapper {

    int addAssignmentToCourse(Assignment assignment, @Param("courseName") String courseName);
    int addAssignmentToStudent()

    Assignment getAssignmentById(int aid);
    List<Assignment> getAssignmentByCourseName(String courseName);
    List<Assignment> getAssignmentByCourseForStudent(@Param("courseName") String courseName, @Param("uid") int uid);
}
