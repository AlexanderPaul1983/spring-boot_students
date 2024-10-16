package alexander.StudentsDemo.service;


import alexander.StudentsDemo.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;


public interface StudentService {

    List<Student> findAllStudent();
    Student saveStudent(Student student);
    Student findByEmail(String email);
    Student updateStudent(Student student);
    void  deleteStudent(String email);

}
