package com.example.easypolishbackend.services;

import com.example.easypolishbackend.model.writtenForm.Email;
import com.example.easypolishbackend.repository.writtenForm.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmailService {
    private final EmailRepository emailRepository;

    @Autowired
    public EmailService(EmailRepository emailRepository) {
        this.emailRepository = emailRepository;
    }

    public Email saveEmail(Email email) {
        return emailRepository.save(email);
    }

    public List<Email> getAllEmails() {
        return emailRepository.findAll();
    }

    public Optional<Email> getEmailById(Long id) {
        return emailRepository.findById(id);
    }

    public void deleteEmail(Long id) {
        emailRepository.deleteById(id);
    }
}
