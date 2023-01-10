package se.lexicon.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import se.lexicon.Exception.DataNotFoundException;
import se.lexicon.data_access.StudentDao;
import se.lexicon.data_access.implement.Sequencer.StudentIdSequencer;
import se.lexicon.models.Student;
import se.lexicon.service.StudentManagement;
import se.lexicon.util.UserInputService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class StudentManagementConsoleImpl implements StudentManagement {
    private List<Student> storage = new ArrayList<>();
    UserInputService scannerService;
    StudentDao studentDao;

    @Autowired
    public StudentManagementConsoleImpl(UserInputService scannerService, StudentDao studentDao) {
        this.scannerService = scannerService;
        this.studentDao = studentDao;
    }

    @Override
    public Student create(Student student) {
        if (student == null) throw new IllegalArgumentException("student was null");
        student.setId(StudentIdSequencer.nextId());
        storage.add(student);
        return student;
    }

    @Override
    public Student save(Student student) {
        student.setId(StudentIdSequencer.nextId());
        storage.add(student);
        return student;
    }

    @Override
    public Optional<Student> findById(int studentId) {
        if (studentId == 0) throw new IllegalArgumentException("id was null");
        return storage.stream().filter(student -> student.getId() == studentId).findFirst();
    }

    @Override
    public Student remove(int id) throws DataNotFoundException {
        Optional<Student> optionalStudent = findById(id);
        if (!optionalStudent.isPresent()) throw new DataNotFoundException("data not found exception");
        else storage.remove(optionalStudent.get());
        return null;
    }

    @Override
    public List<Student> findAll() {
        return new ArrayList<>(storage);
    }

    @Override
    public void edit(Student student) {
        if (student == null) throw new IllegalArgumentException("to edit data was null");
        for (Student original : storage) {
            if (original.getId() == student.getId()) {
                original.setId(student.getId());
                original.setName(student.getName());
            }
        }

    }

}
