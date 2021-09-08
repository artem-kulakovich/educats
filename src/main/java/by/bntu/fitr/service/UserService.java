package by.bntu.fitr.service;

import by.bntu.fitr.entity.Group;
import by.bntu.fitr.entity.User;

import java.util.List;

public interface UserService {
    User findUserByUserName(String userName);

    void registerUser(User user);

    List<User> findUserByEnabledStatus(int enabled);

    void updateUserStatus(User user,int status);

    User findUserById(long id);

    void updateUserRole(String role,User user);

    List<User> getUsersByStatusAndGroup(int status);

    void addUserToGroup(int groupId, int userId);
}
