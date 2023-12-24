package com.example.service;

import com.example.model.Faculty;
import com.example.model.Student;
import com.example.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

@Service
public class StudentService {
    private final HashMap<Long, Student> students = new HashMap<>();

    private final StudentRepository studentRepository;
    private long count = 0;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student addStudent(Student student) {
        student.setId(count++);
        students.put(student.getId(), student);
        return student;
    }

    public Student findStudent(long id) {
        return students.get(id);
    }

    public Student editStudent(Student student) {
        if (!students.containsKey(student.getId())) {
            return null;
        }
        students.put(student.getId(), student);
        return student;
    }

    public Student deleteStudent(long id) {
        return students.remove(id);
    }

    public Collection<Student> findByAge(int age) {
        ArrayList<Student> result = new ArrayList<>();
        for (Student student : students.values()) {
            if (student.getAge() == age) {
                result.add(student);
            }
        }
        return result;
    }

    public Collection<Student> findStudentByAgeBetween(int min, int max) {
        return studentRepository.findStudentByAgeBetween(min, max);
    }

    public Faculty getFacultyOfStudent(Long id) {
        Student student = studentRepository.findStudentById(id);
        if (student == null) {
            return null;
        }
        return studentRepository.findStudentById(id).getFaculty();
    }

    public Collection<Student> getStudentsOfFaculty(Long id) {
        return studentRepository.findStudentsByFaculty_Id(id);
    }
}