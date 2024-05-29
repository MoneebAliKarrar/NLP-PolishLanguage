package com.example.easypolishbackend.services;

import com.example.easypolishbackend.model.writtenForm.Journal;
import com.example.easypolishbackend.repository.writtenForm.JournalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JournalService {
    private final JournalRepository journalRepository;

    @Autowired
    public JournalService(JournalRepository journalRepository) {
        this.journalRepository = journalRepository;
    }

    public Journal saveJournal(Journal journal) {
        return journalRepository.save(journal);
    }

    public List<Journal> getAllJournals() {
        return journalRepository.findAll();
    }

    public Optional<Journal> getJournalById(Long id) {
        return journalRepository.findById(id);
    }

    public void deleteJournal(Long id) {
        journalRepository.deleteById(id);
    }
}
