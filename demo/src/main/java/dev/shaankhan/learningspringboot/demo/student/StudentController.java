package dev.shaankhan.learningspringboot.demo.student;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path="/api/v1/student")
public class StudentController {
//    @GetMapping("/")
//    public String hello() {
//        return "Hello World!";
//    }
//
//    @GetMapping("/list")
//    public List<String> helloList() {
//        return List.of("Hello", "World");
//    }

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/")
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    @PostMapping("/")
    public void newStudent(@RequestBody Student student) {
        studentService.addNewStudent(student);
    }

    @DeleteMapping("/{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long id) {
        studentService.deleteStudent(id);
    }

    @PutMapping("/{studentId}")
    public void putStudent(@PathVariable("studentId") Long studentId, @RequestParam(required = false) String name, @RequestParam(required = false) String email) {
        studentService.putStudent(studentId, name, email);
    }
}
