package se.lexicon.data_access;

import se.lexicon.Exception.DataNotFoundException;
import se.lexicon.models.Student;

import java.util.List;

public interface StudentDao {
    Student save(Student student);
    Student findById(int id) throws DataNotFoundException;
    List<Student> findAll();
    void delete(int studentId) throws DataNotFoundException;

}
