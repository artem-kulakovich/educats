package by.bntu.fitr.repository;

import by.bntu.fitr.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository  extends JpaRepository<Role,Integer> {
    Role findById(int id);
    Role findByName(String name);
}
