package by.bntu.fitr.service.impl;


import by.bntu.fitr.entity.Group;
import by.bntu.fitr.repository.GroupRepository;
import by.bntu.fitr.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {

    private GroupRepository groupRepository;

    @Autowired
    public GroupServiceImpl(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @Override
    public void createGroup(Group group) {
        if (findGroupByName(group.getName()) == null) {
            groupRepository.save(group);
        }
    }

    @Override
    public Group findGroupById(int id) {
        return groupRepository.findById(id);
    }

    @Override
    public Group findGroupByName(String name) {
        return groupRepository.findByName(name);
    }

    @Override
    public List<Group> getAllGroups() {
        return groupRepository.findAll();
    }
}
