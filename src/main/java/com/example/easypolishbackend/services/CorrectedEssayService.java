package com.example.easypolishbackend.services;


import com.example.easypolishbackend.model.writtenForm.CorrectedEssay;
import com.example.easypolishbackend.repository.writtenForm.CorrectedEssayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CorrectedEssayService {
    private final CorrectedEssayRepository correctedessayRepository;

    @Autowired
    public CorrectedEssayService(CorrectedEssayRepository correctedessayRepository) {
        this.correctedessayRepository = correctedessayRepository;
    }

    public CorrectedEssay saveCorrectedEssay(CorrectedEssay correctedessay) {
        return correctedessayRepository.save(correctedessay);
    }

    public List<CorrectedEssay> getAllCorrectedEssays() {
        return correctedessayRepository.findAll();
    }

    public Optional<CorrectedEssay> getCorrectedEssayById(Long id) {
        return correctedessayRepository.findById(id);
    }

    public void deleteCorrectedEssay(Long id) {
        correctedessayRepository.deleteById(id);
    }
}
