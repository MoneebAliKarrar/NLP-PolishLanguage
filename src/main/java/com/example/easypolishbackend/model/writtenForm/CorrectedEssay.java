package com.example.easypolishbackend.model.writtenForm;

import com.example.easypolishbackend.model.WrittenForm;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "correctedessays")
public class CorrectedEssay extends WrittenForm {
    public CorrectedEssay() {
        super();
    }

    public CorrectedEssay(String title, String content) {
        super(title, content);
    }
}
