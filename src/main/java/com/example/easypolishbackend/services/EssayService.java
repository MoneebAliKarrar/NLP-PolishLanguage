package com.example.easypolishbackend.services;

import com.example.easypolishbackend.model.writtenForm.Essay;
import com.example.easypolishbackend.repository.writtenForm.EssayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EssayService {
    private final EssayRepository essayRepository;

    @Autowired
    public EssayService(EssayRepository essayRepository) {
        this.essayRepository = essayRepository;
    }

    public Essay saveEssay(Essay essay) {
        return essayRepository.save(essay);
    }

    public List<Essay> getAllEssays() {
        return essayRepository.findAll();
    }

    public Optional<Essay> getEssayById(Long id) {
        return essayRepository.findById(id);
    }

    public void deleteEssay(Long id) {
        essayRepository.deleteById(id);
    }
}
