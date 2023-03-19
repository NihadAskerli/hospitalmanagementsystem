package com.company.hospitalmanagementsystem.controller;

import com.company.hospitalmanagementsystem.dto.AssistantDto;
import com.company.hospitalmanagementsystem.models.Assistant;
import com.company.hospitalmanagementsystem.services.impl.AssistantServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/assistant")
@RequiredArgsConstructor
public class AssitantController {
    private final ObjectMapper objectMapper;
    @Autowired
    AssistantServiceImpl assistantService;

    @GetMapping("/all")
    public ResponseEntity<List> getAllAssistant() {
        return ResponseEntity.ok(assistantService.getAllAssistant());
    }

    @PostMapping("/add")
    public ResponseEntity<AssistantDto> addAssistant(@RequestBody String assistant) {
        assistantService.save(objectMapper.convertValue(objectMapper.convertValue(assistant, AssistantDto.class), Assistant.class));
        return ResponseEntity.ok(objectMapper.convertValue(assistant, AssistantDto.class));
    }

    @PutMapping("/update")
    public void update(@RequestBody String assistant) {
        AssistantDto assistantDto = objectMapper.convertValue(assistant, AssistantDto.class);
        assistantService.updateCardId(assistantDto.getCardId(), assistantDto.getFinCode());
    }
    @DeleteMapping("/remove{id}")
    public void deleteById(@PathVariable("id") String finCode) {
        assistantService.delete(finCode);
    }
}
