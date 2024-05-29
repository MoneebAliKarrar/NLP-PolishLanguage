package com.example.easypolishbackend.controllers;

import com.example.easypolishbackend.model.writtenForm.Proposal;
import com.example.easypolishbackend.services.ProposalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/proposals")
public class ProposalController {
    private final ProposalService proposalService;

    @Autowired
    public ProposalController(ProposalService proposalService) {
        this.proposalService = proposalService;
    }

    @PostMapping("/save")
    public ResponseEntity<Proposal> saveProposal(@RequestBody Proposal proposal) {
        Proposal savedProposal = proposalService.saveProposal(proposal);
        return ResponseEntity.ok(savedProposal);
    }

    @GetMapping
    public ResponseEntity<List<Proposal>> getAllProposals() {
        List<Proposal> proposals = proposalService.getAllProposals();
        return ResponseEntity.ok(proposals);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Proposal> getProposalById(@PathVariable Long id) {
        return proposalService.getProposalById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProposal(@PathVariable Long id) {
        proposalService.deleteProposal(id);
        return ResponseEntity.noContent().build();
    }
}
