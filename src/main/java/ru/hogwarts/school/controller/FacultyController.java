package ru.hogwarts.school.controller;

import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.service.FacultyService;

@RestController
@RequestMapping("faculty")
public class FacultyController {

    private final FacultyService facultyService;

    private FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }
    @GetMapping("{id}") // Get http://localhost:8080/faculty/23
    public Faculty getFacultyInfo(@PathVariable long id){
        return facultyService.findFaculty(id);
    }
    @PostMapping // POST http://localhost:8080/faculty
    public Faculty creatFaculty(@RequestBody Faculty faculty){
        return facultyService.createFaculty(faculty);
    }
    @PutMapping // PUT http://localhost:8080/faculty
    public Faculty editFacilty(@RequestBody Faculty faculty){
        return facultyService.editFaculty(faculty);
    }
    @DeleteMapping("{id}") // DELETE http://localhost:8080/faculty/23
    public Faculty deleteFaculty(@PathVariable long id){
        return facultyService.deleteFaculty(id);
    }
}
