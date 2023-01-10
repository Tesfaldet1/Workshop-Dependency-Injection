package se.lexicon.data_access;

import se.lexicon.Exception.DataNotFoundException;
import se.lexicon.models.Student;

import java.util.List;
import java.util.Optional;

public interface StudentDao {
    Student save(Student student);
    Optional <Student> findById(int id);
    List<Student> findAll();
    void delete(int studentId) throws DataNotFoundException;

}
