package by.bntu.fitr.controller;


import by.bntu.fitr.entity.Subject;
import by.bntu.fitr.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/teacher")
public class TeacherController {

    private final SubjectRepository subjectRepository;

    @Autowired
    public TeacherController(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    @GetMapping("/panel")
    public String getTeacherForm() {
        return "teacher/teacher";
    }

    @GetMapping("/create-subject")
    public String getSubjectCreatedForm(Model model) {
        model.addAttribute("subject",new Subject());
        return "teacher/create-subject";
    }

    @PostMapping("/create-subject")
    public String addSubject(@Valid @ModelAttribute("subject") Subject subject, BindingResult bindingResult) {

        if(bindingResult.hasErrors()){
            return "redirect:/teacher/create-subject";
        }

        subjectRepository.save(subject);

        return "redirect:/teacher/panel";
    }
}
