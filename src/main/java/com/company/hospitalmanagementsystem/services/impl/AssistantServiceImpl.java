package com.company.hospitalmanagementsystem.services.impl;

import com.company.hospitalmanagementsystem.models.Assistant;
import com.company.hospitalmanagementsystem.repo.AssistantRepository;
import com.company.hospitalmanagementsystem.services.inter.AssistantService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class AssistantServiceImpl implements AssistantService {
    private final AssistantRepository assistantRepository;

    @Override
    public List<Assistant> getAllAssistant() {
        return assistantRepository.findAll();
    }

    @Override
    public Assistant getByFinCode(String finCode) {
        return assistantRepository.getByFinCode(finCode);
    }


    @Override
    public Assistant save(Assistant assistant) {
        return assistantRepository.save(assistant);
    }

    @Override
    public void delete(String finCode) {
        assistantRepository.delete(assistantRepository.getByFinCode(finCode));
    }

    @Override
    public void update(String finCode, Assistant assistant) {
        assistantRepository.updateAssistant(finCode, assistant.getCardId());
    }


}