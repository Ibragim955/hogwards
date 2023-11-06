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
    public Faculty getFacultyBayColor(String color) {
        for (int i = 0; i < storage.size(); i++) {
            if(storage[i])
        }
    }
}
