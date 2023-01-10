package se.lexicon.service;

import se.lexicon.Exception.DataNotFoundException;
import se.lexicon.models.Student;

import java.util.List;
import java.util.Optional;

public interface StudentManagement {
    Student create(Student student);
    Student save (Student student);
    Optional<Student> findById(int studentId);

    Student remove(int id) throws DataNotFoundException;
    List<Student> findAll();
    void edit(Student student) throws DataNotFoundException;

}
