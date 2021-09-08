package by.bntu.fitr.repository;

import by.bntu.fitr.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group,Integer> {
    Group findById(int id);

    Group findByName(String name);

}
