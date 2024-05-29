package com.example.easypolishbackend.model.writtenForm;

import com.example.easypolishbackend.model.WrittenForm;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "resumes")
public class Resume extends WrittenForm {
    public Resume() {
        super();
    }

    public Resume(String title, String content) {
        super(title, content);
    }
}
