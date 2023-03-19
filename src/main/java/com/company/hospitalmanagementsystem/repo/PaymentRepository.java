package com.company.hospitalmanagementsystem.repo;

import com.company.hospitalmanagementsystem.models.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment,Long> {
}
