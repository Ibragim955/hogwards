package ru.hogwarts.school.service.implemention;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.repositories.FacultyRepository;
import ru.hogwarts.school.service.FacultyService;

import java.util.Collection;
import java.util.Optional;

@Service
public class FacultyServiceImpl implements FacultyService {
   private final FacultyRepository facultyRepository;


    public FacultyServiceImpl(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    @Override
    public Faculty createFaculty(Faculty faculty){
       return facultyRepository.save(faculty);
    }
    @Override
    public Optional<Faculty> findFaculty(Long id) {
        return facultyRepository.findById(id);
    }


    @Override
    public Faculty editFaculty(Faculty faculty) {
      return facultyRepository.save(faculty);
    }
    @Override
    public void deleteFaculty(Long id){
        facultyRepository.deleteById(id);
    }

    @Override
    public Collection<Faculty> getAllFaculty(){
        return facultyRepository.findAll();
    }


@Override
    public Collection<Faculty> findByColor(String name, String color){
        return facultyRepository.findAllByColorOrNameIgnoreCase(name, color);
    }

    }

