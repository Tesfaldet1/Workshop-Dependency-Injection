package se.lexicon.data_access.implement;

import org.springframework.stereotype.Component;
import se.lexicon.Exception.DataNotFoundException;
import se.lexicon.data_access.StudentDao;
import se.lexicon.data_access.implement.Sequencer.StudentIdSequencer;
import se.lexicon.models.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class StudentDaoListImpl implements StudentDao {
    private List<Student> storage = new ArrayList<>();
    @Override
    public Student save(Student student) {
        if(student== null) throw new IllegalArgumentException("student was null");
        student.setId(StudentIdSequencer.nextId());
        storage.add(student);
        return student;
    }

    @Override
    public Optional <Student> findById(int id) {
        if(id == 0) throw  new IllegalArgumentException("id was null");
        return storage.stream().filter(student -> student.getId()==id).findFirst();
    }

    @Override
    public List<Student> findAll() {
        return new ArrayList<>(storage);
    }

    @Override
    public void delete(int studentId) throws DataNotFoundException {
        Optional <Student> optionalStudent = findById(studentId);
        if(!optionalStudent.isPresent()) throw new DataNotFoundException("data not found exception");
        else storage.remove(optionalStudent.get());


    }
}
