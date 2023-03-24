package com.company.hospitalmanagementsystem.controller;

import com.company.hospitalmanagementsystem.dto.AssistantDto;
import com.company.hospitalmanagementsystem.models.Assistant;
import com.company.hospitalmanagementsystem.services.impl.AssistantServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
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

    @CrossOrigin
    @GetMapping("/all")
    public ResponseEntity<List> getAllAssistant() {
        return ResponseEntity.ok(assistantService.getAllAssistant());
    }

    @CrossOrigin
    @PostMapping
    public ResponseEntity<AssistantDto> save(@RequestBody String assistant) {
        assistantService.save(objectMapper.convertValue(objectMapper
                .convertValue(assistant, AssistantDto.class), Assistant.class));
        return ResponseEntity.ok(objectMapper.convertValue(assistant, AssistantDto.class));
    }
    @CrossOrigin
    @PutMapping("/update")
    public void update(@RequestBody String assistant) {
        AssistantDto assistantDto = objectMapper.convertValue(assistant, AssistantDto.class);
        assistantService.updateCardId(assistantDto.getCardId(), assistantDto.getFinCode());
    }
    @CrossOrigin
    @DeleteMapping("/remove{id}")
    public void deleteById(@PathVariable("id") String finCode) {
        assistantService.delete(finCode);
    }
}