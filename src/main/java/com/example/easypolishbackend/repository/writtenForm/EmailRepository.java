package com.example.easypolishbackend.repository.writtenForm;

import com.example.easypolishbackend.model.writtenForm.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailRepository extends JpaRepository<Email, Long> {
}
