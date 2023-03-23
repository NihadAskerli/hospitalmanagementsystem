package com.company.hospitalmanagementsystem.services.impl;

import com.company.hospitalmanagementsystem.exception.PaymentException;
import com.company.hospitalmanagementsystem.models.Payment;
import com.company.hospitalmanagementsystem.repo.PaymentRepository;
import com.company.hospitalmanagementsystem.services.inter.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    DoctorServiceImpl doctorService;
    private Pattern cardId = Pattern.compile("^[0-9]*$");
    private static Logger logger = LogManager.getLogger(PaymentServiceImpl.class);
    private final PaymentRepository paymentRepository;

    public Payment payment(String finCode) {
        return paymentRepository.getByFinCode(finCode);
    }

    @Override
    public Payment getByFinCode(String finCode) {
        return paymentRepository.getByFinCode(finCode);
    }


    @Override
    public void delete(long id) {
        paymentRepository.delete(paymentRepository.findById(id).get());
    }


}
