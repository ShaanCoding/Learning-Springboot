package dev.shaankhan.learningspringboot.demo.student;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {

        Optional<Student> doesEmailExist = studentRepository.findStudentByEmail(student.getEmail());

        if (doesEmailExist.isPresent()) {
            throw new IllegalStateException("Email already taken!");

        }

        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
        boolean doesStudentIdExist = studentRepository.existsById(studentId);
        if (!doesStudentIdExist) {
            throw new IllegalStateException("Student with ID: " + studentId + " does not exist!");
        }

        studentRepository.deleteById(studentId);
    }

    @Transactional
    public void putStudent(Long studentId, String name, String email) {

        Student student = studentRepository.findById(studentId).orElseThrow(() ->
                new IllegalStateException("Student with ID: " + studentId + " does not exist!"));

        if (name != null && name.length() > 0 && !Objects.equals(student.getName(), name)) {
            student.setName(name);
        }


        if (email != null && email.length() > 0 && !Objects.equals(student.getEmail(), email)) {
            student.setEmail(email);
        }


    }
}
