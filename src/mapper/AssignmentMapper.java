package mapper;

import entity.Assignment;
import java.util.List;

public interface AssignmentMapper {

    int addAssignmentToCourse(Assignment assignment);
    Assignment getAssignmentById(int aid);
    List<Assignment> getAssignmentByCourseCode(String code);
    List<String> getStudentNameByAssignment(int aid);
}
