package service.impl;

import entity.User;
import mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.UserService;
import util.Encryption;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;
    private final Encryption encryption;

    @Autowired
    public UserServiceImpl(UserMapper userMapper, Encryption encryption) {
        this.userMapper = userMapper;
        this.encryption = encryption;
    }

    @Override
    public void addStudent(User user) {
        encryption.encryptPassword(user);
        userMapper.addStudent(user);
    }

    @Override
    public void addTeacher(User user) {
        encryption.encryptPassword(user);
        userMapper.addTeacher(user);
    }

    @Override
    public void deleteStudent(int uid) {
        userMapper.deleteStudent(uid);
    }

    @Override
    public void updateUserInfo(User user) {
        userMapper.updateUserInfo(user);
    }

    @Override
    public User getByName(String username) {
        return userMapper.getByName(username);
    }

    @Override
    public User getById(int id){
        return userMapper.getById(id);
    }

    @Override
    public List<User> getAllStudents() {
        return userMapper.getAllStudents();
    }
}
