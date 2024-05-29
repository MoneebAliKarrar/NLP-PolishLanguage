package com.example.easypolishbackend.repository.writtenForm;

import com.example.easypolishbackend.model.writtenForm.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
}
