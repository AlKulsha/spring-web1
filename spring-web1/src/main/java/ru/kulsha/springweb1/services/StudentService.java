package ru.kulsha.springweb1.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kulsha.springweb1.model.Student;
import ru.kulsha.springweb1.repository.StudentRepository;

import java.util.List;

@Service
public class StudentService {
    private StudentRepository repository;
    @Autowired
    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }
    public List<Student> getAllStudents(){
        return repository.getAllStudents();
    }

    public void deleteById(Long id){
        repository.deleteById(id);
    }

    public void changeAge(Long id) {
        Student student = repository.findById(id);
        student.setAge(student.getAge() + 1);
    }

    public void add(Student student) {
        repository.add(student);
    }
}
