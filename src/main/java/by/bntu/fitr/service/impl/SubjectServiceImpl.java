package by.bntu.fitr.service.impl;

import by.bntu.fitr.entity.Subject;
import by.bntu.fitr.repository.SubjectRepository;
import by.bntu.fitr.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubjectServiceImpl implements SubjectService {

    private final SubjectRepository subjectRepository;

    @Autowired
    public SubjectServiceImpl(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    @Override
    public void createSubject(Subject subject) {
        subjectRepository.save(subject);
    }
}
