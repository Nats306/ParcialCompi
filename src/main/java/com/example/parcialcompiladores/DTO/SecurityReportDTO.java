package com.example.parcialcompiladores.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SecurityReportDTO {
    private String id;

    @NotBlank(message = "Se debe poner quien hizo el reporte")
    private String reported_by;

    @NotBlank(message = "La descripción no puede ser nula")
    private String description;
    private boolean resolved=false;
    private String flight_id; // Se almacena solo el ID del vuelo en lugar del objeto completo
}
