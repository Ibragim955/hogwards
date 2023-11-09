package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;

import java.util.Collection;

@Service
public interface FacultyService {



    Faculty findFaculty(long id);

    Faculty createFaculty(Faculty faculty);

    Faculty editFaculty(Faculty faculty);

    void deleteFaculty(long id);



    Collection<Faculty> getAllFaculty();
}
