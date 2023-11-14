package ru.hogwarts.school.service.implemention;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repositories.StudentRepository;
import ru.hogwarts.school.service.StudentService;

import java.util.Collection;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

@Override
    public Student createStudent(Student student){
        return studentRepository.save(student);
    }



    @Override
    public Optional<Student> findStudent(Long id) {
       return studentRepository.findById(id);
    }
@Override
    public Student editStudent(Student student) {
      return studentRepository.save(student);
    }
    @Override
    public void deleteStudent(Long id){
        studentRepository.deleteById(id);
    }
    @Override
   public Collection<Student>getAllStudent(){
       return studentRepository.findAll();
   }
@Override
   public Collection<Student>findAllByAgeBetween(int minAge, int maxAge){
        return studentRepository.findAllByAgeBetween(minAge, maxAge);
   }


}
