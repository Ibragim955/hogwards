package ru.hogwarts.school.service.implemention;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.service.FacultyService;

import java.util.HashMap;
import java.util.Map;
@Service
public class FacultyServiceImpl implements FacultyService {
    Map<Long, Faculty> storage = new HashMap<>();
private Long increment = 0L;
    @Override
    public Faculty createFaculty(Faculty faculty){
        faculty.setId(++increment);
        storage.put(increment, faculty);
        return faculty;
    }
    @Override
    public Faculty findFaculty(long id) {
        return storage.get(id);
    }


    @Override
    public Faculty editFaculty(Faculty faculty) {
        storage.put(faculty.getId(), faculty);
        return faculty;
    }
    @Override
    public Faculty deleteFaculty(long id){
        return storage.remove(id);
    }
    @Override
    public HashMap<Long, Faculty> getFacultyByColor(String color) {
        HashMap<Long, Faculty> newFaculty = new HashMap<>();
        storage.forEach((key, value) -> {
            if (value.getColor().equals(color)) {
                newFaculty.put(key, value);
            }
        });

        return newFaculty;
    }
    }

