package ru.isu.service;


import org.springframework.stereotype.Service;
import ru.isu.model.Student;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


@Service("studentService")
public class StudentService {

    public long getStudentAge(Student student) {
        LocalDate studentBirthDate = student.getBirthDate();
        LocalDate currentLocalDate = LocalDate.now();
        return ChronoUnit.YEARS.between(studentBirthDate, currentLocalDate);
    }
}
