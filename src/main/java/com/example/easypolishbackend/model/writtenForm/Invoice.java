package com.example.easypolishbackend.model.writtenForm;

import com.example.easypolishbackend.model.WrittenForm;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "invoices")
public class Invoice extends WrittenForm {
    public Invoice() {
        super();
    }

    public Invoice(String title, String content) {
        super(title, content);
    }
}
