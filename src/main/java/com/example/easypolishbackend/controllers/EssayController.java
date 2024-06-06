package com.example.easypolishbackend.controllers;

import com.example.easypolishbackend.model.writtenForm.CorrectedEssay;
import com.example.easypolishbackend.model.writtenForm.Essay;
import com.example.easypolishbackend.services.CorrectedEssayService;
import com.example.easypolishbackend.services.EssayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/essays")
public class EssayController {
    private final EssayService essayService;
    private final RestTemplate restTemplate;

    private final CorrectedEssayService correctedEssayService;

    @Autowired
    public EssayController(EssayService essayService, RestTemplate restTemplate,CorrectedEssayService correctedEssayService) {
        this.essayService = essayService;
        this.correctedEssayService = correctedEssayService;
        this.restTemplate = restTemplate;
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

    @PostMapping("/correct")
    public ResponseEntity<Map<String, Object>> correctText(@RequestBody Map<String, Object> request) {
        List<String> sentences = (List<String>) request.get("sentences");

        // Prepare headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Prepare body
        Map<String, List<String>> body = new HashMap<>();
        body.put("sentences", sentences);

        // Create HttpEntity
        HttpEntity<Map<String, List<String>>> entity = new HttpEntity<>(body, headers);

        // Call the Python microservice from the localhost
        String url = "http://10.77.20.14:5000/correct";
        ResponseEntity<Map> response = restTemplate.exchange(url, HttpMethod.POST, entity, Map.class);
        Map<String, Object> correctedText = response.getBody();

        // Extract the corrected text
        List<String> correctedTextList = (List<String>) response.getBody() .get("correctedText");
        for (String sentence : correctedTextList){
            System.out.println(sentence);
        }
        String correctedTextString = String.join(" ", correctedTextList);

        // Create and save the CorrectedEssay object
        CorrectedEssay correctedEssay = new CorrectedEssay();
        correctedEssay.setTitle("Corrected Essay");
        correctedEssay.setContent(correctedTextString);

        correctedEssayService.saveCorrectedEssay(correctedEssay);

        return ResponseEntity.ok(correctedText);
    }
}
