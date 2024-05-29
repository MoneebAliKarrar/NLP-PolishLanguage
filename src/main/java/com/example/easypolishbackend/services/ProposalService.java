package com.example.easypolishbackend.services;

import com.example.easypolishbackend.model.writtenForm.Proposal;
import com.example.easypolishbackend.repository.writtenForm.ProposalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProposalService {
    private final ProposalRepository proposalRepository;

    @Autowired
    public ProposalService(ProposalRepository proposalRepository) {
        this.proposalRepository = proposalRepository;
    }

    public Proposal saveProposal(Proposal proposal) {
        return proposalRepository.save(proposal);
    }

    public List<Proposal> getAllProposals() {
        return proposalRepository.findAll();
    }

    public Optional<Proposal> getProposalById(Long id) {
        return proposalRepository.findById(id);
    }

    public void deleteProposal(Long id) {
        proposalRepository.deleteById(id);
    }
}
