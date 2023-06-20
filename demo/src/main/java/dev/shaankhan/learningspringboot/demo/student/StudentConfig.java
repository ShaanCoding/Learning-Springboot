package dev.shaankhan.learningspringboot.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student shaan = new Student("Shaan", LocalDate.of(2000, 01, 01), "shaan@example.com");
            Student student = new Student("Shaan2", LocalDate.of(2001, 02, 02), "shaan2@example.com");

            repository.saveAll(
                    List.of(shaan, student)
            );
        };
    }
}
