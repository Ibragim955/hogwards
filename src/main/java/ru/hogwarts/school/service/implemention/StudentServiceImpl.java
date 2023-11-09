package ru.hogwarts.school.service.implemention;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.model.repositories.StudentRepository;
import ru.hogwarts.school.service.StudentService;

import java.util.Collection;

@Service
public abstract class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

@Override
    public Student createStudent(Student student){
        return StudentRepository.save(student);
    }



    @Override
    public Student findStudent(long id) {
       return studentRepository.findById(id);
    }
@Override
    public Student editStudent(Student student) {
      return StudentRepository.save(student);
    }
    @Override
    public Student deleteStudent(long id){
      return studentRepository.deletyById(id);
    }
    @Override
   public Collection<Student>getAllStudent(){
       return studentRepository.findAll();
   }
}
