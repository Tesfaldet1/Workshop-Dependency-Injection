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
    UserInputService scannerService;
    StudentDao studentDao;

    @Autowired
    public StudentManagementConsoleImpl(UserInputService scannerService, StudentDao studentDao) {
        this.scannerService = scannerService;
        this.studentDao = studentDao;
    }

    @Override
    public Student create() {
        System.out.println("Enter student full name");
        String username = scannerService.getString();
        return new Student(username);
    }

    @Override
    public Student save(Student student) {
        if (student == null) throw new IllegalArgumentException("student was null");
        return studentDao.save(student);
    }

    @Override
    public Student findById(int studentId) {
        if (studentId == 0) throw new IllegalArgumentException("id was not valid");
        try {
            return studentDao.findById(studentId);
        } catch (DataNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Student remove(int id) throws DataNotFoundException {
        if(id <= 0 ) throw new IllegalArgumentException("Id was not valid");
        studentDao.delete(id);
        return null;
    }

    @Override
    public List<Student> findAll() {
        return studentDao.findAll();
    }

    @Override
    public Student edit(Student student) {
        if (student == null) throw new IllegalArgumentException("to edit data was null");
        if(student.getId() == 0) throw new IllegalArgumentException("student id should not be empty or zero");
          studentDao.save(student);
          return student;

    }

}
