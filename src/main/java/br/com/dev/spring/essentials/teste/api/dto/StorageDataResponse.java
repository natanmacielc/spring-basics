package br.com.dev.spring.essentials.teste.api.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StorageDataResponse {

    private Long position;

    private String name;

    private String description;

    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy hh:MM:ss")
    private LocalDateTime registrationDate;
}
