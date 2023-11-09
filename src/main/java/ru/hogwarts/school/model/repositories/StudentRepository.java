package ru.hogwarts.school.model.repositories;

import org.springframework.stereotype.Repository;
import ru.hogwarts.school.model.Student;

import java.util.Collection;

@Repository
public interface StudentRepository extends JpaRepositories{

    static Student save(Student student) {
        return student;
    }

    Student findById(long id);

    Student deletyById(long id);

    Collection<Student> findAll();
}
