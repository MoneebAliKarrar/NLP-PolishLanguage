package com.example.easypolishbackend.model.writtenForm;

import com.example.easypolishbackend.model.WrittenForm;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "journals")
public class Journal extends WrittenForm {
    public Journal() {
        super();
    }

    public Journal(String title, String content) {
        super(title, content);
    }
}
