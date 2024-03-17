package ru.isu.model;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;


import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

public class Student {
    @NotBlank(message = "You should enter student\'s surname")
    private String surname;
    @NotBlank(message = "You should enter student\'s firstname")
    private String firstname;
    @NotBlank(message = "You should enter student\'s patronymic")
    private String patronymic;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;
    @NotBlank(message = "You should enter student\'s gender")
    private String gender;
    private String birthCity;
    private Faculties faculty;
    @NotBlank(message = "You should enter student\'s group")
    private String group;
    private long age;

    //constructors
    public Student() {}

    //getters
    public String getSurname() {
        return surname;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getGender() {
        return gender;
    }

    public String getBirthCity() {
        return birthCity;
    }

    public Faculties getFaculty() {
        return faculty;
    }

    public String getGroup() {
        return group;
    }

    public long getAge() {
        return age;
    }

    //setters

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setBirthCity(String birthCity) {
        this.birthCity = birthCity;
    }

    public void setFaculty(Faculties faculty) {
        this.faculty = faculty;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public void setAge(long age) {
        this.age = age;
    }
}
