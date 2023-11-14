package ru.hogwarts.school.model;

import jakarta.persistence.*;

import javax.swing.text.Position;
import java.util.Objects;
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int age;
    @OneToOne
    @JoinColumn(name = "avatar_id")
    private Avatar avatar;
    @ManyToOne
    @JoinColumn(name = "faculty_id") // this references the faculty id in the faculties table.
    private Faculty faculty;


    public Student(String name, int age, Avatar avatar) {
        this.name = name;
        this.age = age;
        this.avatar = avatar;
    }

    public Student() {

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age && Objects.equals(id, student.id) && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age);
    }

}
