package mapper;

import entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    void addStudent(User user);
    void addTeacher(User user);

    void deleteStudent(int uid);

    void updateUserInfo(User user);

    User getByName(String username);
    User getById(int uid);
    List<User> getAllStudents();
}
