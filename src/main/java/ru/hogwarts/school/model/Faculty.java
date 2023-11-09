package ru.hogwarts.school.model;

import nonapi.io.github.classgraph.json.Id;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.EnableLoadTimeWeaving;

import javax.annotation.processing.Generated;
import java.util.Objects;
@EntityScan
public class Faculty {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String color;

    public Faculty(Long id, String name, String color) {
        this.id = id;
        this.name = name;
        this.color = color;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Faculty faculte = (Faculty) o;
        return Objects.equals(id, faculte.id) && Objects.equals(name, faculte.name) && Objects.equals(color, faculte.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, color);
    }


}
