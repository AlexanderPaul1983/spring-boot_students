package alexander.StudentsDemo.repository;

import alexander.StudentsDemo.model.Student;
import org.springframework.stereotype.Repository;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Repository
public class InMemoryStudentDAO {
    private final List<Student> _Students = new ArrayList<>();

    public List<Student> findAllStudent(){
        return _Students;
    };
    public Student saveStudent(Student student) {
        _Students.add(student);
        return student;
    }


    public Student findByEmail(String email) {
        return _Students.stream().filter(element -> element.getEmail().equals(email))
                .findFirst().orElse(null);
    }


    public Student updateStudent(Student student) {
        var studentIndex = IntStream.range(0, _Students.size())
                .filter(index -> _Students.get(index).getEmail().equals(student.getEmail()))
                .findFirst()
                .orElse(-1);
        if(studentIndex > -1){
            _Students.set(studentIndex, student);
            return student;
        }
        return null;
    }


    public void deleteStudent(String email) {
        var student = findByEmail(email);
        if (student != null){
            _Students.remove(student);
        }

    }
}
