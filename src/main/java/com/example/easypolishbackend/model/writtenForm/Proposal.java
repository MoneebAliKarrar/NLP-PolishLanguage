package com.example.easypolishbackend.model.writtenForm;

import com.example.easypolishbackend.model.WrittenForm;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "proposals")
public class Proposal extends WrittenForm {
    public Proposal() {
        super();
    }

    public Proposal(String title, String content) {
        super(title, content);
    }
}
