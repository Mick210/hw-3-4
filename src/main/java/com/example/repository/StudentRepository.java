package com.example.repository;

import com.example.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByAge(int age);

    Collection<Student> findStudentByAgeBetween(int min, int max);

    Student findStudentById(Long id);

    Collection<Student> findStudentsByFaculty_Id(Long id);
}