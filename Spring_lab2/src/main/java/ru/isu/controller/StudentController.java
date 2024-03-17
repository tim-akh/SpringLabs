package ru.isu.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import ru.isu.model.Student;
import ru.isu.service.StudentService;
import ru.isu.validator.StudentValidator;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@Controller
@RequestMapping("/student")
@SessionAttributes("student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/add")
    public String showForm(Model model) {
        model.addAttribute("student", new Student());
        return "student";
    }

    @PostMapping("/add")
    public String submitForm(@ModelAttribute("student") @Valid Student student, Errors errors, Model model)
    {
        if (!errors.hasErrors()) {
            student.setAge(studentService.getStudentAge(student));
            model.addAttribute("student", student);
            return "redirect:/student/result";
        }
        else {
            model.addAttribute("student", student);
            return "student";
        }
    }

    @GetMapping("/result")
    public String showResult(@ModelAttribute("student") Student student, Model model, SessionStatus status) {
        model.addAttribute("student", student);
        status.setComplete();
        return "result";
    }

    @ModelAttribute("birthCities")
    public List<String> getCitiesList() {
        List<String> cities = new LinkedList(Arrays.asList(new String[]{"Irkutsk", "Angarsk", "Shelekhov"}));
        return cities;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(new StudentValidator());
    }

}
