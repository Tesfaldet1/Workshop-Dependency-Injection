package se.lexicon.service;

import se.lexicon.Exception.DataNotFoundException;
import se.lexicon.models.Student;

import java.util.List;
import java.util.Optional;

public interface StudentManagement {
    Student create();
    Student save (Student student);
    Student findById(int studentId);

    Student remove(int id) throws DataNotFoundException;
    List<Student> findAll();
    Student edit(Student student) throws DataNotFoundException;

}
