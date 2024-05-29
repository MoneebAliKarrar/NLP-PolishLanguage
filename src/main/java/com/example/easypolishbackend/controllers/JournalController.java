package com.example.easypolishbackend.controllers;

import com.example.easypolishbackend.model.writtenForm.Journal;
import com.example.easypolishbackend.services.JournalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/journals")
public class JournalController {
    private final JournalService journalService;

    @Autowired
    public JournalController(JournalService journalService) {
        this.journalService = journalService;
    }

    @PostMapping("/save")
    public ResponseEntity<Journal> saveJournal(@RequestBody Journal journal) {
        Journal savedJournal = journalService.saveJournal(journal);
        return ResponseEntity.ok(savedJournal);
    }

    @GetMapping
    public ResponseEntity<List<Journal>> getAllJournals() {
        List<Journal> journals = journalService.getAllJournals();
        return ResponseEntity.ok(journals);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Journal> getJournalById(@PathVariable Long id) {
        return journalService.getJournalById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJournal(@PathVariable Long id) {
        journalService.deleteJournal(id);
        return ResponseEntity.noContent().build();
    }
}
