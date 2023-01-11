package se.lexicon;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import se.lexicon.Configuration.ComponentScanConfig;
import se.lexicon.Exception.DataNotFoundException;
import se.lexicon.data_access.StudentDao;
import se.lexicon.models.Student;
import se.lexicon.service.StudentManagement;
import se.lexicon.util.UserInputService;

import java.util.List;
import java.util.Optional;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ComponentScanConfig.class);
        StudentDao studentDao = context.getBean(StudentDao.class);
        StudentManagement studentManagement = context.getBean(StudentManagement.class);
        UserInputService userInputService =context.getBean(UserInputService.class);

        Student CreatedStudent = studentDao.save(new Student("Tesfaldet"));
        Student createdStudent1 = studentDao.save(new Student("lubna"));
        Student createdStudent2 = studentDao.save(new Student("Bob"));
        List<Student> all = studentDao.findAll();
        System.out.println(all);
        Student findById = null;
        try {
            findById = studentDao.findById(101);
        } catch (DataNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println(findById);

        try {
            studentDao.delete(101);
        } catch (DataNotFoundException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("____________-");
        System.out.println(studentDao.findAll());

        System.out.println("____________-");
        Student student = studentManagement.create();
        //System.out.println(student);

        studentManagement.save(student);
        System.out.println(studentManagement.findAll());

        System.out.println("____________-");
        System.out.println(studentManagement.findById(103));

        System.out.println("____________-");
        try {
            System.out.println(studentManagement.remove(102));
        } catch (DataNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println(studentManagement.findAll());

        System.out.println("____________-");
        try {
            System.out.println(studentManagement.edit(student));
        } catch (DataNotFoundException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(studentManagement.findAll());


    }
}
