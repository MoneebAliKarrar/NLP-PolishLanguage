package com.example.easypolishbackend.controllers;

import com.example.easypolishbackend.model.writtenForm.Email;
import com.example.easypolishbackend.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/emails")
public class EmailController {
    private final EmailService emailService;

    @Autowired
    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/save")
    public ResponseEntity<Email> saveEmail(@RequestBody Email email) {
        Email savedEmail = emailService.saveEmail(email);
        return ResponseEntity.ok(savedEmail);
    }

    @GetMapping
    public ResponseEntity<List<Email>> getAllEmails() {
        List<Email> emails = emailService.getAllEmails();
        return ResponseEntity.ok(emails);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Email> getEmailById(@PathVariable Long id) {
        return emailService.getEmailById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmail(@PathVariable Long id) {
        emailService.deleteEmail(id);
        return ResponseEntity.noContent().build();
    }
}
