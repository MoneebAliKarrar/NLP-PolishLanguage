package com.example.easypolishbackend.model.writtenForm;

import com.example.easypolishbackend.model.WrittenForm;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "reviews")
public class Review extends WrittenForm {
    public Review() {
        super();
    }

    public Review(String title, String content) {
        super(title, content);
    }
}
