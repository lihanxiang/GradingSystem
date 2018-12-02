package service.impl;

import entity.Assignment;
import mapper.AssignmentMapper;
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
    public int addAssignmentToCourse(Assignment assignment, String courseName) {
        return assignmentMapper.addAssignmentToCourse(assignment, courseName);
    }

    @Override
    public Assignment getAssignmentById(int aid) {
        return assignmentMapper.getAssignmentById(aid);
    }

    @Override
    public List<Assignment> getAssignmentByCourseName(String courseName) {
        return assignmentMapper.getAssignmentByCourseName(courseName);
    }

    @Override
    public List<Assignment> getAssignmentByCourseForStudent(String courseName, int uid) {
        return assignmentMapper.getAssignmentByCourseForStudent(courseName, uid);
    }
}
