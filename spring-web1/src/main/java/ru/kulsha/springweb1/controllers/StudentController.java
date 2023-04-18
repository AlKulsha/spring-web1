package ru.kulsha.springweb1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kulsha.springweb1.model.Student;
import ru.kulsha.springweb1.repository.StudentRepository;
import ru.kulsha.springweb1.services.StudentService;

import java.util.List;

@RestController
public class StudentController {
    private StudentService service;
    @Autowired
    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping("/students")
    public List<Student> getAllStudents(){
        return service.getAllStudents();
    }

    @GetMapping("/students/delete/{id}")
    public void deleteById(@PathVariable Long id){
        service.deleteById(id);
    }

    @GetMapping("/students/change_age")
    public void changeAge(@PathVariable Long id){
        service.changeAge(id);
    }
    @GetMapping("stud_add")
    public String addStudent(@RequestParam Long id, @RequestParam String name, @RequestParam Integer age){
        Student student = new Student(id, name, age);
        service.add(student);
        return "redirect:/students";
    }

}
