package com.company.hospitalmanagementsystem.repo;

import com.company.hospitalmanagementsystem.models.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface PaymentRepository extends JpaRepository<Payment,Long> {
    Payment getByFinCode(String finCode);
//    @Modifying(clearAutomatically = true)
//    @Transactional
//    @Query(value = "update Payment p set p.id = :id where p.finCode=:finCode")
//    void updateReservation(@Param("id") String id, @Param("finCode")String finCode);
}
