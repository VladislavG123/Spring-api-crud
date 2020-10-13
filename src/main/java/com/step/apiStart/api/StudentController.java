package com.step.apiStart.api;

import com.step.apiStart.model.Student;
import com.step.apiStart.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RequestMapping("api/v1/student")
@RestController
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {

        this.studentService = studentService;
    }

    @GetMapping("test")
    public String test(){
        return "It is working";
    }

    @GetMapping("all")
    public List<Student> getUsersAction(){
        return studentService.getAllStudents();
    }

    @GetMapping(path = "{id}")
    public Student getUserById(@PathVariable UUID id) {
        return studentService.getStudent(id);
    }

    @PostMapping()
    public void createUser(@RequestParam String name, @RequestParam String group) {
        studentService.createStudent(new Student(UUID.randomUUID(), name, group));
    }

    @PutMapping(path = "{id}")
    public void update(@PathVariable UUID id, @RequestParam String name, @RequestParam String group) {
        studentService.updateStudent(new Student(id, name, group));
    }

    @DeleteMapping(path = "{id}")
    public void delete(@PathVariable UUID id) {
        studentService.deleteStudent(id);
    }
}
