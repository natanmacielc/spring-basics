package br.com.dev.spring.essentials.domain.services;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Exemplo {
    String stringType;
    Long longType;
    Integer intType;
    Boolean booleanType;
    LocalDate startDate;
    LocalDate endDate;
    LocalDateTime registrationDate;


    public String getStringType() {
        return stringType;
    }

    public void setStringType(String stringType) {
        this.stringType = stringType;
    }

    public Long getLongType() {
        return longType;
    }

    public void setLongType(Long longType) {
        this.longType = longType;
    }

    public Integer getIntType() {
        return intType;
    }

    public void setIntType(Integer intType) {
        this.intType = intType;
    }

    public Boolean getBooleanType() {
        return booleanType;
    }

    public void setBooleanType(Boolean booleanType) {
        this.booleanType = booleanType;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }
}
