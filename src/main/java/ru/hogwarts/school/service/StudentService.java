package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;

import java.util.Collection;
import java.util.Optional;

@Service
public interface StudentService {


    Optional<Student> findStudent(Long id);

    Student editStudent(Student student);

    void deleteStudent(Long id);



    Student createStudent(Student student);


    Collection<Student> getAllStudent();


    Collection<Student>findAllByAgeBetween(int minAge, int maxAge);
}
