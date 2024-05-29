package com.example.easypolishbackend.model.writtenForm;

import com.example.easypolishbackend.model.WrittenForm;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "essays")
public class Essay extends WrittenForm {
    public Essay() {
        super();
    }

    public Essay(String title, String content) {
        super(title, content);
    }
}
