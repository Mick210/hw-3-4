package service;

import model.Student;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class StudentService {
    private final HashMap<Long, Student> students = new HashMap<>();
    private long count = 0;

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
}