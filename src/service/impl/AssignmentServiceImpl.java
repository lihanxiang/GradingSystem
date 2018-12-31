package service.impl;

import entity.Assignment;
import entity.User;
import mapper.AssignmentMapper;
import mapper.CourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.AssignmentService;
import java.util.List;

@Service
public class AssignmentServiceImpl implements AssignmentService {

    private final AssignmentMapper assignmentMapper;

    @Autowired
    public AssignmentServiceImpl(AssignmentMapper assignmentMapper) {
        this.assignmentMapper = assignmentMapper;
    }

    @Override
    public int addAssignmentToCourse(Assignment assignment) {
        return assignmentMapper.addAssignmentToCourse(assignment);
    }

    @Override
    public Assignment getAssignmentById(int aid) {
        return assignmentMapper.getAssignmentById(aid);
    }

    @Override
    public List<Assignment> getAssignmentByCourseCode(String code) {
        return assignmentMapper.getAssignmentByCourseCode(code);
    }

    @Override
    public List<String> getStudentNameByAssignment(int aid) {
        return assignmentMapper.getStudentNameByAssignment(aid);
    }
}
