package com.example.service;

import com.example.model.Faculty;
import com.example.repository.FacultyRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class FacultyService {

    private final FacultyRepository facultyRepository;

    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    public Faculty addFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    public Faculty findFaculty(Long id) {
        return facultyRepository.findById(id).get();
    }

    public Faculty editFaculty(Faculty faculty) {
        if (facultyRepository.findById(faculty.getId()).isEmpty()) {
            return null;
        }
        return facultyRepository.save(faculty);
    }

    public Faculty deleteFaculty(long id) {
        Faculty faculty = findFaculty(id);
        if (faculty != null) {
            facultyRepository.deleteById(id);
        }
        return faculty;
    }

    public Collection<Faculty> findByColor(String color) {
        return facultyRepository.findByColor(color);
    }

    public Faculty findFirstFacultyByNameIgnoreCase(String name) {
        return facultyRepository.findFirstFacultyByNameIgnoreCase(name);
    }

    public Faculty findFirstFacultyByColorIgnoreCase(String color) {
        return facultyRepository.findFirstFacultyByColorIgnoreCase(color);
    }

    public Faculty findFacultyByStudentId(Long id) {
        return facultyRepository.findFacultyByStudentId(id);
    }
}