package com.example.easypolishbackend.model.writtenForm;

import com.example.easypolishbackend.model.WrittenForm;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "emails")
public class Email extends WrittenForm {
    public Email() {
        super();
    }

    public Email(String title, String content) {
        super(title, content);
    }
}
