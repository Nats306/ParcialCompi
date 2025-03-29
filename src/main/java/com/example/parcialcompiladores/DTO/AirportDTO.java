package com.example.parcialcompiladores.DTO;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AirportDTO {
    private String id;

    @NotBlank(message = "El nombre no puede estar vacío")
    private String name;

    @NotBlank(message = "La locación no puede estar vacía")
    private String location;

    @NotNull(message = "Capacity cannot be null")
    @Min(value = 0, message = "La capacidad no puede ser negativa")
    private int capacity;

    private String owners= "Sofia and Natalia the best owners";
}
