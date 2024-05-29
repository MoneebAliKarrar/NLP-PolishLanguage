package com.example.easypolishbackend.repository.writtenForm;

import com.example.easypolishbackend.model.writtenForm.Resume;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResumeRepository extends JpaRepository<Resume, Long> {
}
