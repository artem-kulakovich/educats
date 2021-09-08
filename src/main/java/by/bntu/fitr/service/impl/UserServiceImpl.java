package by.bntu.fitr.service.impl;

import by.bntu.fitr.constant.Constant;
import by.bntu.fitr.entity.Group;
import by.bntu.fitr.entity.Role;
import by.bntu.fitr.entity.User;
import by.bntu.fitr.repository.GroupRepository;
import by.bntu.fitr.repository.RoleRepository;
import by.bntu.fitr.repository.UserRepository;
import by.bntu.fitr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    private final GroupRepository groupRepository;


    @Autowired
    public UserServiceImpl(UserRepository userRepository,
                           RoleRepository roleRepository,
                           GroupRepository groupRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.groupRepository = groupRepository;
    }


    @Override
    public User findUserByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    @Override
    @Transactional
    public void registerUser(User user) {
        user.setRole(roleRepository.findByName(Constant.ROLE_USER));
        user.setEnabled(Constant.WAITING);
        userRepository.save(user);
    }

    @Override
    public List<User> findUserByEnabledStatus(int enabled) {
        return userRepository.findByEnabled(enabled);
    }

    @Override
    public void updateUserStatus(User user, int status) {
        user.setEnabled(status);
        userRepository.save(user);
    }

    @Override
    public User findUserById(long id) {
        return userRepository.findById(id);
    }

    @Override
    public void updateUserRole(String role, User user) {

        Role userRole = roleRepository.findByName(role);

        if (userRole == null) {
            user.setRole(new Role(role));
        } else {
            user.setRole(userRole);
        }

        userRepository.save(user);
    }

    @Override
    public List<User> getUsersByStatusAndGroup(int status) {
        return userRepository.getAllByGroupAndEnabledAndRole();
    }

    @Override
    @Transactional
    public void addUserToGroup(int groupId, int userId) {
        User user = userRepository.findById(userId);
        Group group = groupRepository.findById(groupId);
        user.setGroup(group);
    }
}
