package ru.hogwarts.school.model.repositories;

import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;

import java.util.Collection;


@Repository
public interface FacultyRepository extends JpaRepositories {
    Faculty save(Faculty faculty);

    Faculty findById(long id);

    Faculty deleteById(long id);

    Collection<Faculty> findAll();
}
