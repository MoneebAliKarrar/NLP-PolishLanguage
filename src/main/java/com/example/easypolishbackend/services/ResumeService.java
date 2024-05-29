package com.example.easypolishbackend.services;

import com.example.easypolishbackend.model.writtenForm.Resume;
import com.example.easypolishbackend.repository.writtenForm.ResumeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResumeService {
    private final ResumeRepository resumeRepository;

    @Autowired
    public ResumeService(ResumeRepository resumeRepository) {
        this.resumeRepository = resumeRepository;
    }

    public Resume saveResume(Resume resume) {
        return resumeRepository.save(resume);
    }

    public List<Resume> getAllResumes() {
        return resumeRepository.findAll();
    }

    public Optional<Resume> getResumeById(Long id) {
        return resumeRepository.findById(id);
    }

    public void deleteResume(Long id) {
        resumeRepository.deleteById(id);
    }
}
