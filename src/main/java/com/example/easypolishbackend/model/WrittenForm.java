package com.example.easypolishbackend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@MappedSuperclass
@Data
public abstract class WrittenForm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 100)
    private String title;

    @NotBlank
    @Size(max = 5000)
    @Lob
    private String content;

    public WrittenForm() {}

    public WrittenForm(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
