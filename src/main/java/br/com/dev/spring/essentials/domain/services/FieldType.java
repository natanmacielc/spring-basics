package br.com.dev.spring.essentials.domain.services;

import java.time.LocalDate;
import java.time.LocalDateTime;

public enum FieldType {
    STRING("1", "string"),
    INTEGER(1, "integer"),
    LONG(1L, "long"),
    BOOLEAN(false, "boolean"),
    START_DATE(LocalDate.now(), "startDate"),
    END_DATE(LocalDate.now().plusYears(2), "endDate"),
    REGISTRATION_DATE(LocalDateTime.now(), "registrationDate");

    Object value;
    String name;

    FieldType(Object value, String name) {
        this.value = value;
        this.name = name;
    }

    public Object getValue() {
        return this.value;
    }

    public String getName() {
        return this.name;
    }
}
