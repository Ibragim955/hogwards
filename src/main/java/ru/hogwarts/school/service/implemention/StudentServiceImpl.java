package ru.hogwarts.school.service.implemention;

import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.StudentService;

import java.util.HashMap;
import java.util.Map;

public class StudentServiceImpl implements StudentService {
    Map<Long, Student> storage = new HashMap<>();
    private Long increment = 0l;
    public Student createStudent(Student student){
        student.setId(++increment);
        storage.put(increment, student);
        return student;
    }

    public Student findStudent(long id) {
        return storage.get(id);
    }

    public Student editStudent(Student student) {
        storage.put(student.getId(), student);
        return student;
    }
    public Student deleteStudent(long id){
        return storage.remove(id);
    }
}
