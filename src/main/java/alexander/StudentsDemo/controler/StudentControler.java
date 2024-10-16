package alexander.StudentsDemo.controler;


import alexander.StudentsDemo.model.Student;
import alexander.StudentsDemo.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
@AllArgsConstructor
public class StudentControler {

    private final StudentService studentService;

    @GetMapping
    public List<Student> findAllStudents(){
       return  studentService.findAllStudent();
    }
    @PostMapping("save-student")
    public Student saveStudent (@RequestBody Student student){
        return studentService.saveStudent(student);
    }
    @GetMapping("/{email}")
    public Student findByEmail(@PathVariable String email){
        return studentService.findByEmail(email);
    }
    @PutMapping("update_student")
    public Student updateStudent(@PathVariable Student student){
        return studentService.updateStudent(student);
    }
    @DeleteMapping("delete_student/{email}")
    public void deleteStudent(@PathVariable String email){
        studentService.deleteStudent(email);
    }
}
