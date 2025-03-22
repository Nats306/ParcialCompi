package com.example.parcialcompiladores.DTO;

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
    private String model;
    private Integer capacity;
    private String owner_id; // Almacena el ID del dueño en lugar del objeto completo
}
