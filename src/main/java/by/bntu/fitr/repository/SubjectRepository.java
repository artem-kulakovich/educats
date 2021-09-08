package by.bntu.fitr.repository;

import by.bntu.fitr.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject,Integer> {

     Subject getSubjectById(int id);
}
