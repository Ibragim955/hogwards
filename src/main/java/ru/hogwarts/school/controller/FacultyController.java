package ru.hogwarts.school.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.service.FacultyService;

import java.util.Collection;
import java.util.Optional;

@RequestMapping("faculty")
public class FacultyController {

    private final FacultyService facultyService;

    private FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }
    @GetMapping("{id}") // Get http://localhost:8080/faculty/23
    public Optional<Faculty> getFacultyInfo(@PathVariable Long id){
        return facultyService.findFaculty(id);
    }
    @PostMapping // POST http://localhost:8080/faculty
    public Faculty creatFaculty(@RequestBody Faculty faculty){
        return facultyService.createFaculty(faculty);
    }
    @PutMapping // PUT http://localhost:8080/faculty
    public Faculty editFaculty(@RequestBody Faculty faculty){
        return facultyService.editFaculty(faculty);
    }
    @DeleteMapping("{id}") // DELETE http://localhost:8080/faculty/23
    public ResponseEntity<Object> deleteFaculty(@PathVariable Long id){
        facultyService.deleteFaculty(id);
        return ResponseEntity.ok().build();
    }
    @GetMapping // Get http://localhost:8080/faculty/23
    public ResponseEntity<Collection<Faculty>> getAllFaculty(){
        return ResponseEntity.ok(facultyService.getAllFaculty());
    }
    @GetMapping("byColor")
   // ResponseEntity
     Collection <Faculty> findByColor(@RequestParam String color,@RequestParam String name){
        return facultyService.findByColor(name, color);
    }
}
