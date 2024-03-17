package ru.isu.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.isu.model.Student;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Component
public class StudentValidator implements Validator {
    @Override
    public boolean supports(Class<?> type) {
        return Student.class.equals(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Student student = (Student) o;
        if (student.getBirthDate() == null) {
            errors.rejectValue("birthDate", "student.birthDate", "You should enter student\'s birth date");
        }
        else {
            LocalDate studentBirthDate = student.getBirthDate();
            LocalDate currentLocalDate = LocalDate.now();
            if (ChronoUnit.YEARS.between(studentBirthDate, currentLocalDate) < 16) {
                errors.rejectValue("birthDate", "student.birthDate", "Student\'s age must be 16 as minimum");
            }
        }
    }
}
