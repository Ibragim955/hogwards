package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;

import java.util.Collection;
import java.util.Optional;

@Service
public interface FacultyService {



    Optional<Faculty> findFaculty(Long id);

    Faculty createFaculty(Faculty faculty);

    Faculty editFaculty(Faculty faculty);

    void deleteFaculty(Long id);



    Collection<Faculty> getAllFaculty();



    Collection<Faculty> findByColor(String name, String color);


}
