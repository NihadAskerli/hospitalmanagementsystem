package com.company.hospitalmanagementsystem.controller;

import com.company.hospitalmanagementsystem.dto.AssistantDto;
import com.company.hospitalmanagementsystem.models.Assistant;
import com.company.hospitalmanagementsystem.services.inter.AssistantService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/assistant")
@RequiredArgsConstructor
public class AssitantController {
    private final ObjectMapper objectMapper;

    @Autowired
    AssistantService assistantService;

    @GetMapping("/all")
    public ResponseEntity<List> getAllAssistant() {
        return ResponseEntity.ok(assistantService.getAllAssistant());
    }

    @PostMapping("/save")
    public ResponseEntity<AssistantDto> save(@RequestBody String assistant) throws JsonProcessingException {
        AssistantDto assistantDto = objectMapper.readValue(assistant, AssistantDto.class);
        return ResponseEntity.ok(objectMapper.convertValue(assistantService.save(objectMapper
                .convertValue(assistantDto, Assistant.class)), AssistantDto.class));

    }

    @PutMapping("/update/{fincode}")
    public void update(@PathVariable String finCode, @RequestBody String assistant) {

        assistantService.update(finCode,objectMapper.convertValue(assistant,Assistant.class));
    }

    @DeleteMapping("/remove{id}")
    public void deleteById(@PathVariable("id") String finCode) {
        assistantService.delete(finCode);
    }
}