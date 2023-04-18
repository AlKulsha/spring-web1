package ru.kulsha.springweb1.repository;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import ru.kulsha.springweb1.model.Student;

import java.util.*;

@Component
public class StudentRepository {
    private List<Student> students;
    @PostConstruct
    public void init(){
        students = new ArrayList<>(List.of(
                new Student(1L, "Alena", 38),
                new Student(2L, "Kira", 7),
                new Student(3L, "Yura", 38),
                new Student(4L, "Kos", 14)

        ));
    }

    public List<Student> getAllStudents(){
        return Collections.unmodifiableList(students);
    }

    public void deleteById(Long id){
        students.removeIf(s-> s.getId().equals(id));

    }

    public  Student findById(Long id){
        return students.stream().filter(s -> s.getId().equals(id)).findFirst()
                .orElseThrow(()-> new RuntimeException("The student with such id is not found"));
    }

    public void add(Student student) {
        students.add(student);
    }
}
