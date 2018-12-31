package service;

import entity.User;

import java.util.List;

public interface UserService {

    void addStudent(User user);
    void addTeacher(User user);
    void deleteStudent(int uid);
    void updateUserInfo(User user);
    User getByName(String username);
    User getById(int uid);
    List<User> getAllStudents();
}
