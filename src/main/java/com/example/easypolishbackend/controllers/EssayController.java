package com.example.easypolishbackend.controllers;

import com.example.easypolishbackend.model.writtenForm.Essay;
import com.example.easypolishbackend.services.EssayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/essays")
public class EssayController {
    private final EssayService essayService;

    @Autowired
    public EssayController(EssayService essayService) {
        this.essayService = essayService;
    }

    @PostMapping("/save")
    public ResponseEntity<Essay> saveEssay(@RequestBody Essay essay) {
        Essay savedEssay = essayService.saveEssay(essay);
        return ResponseEntity.ok(savedEssay);
    }

    @GetMapping
    public ResponseEntity<List<Essay>> getAllEssays() {
        List<Essay> essays = essayService.getAllEssays();
        return ResponseEntity.ok(essays);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Essay> getEssayById(@PathVariable Long id) {
        return essayService.getEssayById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEssay(@PathVariable Long id) {
        essayService.deleteEssay(id);
        return ResponseEntity.noContent().build();
    }
}
