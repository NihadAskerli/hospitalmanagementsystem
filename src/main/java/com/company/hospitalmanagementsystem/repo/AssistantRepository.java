package com.company.hospitalmanagementsystem.repo;


import com.company.hospitalmanagementsystem.models.Assistant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
public interface AssistantRepository extends JpaRepository<Assistant,Long> {
    @Modifying(clearAutomatically = true)
    @Transactional
    @Query(value = "update Assistant a set a.cardId = :cardId where a.finCode=:finCode")
    void updateReservation(@Param("cardId") String cardId,@Param("finCode")String finCode);
    Assistant getAssistantByFinCode(String finCode);
}
