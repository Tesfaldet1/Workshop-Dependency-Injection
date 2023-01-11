package se.lexicon.data_access.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import se.lexicon.Exception.DataNotFoundException;
import se.lexicon.data_access.StudentDao;
import se.lexicon.data_access.implement.Sequencer.StudentIdSequencer;
import se.lexicon.models.Student;
import se.lexicon.util.UserInputService;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentDaoListImpl implements StudentDao {
    private List<Student> storage = new ArrayList<>();
    @Autowired
    UserInputService scannerService;
    @Override
    public Student save(Student student) {
        if(student== null) throw new IllegalArgumentException("student was null");
        if(student.getId()==0) {
            student.setId(StudentIdSequencer.nextId());
            storage.add(student);
        }else{
            System.out.println("Enter the name you want to update");
            String studentInput = scannerService.getString();
            student.setName(studentInput);
        }
        return student;
    }

    @Override
    public Student findById(int id) throws DataNotFoundException{
        if(id == 0) throw  new IllegalArgumentException("id was null");
        return storage.stream().filter(student -> student.getId()==id).findFirst()
                .orElseThrow(()->new DataNotFoundException("student not found"));
    }

    @Override
    public List<Student> findAll() {
        return new ArrayList<>(storage);
    }

    @Override
    public void delete(int studentId) throws DataNotFoundException {
        Student removeStudent = findById(studentId);
        storage.remove(removeStudent);


    }
}
