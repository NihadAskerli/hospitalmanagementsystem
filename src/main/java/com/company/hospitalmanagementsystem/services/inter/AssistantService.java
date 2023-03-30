package com.company.hospitalmanagementsystem.services.inter;

import com.company.hospitalmanagementsystem.models.Assistant;
import org.joda.time.field.StrictDateTimeField;

import java.util.List;

public interface AssistantService {
    List<Assistant> getAllAssistant();

    Assistant getByFinCode(String finCode);

    Assistant save(Assistant assistant);

    void delete(String finCode);

    void update(String finCode,Assistant assistant);
}
