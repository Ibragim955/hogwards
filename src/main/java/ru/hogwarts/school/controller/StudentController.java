package ru.hogwarts.school.controller;

import ru.hogwarts.school.service.StudentService;

public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
}
