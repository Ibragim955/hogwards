package ru.hogwarts.school.service.implemention;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.StudentService;

import java.util.HashMap;
import java.util.Map;
@Service
public class StudentServiceImpl implements StudentService {
    Map<Long, Student> storage = new HashMap<>();
    private Long increment = 0l;
    public Student createStudent(Student student){
        student.setId(++increment);
        storage.put(increment, student);
        return student;
    }


    @Override
    public Student findStudent(long id) {
        return storage.get(id);
    }
@Override
    public Student editStudent(Student student) {
        storage.put(student.getId(), student);
        return student;
    }
    @Override
    public Student deleteStudent(long id){
        return storage.remove(id);
    }
    @Override
    public HashMap<Long, Student> getStudentByAge(int age) {
        HashMap<Long, Student> newStudent = new HashMap<>();
        storage.forEach((key, value) -> {
            if (value.getAge()==age) {
                newStudent.put(key, value);
            }
        });

        return newStudent;
    }
}
