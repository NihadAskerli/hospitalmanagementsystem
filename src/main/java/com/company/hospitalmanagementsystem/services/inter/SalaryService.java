package com.company.hospitalmanagementsystem.services.inter;

import java.math.BigDecimal;

public interface SalaryService {
    void save(String cardId, BigDecimal salary);
}
