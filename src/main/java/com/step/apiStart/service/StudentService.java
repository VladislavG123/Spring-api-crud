package com.step.apiStart.service;

import com.step.apiStart.dao.StudentDao;
import com.step.apiStart.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class StudentService {
    private StudentDao studentDao;

    @Autowired
    public StudentService(@Qualifier("arrayListDao") StudentDao studentDao) {
        this.studentDao = studentDao;
    }


    public boolean createStudent(Student student){
        return studentDao.createStudent(student);
    }
    public Student getStudent(UUID id){
        return studentDao.getStudent(id);
    }
    public List<Student> getAllStudents(){
        return studentDao.getAllStudents();
    }
    public boolean updateStudent(Student student){
        return studentDao.updateStudent(student);
    }
    public boolean deleteStudent(UUID id){
        return studentDao.deleteStudent(id);
    }
}
