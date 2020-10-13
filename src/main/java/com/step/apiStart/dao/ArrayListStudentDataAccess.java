package com.step.apiStart.dao;

import com.step.apiStart.model.Student;
import org.apache.catalina.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("arrayListDao")
public class ArrayListStudentDataAccess implements StudentDao {
    private static ArrayList<Student> students = new ArrayList<Student>();

    @Override
    public boolean createStudent(Student student) {
        if (hasDbSameId(student.getId())) {
            return false;
        }

        students.add(student);
        return true;
    }

    @Override
    public Student getStudent(UUID id) {
        for (var item: students) {
            if (item.getId().equals(id)) {
                return item;
            }
        }
        return null;
    }

    @Override
    public List<Student> getAllStudents() {
        return students;
    }

    private boolean hasDbSameId(UUID id) {
        return getAllStudents().stream().anyMatch(x -> x.getId().equals(id));
    }

    @Override
    public boolean updateStudent(Student student) {
        for (var item: students) {
            if (item.getId().equals(student.getId())){
                item.setName(student.getName());
                item.setGroup(student.getGroup());
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean deleteStudent(UUID id) {
        students.remove(getStudent(id));

        return true;
    }
}
