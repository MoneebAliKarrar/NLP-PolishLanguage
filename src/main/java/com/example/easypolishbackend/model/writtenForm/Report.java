package com.example.easypolishbackend.model.writtenForm;

import com.example.easypolishbackend.model.WrittenForm;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "reports")
public class Report extends WrittenForm {
    public Report() {
        super();
    }

    public Report(String title, String content) {
        super(title, content);
    }
}
