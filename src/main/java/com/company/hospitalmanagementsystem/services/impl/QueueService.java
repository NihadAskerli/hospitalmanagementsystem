package com.company.hospitalmanagementsystem.services.impl;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.company.hospitalmanagementsystem.config.JWTToPrincipalConverter;
import com.company.hospitalmanagementsystem.dto.QueueDto;
import com.company.hospitalmanagementsystem.exception.PaymentException;
import com.company.hospitalmanagementsystem.models.Examination;
import com.company.hospitalmanagementsystem.models.Payment;
import com.company.hospitalmanagementsystem.repo.ExaminationRepository;
import com.company.hospitalmanagementsystem.repo.PaymentRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor
public class QueueService {
    private final ObjectMapper objectMapper;
    private final ExaminationRepository examinationRepository;
    private final PaymentRepository paymentRepository;
    private final DoctorServiceImpl doctorService;
    private Pattern cardId = Pattern.compile("^[0-9]*$");

    private static final Logger logger = LogManager.getLogger(QueueService.class);


    @Transactional
    public String queueSave(Examination examination, Payment payment) {
        if (payment.getPay()!=null && payment.getCardId()!=null && cardId.matcher(payment.getCardId()).matches() && payment.getCardId().length() == 16  && cardId.matcher(payment.getCVV()).matches() &&
                 payment.getPay().compareTo(BigDecimal.valueOf(doctorService.getByFinCode(examination.getDoctorFinCode()).getExaminationPay())) == 0) {

            examinationRepository.save(examination);
            paymentRepository.save(payment);
            return "Ödenişiniz uğurla yerine yetirildi";
        } else {
            try {
                throw new PaymentException(" verilenleri duzgun daxil edin: ", "112");
            } catch (PaymentException e) {

                String errorMessage = "Ödeme zamanı xəta oluşdu: " + e.getMessage();

                logger.error(errorMessage, e.getMessage());
                return errorMessage;
            }
        }
    }
    public String convertDate(String date) throws ParseException {
        String inputDate = date;
        SimpleDateFormat inputFormat = new SimpleDateFormat("MM/dd/yyyy");
        SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");
        String outputDate = null;
        try {
            Date date1 = inputFormat.parse(inputDate);
            outputDate = outputFormat.format(date1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return outputDate;
    }
    public QueueDto convertQueueDto(String jsonString) throws JsonProcessingException {
        QueueDto queueDto=objectMapper.readValue(jsonString, QueueDto.class);
        return queueDto;
    }
}