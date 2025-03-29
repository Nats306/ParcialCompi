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
public class PrivateJetDTO {

    private String id;
    @NotBlank(message = "El modelo del jet privado no puese estar vacío")
    private String model;
    @NotNull(message = "La capacidad del jet privado no puede ser nula")
    @Min(value = 0, message = "La capacidad no puede ser negativa")
    private Integer capacity;
    private String owner_id; // Almacena el ID del dueño en lugar del objeto completo
}
