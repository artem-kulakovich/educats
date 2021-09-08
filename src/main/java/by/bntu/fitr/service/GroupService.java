package by.bntu.fitr.service;

import by.bntu.fitr.entity.Group;

import java.util.List;

public interface GroupService {
    void createGroup(Group group);

    Group findGroupById(int id);

    Group findGroupByName(String name);

    List<Group> getAllGroups();
}
