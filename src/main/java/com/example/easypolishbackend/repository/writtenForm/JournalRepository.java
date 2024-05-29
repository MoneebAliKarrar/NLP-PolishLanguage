package com.example.easypolishbackend.repository.writtenForm;

import com.example.easypolishbackend.model.writtenForm.Journal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JournalRepository extends JpaRepository<Journal, Long> {
}
