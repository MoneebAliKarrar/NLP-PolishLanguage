package com.example.easypolishbackend.repository.writtenForm;

import com.example.easypolishbackend.model.writtenForm.Proposal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProposalRepository extends JpaRepository<Proposal, Long> {
}
