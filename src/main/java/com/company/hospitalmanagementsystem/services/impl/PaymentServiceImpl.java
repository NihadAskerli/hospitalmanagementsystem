package com.company.hospitalmanagementsystem.services.impl;

import com.company.hospitalmanagementsystem.models.Payment;
import com.company.hospitalmanagementsystem.repo.PaymentRepository;
import com.company.hospitalmanagementsystem.services.inter.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {
    private final PaymentRepository paymentRepository;

    @Override
    public List<Payment> getAllPayment() {
        return paymentRepository.findAll();
    }

    @Override
    public Payment getById(long id) {
        return paymentRepository.findById(id).get();
    }

    @Override
    public Payment save(Payment payment) {
        return paymentRepository.save(payment);
    }

    @Override
    public void delete(long id) {
        paymentRepository.delete(paymentRepository.findById(id).get());
    }

    @Override
    public void update(long id) {

    }
}
