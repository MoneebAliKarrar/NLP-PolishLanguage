package com.example.easypolishbackend.controllers;

import com.example.easypolishbackend.model.writtenForm.CorrectedEssay;
import com.example.easypolishbackend.services.CorrectedEssayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


import java.util.List;

@RestController
@RequestMapping("/api/correctedessays")
public class CorrectedEssayController {
    private final CorrectedEssayService correctedessayService;
    private final RestTemplate restTemplate;

    @Autowired
    public CorrectedEssayController(CorrectedEssayService correctedessayService, RestTemplate restTemplate) {
        this.correctedessayService = correctedessayService;
        this.restTemplate = restTemplate;
    }

    @GetMapping
    public ResponseEntity<List<CorrectedEssay>> getAllCorrectedEssays() {
        List<CorrectedEssay> correctedessays = correctedessayService.getAllCorrectedEssays();
        return ResponseEntity.ok(correctedessays);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CorrectedEssay> getCorrectedEssayById(@PathVariable Long id) {
        return correctedessayService.getCorrectedEssayById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCorrectedEssay(@PathVariable Long id) {
        correctedessayService.deleteCorrectedEssay(id);
        return ResponseEntity.noContent().build();
    }
}
