package com.company.hospitalmanagementsystem.services.inter;

import com.company.hospitalmanagementsystem.models.Payment;

import java.util.List;

public interface PaymentService {
    List<Payment> getAllPayment();

    Payment getById(long id);

    Payment save(Payment payment);

    void delete(long id);

    void update(long id);
}
