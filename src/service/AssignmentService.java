package service;

import entity.Assignment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AssignmentService {

    int addAssignmentToCourse(Assignment assignment, String courseName);

    Assignment getAssignmentById(int aid);
    List<Assignment> getAssignmentByCourseName(String courseName);
    List<Assignment> getAssignmentByCourseForStudent(@Param("courseName") String courseName, @Param("uid") int uid);
}