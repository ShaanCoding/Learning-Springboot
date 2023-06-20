package dev.shaankhan.learningspringboot.demo.student;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.util.List;

@Service
public class StudentService {
    public List<Student> getStudents() {
        return List.of(
                new Student(1, "Shaan", 22, LocalDate.of(2000, 01, 01), "shaan@example.com")
        );
    }
}
