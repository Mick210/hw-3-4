package com.example.repository;

import com.example.model.Avatar;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;

public interface AvatarRepository extends JpaRepository<Avatar, Long> {
    Optional<Avatar> findByStudentId(Long studentId);

    void deleteByStudentId(Long studentId);
}