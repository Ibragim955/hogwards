package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
@Service
public interface FacultyService {



    Faculty findFaculty(long id);

    Faculty createFaculty(Faculty faculty);

    Faculty editFaculty(Faculty faculty);

    Faculty deleteFaculty(long id);
}
