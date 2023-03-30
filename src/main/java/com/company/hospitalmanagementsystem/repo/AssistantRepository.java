package com.company.hospitalmanagementsystem.repo;


import com.company.hospitalmanagementsystem.models.Assistant;
import com.company.hospitalmanagementsystem.models.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
public interface AssistantRepository extends JpaRepository<Assistant,Long> {

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("update Assistant a set a.cardId = ?2 where a.finCode = ?1")
    void updateAssistant(@Param("finCode") String finCode,@Param("chatId")String chatId);
    Assistant getAssistantByFinCode(String finCode);

    Assistant getByFinCode(String finCode);

}