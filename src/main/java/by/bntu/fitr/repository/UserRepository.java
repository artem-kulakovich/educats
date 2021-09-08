package by.bntu.fitr.repository;

import by.bntu.fitr.entity.Group;
import by.bntu.fitr.entity.Role;
import by.bntu.fitr.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface UserRepository extends JpaRepository<User, Long> {

    User findByUserName(String userName);

    List<User> findByEnabled(int enabled);

    User findById(long id);

    /*
    @Query(value = "select *from \"user\" " +
            "join on \"user\".role_id = \"role\".id"+
            "join on \"user\".group_id = \"group\".id",
            nativeQuery = true)
     */

    @Query(value = "select *from \"user\" Where role_id != 2 and role_id != 4 and enabled = 1 and group_id is null "
            , nativeQuery = true)
    List<User> getAllByGroupAndEnabledAndRole();

}
