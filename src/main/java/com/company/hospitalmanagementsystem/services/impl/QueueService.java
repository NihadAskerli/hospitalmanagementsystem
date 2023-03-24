package com.company.hospitalmanagementsystem.services.impl;

import com.company.hospitalmanagementsystem.exception.PaymentException;
import com.company.hospitalmanagementsystem.models.Examination;
import com.company.hospitalmanagementsystem.models.Payment;
import com.company.hospitalmanagementsystem.repo.ExaminationRepository;
import com.company.hospitalmanagementsystem.repo.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor
public class QueueService {
    private final ExaminationRepository examinationRepository;
    private final PaymentRepository paymentRepository;
    private Pattern cardId = Pattern.compile("^[0-9]*$");

    private static final Logger logger = LogManager.getLogger(QueueService.class);


    @Transactional
    public String queueSave(Examination examination, Payment payment) {
        if (cardId.matcher(payment.getCardId()).matches() && payment.getCardId().length() == 16 && payment.getFinCode().length() == 7 && payment.getPay().compareTo(BigDecimal.valueOf(30l)) == 0) {
            paymentRepository.save(payment);
            examinationRepository.save(examination);
            return null;
        } else {
            try {
                throw new PaymentException(" verilenleri duzgun daxil edin: ", "112");
            } catch (PaymentException e) {

                String errorMessage = "Ödeme zamanı xəta oluşdu: " + e.getMessage();

                logger.error(errorMessage, e.getMessage());
                return null;
            }
        }
    }
}
