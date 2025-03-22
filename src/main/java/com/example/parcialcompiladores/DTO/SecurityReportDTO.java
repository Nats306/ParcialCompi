package com.example.parcialcompiladores.DTO;

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
    private String reported_by;
    private String description;
    private boolean is_resolved;
    private String flight_id; // Se almacena solo el ID del vuelo en lugar del objeto completo
}
