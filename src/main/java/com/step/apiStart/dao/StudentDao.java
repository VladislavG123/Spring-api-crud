package com.step.apiStart.dao;

import com.step.apiStart.model.Student;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface StudentDao {
    boolean createStudent(Student student);
    Student getStudent(UUID id);
    List<Student> getAllStudents();
    boolean updateStudent(Student student);
    boolean deleteStudent(UUID id);
}
