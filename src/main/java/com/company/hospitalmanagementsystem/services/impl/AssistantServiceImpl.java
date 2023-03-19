package com.company.hospitalmanagementsystem.services.impl;

import com.company.hospitalmanagementsystem.models.Assistant;
import com.company.hospitalmanagementsystem.repo.AssistantRepository;
import com.company.hospitalmanagementsystem.services.inter.AssistantService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AssistantServiceImpl implements AssistantService{
    private final AssistantRepository assistantRepository;

    @Override
    public List<Assistant> getAllAssistant() {
        return assistantRepository.findAll();
    }

    @Override
    public Assistant getById(long id) {
        return assistantRepository.findById(id).get();
    }

    @Override
    public Assistant save(Assistant assistant) {
        return assistantRepository.save(assistant);
    }

    @Override
    public void delete(String id) {
        assistantRepository.delete(assistantRepository.getAssistantByFinCode(id));
    }

    @Override
    public void updateCardId(String cardId, String finCode) {
        assistantRepository.updateReservation(cardId, finCode);
    }
}
