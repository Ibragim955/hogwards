package ru.hogwarts.school.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.StudentService;

import java.util.Collection;

@RestController
@RequestMapping("student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @GetMapping("{id}") // Get http://localhost:8080/student/23
    public Student getStudentInfo(@PathVariable long id){
        return studentService.findStudent(id);
    }
    @PostMapping // POST http://localhost:8080/student
    public Student creatStudent(@RequestBody Student student){
        return studentService.createStudent(student);
    }
    @PutMapping // PUT http://localhost:8080/student
    public Student editStudent(@RequestBody Student student){
        return studentService.editStudent(student);
    }
    @DeleteMapping("{id}") // DELETE http://localhost:8080/student/23
    public ResponseEntity<Object> deleteStudent(@PathVariable long id){
        studentService.deleteStudent(id);
        return ResponseEntity.ok().build();
    }
    @GetMapping // Get http://localhost:8080/student/23
   public ResponseEntity<Collection<Student>> getAllStudent(){
        return ResponseEntity.ok(studentService.getAllStudent());
    }
}
