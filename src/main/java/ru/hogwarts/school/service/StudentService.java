package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.model.repositories.StudentRepository;

import java.util.Collection;
import java.util.HashMap;
@Service
public interface StudentService {


    Student findStudent(long id);

    Student editStudent(Student student);

    Student deleteStudent(long id);



    Student createStudent(Student student);


    Collection<Student> getAllStudent();
}
