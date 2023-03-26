package com.company.hospitalmanagementsystem.services.inter;

import com.company.hospitalmanagementsystem.models.Payment;

import java.time.LocalDate;
import java.util.List;

public interface PaymentService {


    Payment getByFinCode(String finCode);

    void delete(long id);

    void save(Payment payment);

    List<Payment> getAllPayment(LocalDate localDate);
  void deleteAllList(List<Payment>list);
}
