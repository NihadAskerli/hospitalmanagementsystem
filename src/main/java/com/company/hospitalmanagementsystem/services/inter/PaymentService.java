package com.company.hospitalmanagementsystem.services.inter;

import com.company.hospitalmanagementsystem.models.Payment;

import java.util.List;

public interface PaymentService {


    Payment getByFinCode(String finCode);

    void delete(long id);

}
