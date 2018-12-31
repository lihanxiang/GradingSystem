package service;

import entity.Assignment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AssignmentService {

    int addAssignmentToCourse(Assignment assignment);
    Assignment getAssignmentById(int aid);
    List<Assignment> getAssignmentByCourseCode(String code);
    List<String> getStudentNameByAssignment(int aid);
}
